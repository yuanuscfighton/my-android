package com.laioffer.demo.demo1_使用.module;

import com.laioffer.demo.demo1_使用.obj.DatabaseObject;

import dagger.Module;
import dagger.Provides;

/**
 * @description: 提供Database的对象，i.e. 将Database打包成包裹
 * @date: 2022/9/18 10:45 下午
 */
@Module
public class DatabaseModule {
  @Provides
  public DatabaseObject provideDatabaseObject() {
    return new DatabaseObject();
  }
}
