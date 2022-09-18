package com.laioffer.demo.demo1_使用.component;


import com.laioffer.demo.demo1_使用.module.DatabaseModule;
import com.laioffer.demo.demo1_使用.module.HttpModule;
import com.laioffer.demo.demo1_使用.ui.FirstActivity;
import com.laioffer.demo.demo1_使用.ui.SecondActivity;

import dagger.Component;

/**
 * @description: 组件，i.e. 快递员
 * @date: 2022/9/18 10:50 下午
 */
// {HttpModule.class, DatabaseModule.class} ==> 一个快递员可以有多个包裹
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
