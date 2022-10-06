package com.laioffer.apt_create_dagger2;

import com.laioffer.Computer;
import com.laioffer.MainActivity;
import com.laioffer.custom_dagger.MembersInjector;
import com.laioffer.custom_dagger.Provider;

// 第5个注解
// 只有在目标（MainActivity）去注入Student对象的时候，在编译时期才会去生成此类
public class MainActivity_MembersInjector implements MembersInjector<MainActivity> {

  private Provider<Computer> computerProvider; // 定义最高标准，为了拿到 对象的实例化

  public MainActivity_MembersInjector(Provider<Computer> computerProvider) {
    this.computerProvider = computerProvider;
  }

  // 提供一个静态创建|的方法
  public static MainActivity_MembersInjector create(Provider<Computer> computerProvider) {
    return new MainActivity_MembersInjector(computerProvider);
  }

  @Override // 注入的方法
  public void injectMembers(MainActivity instance) { // instance == MainActivity this
    if (null == instance) {
      throw new NullPointerException("inject target instance is null");
    }
    // MainActivity.this student = new Student(); 依赖注入框架
    instance.student = computerProvider.get(); // MainActivity this.student = new Student();
    instance.student2 = computerProvider.get();
  }
}
