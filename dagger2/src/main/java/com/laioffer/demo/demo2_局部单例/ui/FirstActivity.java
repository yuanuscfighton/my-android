package com.laioffer.demo.demo2_局部单例.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.laioffer.dagger2.R;
import com.laioffer.demo.demo2_局部单例.component.DaggerObjComponents;
import com.laioffer.demo.demo2_局部单例.obj.HttpObject;

import javax.inject.Inject;

/**
 * @description:
 * @date: 2022/9/18 10:52 下午
 */
public class FirstActivity extends AppCompatActivity {

  public static final String TAG = FirstActivity.class.getSimpleName();

  @Inject
  HttpObject mHttpObject1;
  @Inject
  HttpObject mHttpObject2;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.empty_layout);

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

    // 验证: 注入的两个对象的实例是否是单例的
    Log.e(TAG, "obj1: " + mHttpObject1.hashCode());
    Log.e(TAG, "obj2: " + mHttpObject2.hashCode());

  }

  private void startSecondActivity() {
    Intent intent = new Intent(this, SecondActivity.class);
    startActivity(intent);
  }
}
