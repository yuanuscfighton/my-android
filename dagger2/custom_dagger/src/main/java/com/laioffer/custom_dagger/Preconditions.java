package com.laioffer.custom_dagger;

// 工具类，用于监测是不是null
public class Preconditions {

  public static <T> T checkNotNull(T value) {
    if (null == value) {
      throw new NullPointerException("value is null exception..");
    }
    return value;
  }

  public static <T> T checkNotNull(T value, String errorMessage) {
    if (null == value) {
      throw  new IllegalArgumentException(errorMessage);
    }
    return value;
  }
}
