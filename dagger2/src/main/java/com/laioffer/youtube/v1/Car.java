package com.laioffer.youtube.v1;

public class Car {

  private Engine mEngine;
  private Wheels mWheels;

  /**
   * 在Car构造器中，new了Engine和Wheels。This means Car Class is responsible for creating Engine and Wheels objects.
   * So every time we construct Car object, we automatically create an Engine instance and an Wheels instance.
   */
  public Car() {
    mEngine = new Engine();
    mWheels = new Wheels();
  }

  public void drive() {

  }
}
