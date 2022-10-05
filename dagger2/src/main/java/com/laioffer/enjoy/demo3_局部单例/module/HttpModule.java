package com.laioffer.enjoy.demo3_局部单例.module;

import javax.inject.Singleton;

import com.laioffer.enjoy.demo3_局部单例.obj.HttpObject;

import dagger.Module;
import dagger.Provides;

/**
 * @description 提供Http的对象，i.e. 将Http打包成包裹
 * @date 2022/9/18 10:46 下午
 */
@Module
public class HttpModule {

  @Singleton
  @Provides
  public HttpObject provideHttpObject() {
    return new HttpObject();
  }
}
