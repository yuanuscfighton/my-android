package com.laioffer.enjoy.demo4_全局单例.app;

import android.app.Application;

import com.laioffer.enjoy.demo4_全局单例.component.DaggerObjComponents;
import com.laioffer.enjoy.demo4_全局单例.component.ObjComponents;
import com.laioffer.enjoy.demo4_全局单例.module.DatabaseModule;
import com.laioffer.enjoy.demo4_全局单例.module.HttpModule;

/**
 * @description
 * @date 2022/9/18 11:43 下午
 */
public class MyApplication extends Application {

  private ObjComponents mObjComponents;

  @Override
  public void onCreate() {
    super.onCreate();

    // 只构建(初始化)一次，保证是全局单例的
    mObjComponents = DaggerObjComponents.builder()
        .httpModule(new HttpModule())
        .databaseModule(new DatabaseModule())
        .build();
  }

  public ObjComponents getAppComponent() {
    return mObjComponents;
  }
}
