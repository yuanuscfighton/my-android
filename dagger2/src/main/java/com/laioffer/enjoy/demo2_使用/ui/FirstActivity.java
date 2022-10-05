package com.laioffer.enjoy.demo2_使用.ui;

import javax.inject.Inject;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.laioffer.dagger2.R;
import com.laioffer.enjoy.demo2_使用.component.DaggerObjComponents;
import com.laioffer.enjoy.demo2_使用.module.DatabaseModule;
import com.laioffer.enjoy.demo2_使用.module.HttpModule;
import com.laioffer.enjoy.demo2_使用.obj.DatabaseObject;
import com.laioffer.enjoy.demo2_使用.obj.HttpObject;

/**
 * @description
 * @date 2022/10/04 4:03 下午
 */
public class FirstActivity extends AppCompatActivity {

  public static final String TAG = FirstActivity.class.getSimpleName();

  @Inject
  HttpObject mHttpObject1;
  @Inject
  HttpObject mHttpObject2;

  @Inject
  DatabaseObject mDatabaseObject;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.empty_layout);

    // 方式1
    DaggerObjComponents.create().injectFirstActivity(this);

    // 方式2，不推荐 ⚠️
    // 使用注解处理器生成的代码的细节来完成的
    DaggerObjComponents.builder()
        .httpModule(new HttpModule())
        .databaseModule(new DatabaseModule())
        .build() // <== 到这里，初始化了module和component
        .injectFirstActivity(this);


    // 验证: 注入的两个对象的实例是否是单例的
    Log.e(TAG, "obj1: " + mHttpObject1.hashCode()); // 195911031
    Log.e(TAG, "obj2: " + mHttpObject2.hashCode()); // 206912996
    // ==> 哈希值不同，证明不是单例
  }
}
