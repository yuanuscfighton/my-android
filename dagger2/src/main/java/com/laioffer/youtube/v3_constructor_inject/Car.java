package com.laioffer.youtube.v3_constructor_inject;

import static com.laioffer.Dagger2Log.CAR3_LOG_TAG;

import javax.inject.Inject;

import android.util.Log;

public class Car {

  private Engine mEngine;
  private Wheels mWheels;

  // 如果没有加@Inject注解，会报错
  // ❌错误信息= Car cannot be provided without an @Inject constructor or an @Provides-annotated method.
  /////////////////////////////////////////////////////////////////////////////////////////////////////
  // @Inject: Dagger will know this is the way to initiate Car object.
  // This is called Constructor Injection, because Dagger will later provide this dependencies.
  /////////////////////////////////////////////////////////////////////////////////////////////////////
  // Now Dagger can inject this constructor.
  // But Dagger don't know how to initiate Engine and Wheels, so we need to add @Inject annotation in Engine and Wheels class.
  @Inject
  public Car(Engine engine, Wheels wheels) {
    mEngine = engine;
    mWheels = wheels;
  }

  public void drive() {
    Log.d(CAR3_LOG_TAG, "drive method invoked...");
  }
}
