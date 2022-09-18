package com.laioffer.demo.demo3_全局单例.app;

import android.app.Application;

import com.laioffer.demo.demo3_全局单例.component.DaggerObjComponents;
import com.laioffer.demo.demo3_全局单例.component.ObjComponents;
import com.laioffer.demo.demo3_全局单例.module.DatabaseModule;
import com.laioffer.demo.demo3_全局单例.module.HttpModule;

/**
 * @description:
 * @date: 2022/9/18 11:43 下午
 */
public class MyApplication extends Application {

  private ObjComponents mObjComponents;

  @Override
  public void onCreate() {
    super.onCreate();

    mObjComponents = DaggerObjComponents.builder()
        .httpModule(new HttpModule())
        .databaseModule(new DatabaseModule())
        .build();
  }

  public ObjComponents getAppComponent() {
    return mObjComponents;
  }
}
