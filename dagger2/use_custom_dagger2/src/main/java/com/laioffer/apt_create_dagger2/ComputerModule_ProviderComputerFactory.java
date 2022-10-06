package com.laioffer.apt_create_dagger2;

import com.laioffer.custom_dagger.Factory;
import com.laioffer.custom_dagger.Preconditions;
import com.laioffer.Computer;
import com.laioffer.ComputerModule;

/**
 * 通过第2个注解@Module和第3个注解@Provider生成这个类
 */
public class ComputerModule_ProviderComputerFactory implements Factory<Computer> {

  // 包裹
  private final ComputerModule computerModule;

  public ComputerModule_ProviderComputerFactory(ComputerModule computerModule) {
    this.computerModule = computerModule;
  }

  @Override
  public Computer get() {
    return Preconditions.checkNotNull(
        computerModule.providerStudent(), "你个货乱搞 无法studentModule.providerStudent()");
  }

  // 暴露给外界用的
  public static Factory<Computer> create(ComputerModule module) {
    return new ComputerModule_ProviderComputerFactory(module);
  }
}
