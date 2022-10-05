package com.laioffer.enjoy.demo3_局部单例.ui;

import javax.inject.Inject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.laioffer.dagger2.R;
import com.laioffer.enjoy.demo3_局部单例.component.DaggerObjComponents;
import com.laioffer.enjoy.demo3_局部单例.obj.HttpObject;

/**
 * @description
 * @date 2022/9/18 10:52 下午
 */
public class FirstActivity extends AppCompatActivity {

  public static final String TAG = "[demo3_局部单例]" + FirstActivity.class.getSimpleName();

  @Inject
  HttpObject mHttpObject1;
  @Inject
  HttpObject mHttpObject2;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.simple_button_layout);

    // 方式1
    DaggerObjComponents.create().injectFirstActivity(this);

    // 方式2，不推荐 ⚠️
    /*
    DaggerObjComponents.builder()
        .httpModule(new HttpModule())
        .databaseModule(new DatabaseModule())
        .build()
        .injectFirstActivity(this);
    */

    // 验证: 注入的两个对象的实例是否是单例的 ==> 局部单例，即切到SecondActivity的时候，mHttpObject实例不是同一个了
    Log.e(TAG, "obj1: " + mHttpObject1.hashCode()); // 195911031
    Log.e(TAG, "obj2: " + mHttpObject2.hashCode()); // 195911031

    findViewById(R.id.button1).setOnClickListener(v -> {
      startSecondActivity();
    });

  }

  private void startSecondActivity() {
    Intent intent = new Intent(this, SecondActivity.class);
    startActivity(intent);
  }
}
