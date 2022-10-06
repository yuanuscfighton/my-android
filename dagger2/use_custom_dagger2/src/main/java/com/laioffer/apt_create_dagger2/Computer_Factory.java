package com.laioffer.apt_create_dagger2;


import com.laioffer.custom_dagger.Factory;
import com.laioffer.Computer;

/**
 * @description 第1个注解 @Inject
 * @date
 */
public enum Computer_Factory implements Factory<Computer> {

    INSTANCE;

    @Override
    public Computer get() {
        return new Computer();
    }

    public static Factory<Computer> create() {
        return INSTANCE;
    }
}
