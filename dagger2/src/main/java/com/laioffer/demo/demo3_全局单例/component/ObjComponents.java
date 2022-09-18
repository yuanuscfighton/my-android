package com.laioffer.demo.demo3_全局单例.component;

import com.laioffer.demo.demo3_全局单例.module.DatabaseModule;
import com.laioffer.demo.demo3_全局单例.module.HttpModule;
import com.laioffer.demo.demo3_全局单例.ui.FirstActivity;
import com.laioffer.demo.demo3_全局单例.ui.SecondActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @description: 组件，i.e. 快递员
 * @date: 2022/9/18 10:50 下午
 */
@Singleton
@Component(modules = {HttpModule.class, DatabaseModule.class})
public interface ObjComponents {

  /**
   * 快递员将包裹派送给谁
   *
   * @param activity 被派送的用户
   */
  void injectFirstActivity(FirstActivity activity);

  void injectSecondActivity(SecondActivity activity);
}
