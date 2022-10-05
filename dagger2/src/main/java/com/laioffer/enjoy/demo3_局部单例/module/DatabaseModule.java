package com.laioffer.enjoy.demo3_局部单例.module;

import com.laioffer.enjoy.demo3_局部单例.obj.DatabaseObject;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @description 提供Database的对象，i.e. 将Database打包成包裹
 * @date 2022/9/18 10:45 下午
 */
@Module
public class DatabaseModule {

  @Singleton
  @Provides
  public DatabaseObject provideDatabaseObject() {
    return new DatabaseObject();
  }
}
