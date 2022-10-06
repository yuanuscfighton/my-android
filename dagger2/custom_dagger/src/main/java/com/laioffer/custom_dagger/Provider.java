package com.laioffer.custom_dagger;

// T 就是变化用户注入的对象
public interface Provider<T> {
    T get();
}
