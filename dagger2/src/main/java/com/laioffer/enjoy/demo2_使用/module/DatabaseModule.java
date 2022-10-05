package com.laioffer.enjoy.demo2_使用.module;

import com.laioffer.enjoy.demo2_使用.obj.DatabaseObject;

import dagger.Module;
import dagger.Provides;

/**
 * @description 提供Database的对象，i.e. 将Database打包成包裹
 * @date 2022/10/04 4:03 下午
 */
@Module
public class DatabaseModule {
  @Provides
  public DatabaseObject provideDatabaseObject() {
    return new DatabaseObject();
  }
}
