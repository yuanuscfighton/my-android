package com.laioffer.enjoy.demo2_使用.module;

import com.laioffer.enjoy.demo2_使用.obj.HttpObject;

import dagger.Module;
import dagger.Provides;

/**
 * @description 提供Http的对象，i.e. 将Http打包成包裹
 * @date 2022/10/04 4:03 下午
 */
@Module
public class HttpModule {
  @Provides
  public HttpObject provideHttpObject() {
    return new HttpObject();
  }
}
