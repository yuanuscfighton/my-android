package com.laioffer.enjoy.demo4_全局单例.module;

import com.laioffer.enjoy.demo4_全局单例.obj.HttpObject;

import dagger.Module;
import dagger.Provides;

/**
 * @description: 提供Http的对象，i.e. 将Http打包成包裹
 * @date: 2022/9/18 10:46 下午
 */
@Module
public class HttpModule {
  @Provides
  public HttpObject provideHttpObject() {
    return new HttpObject();
  }
}
