package com.laioffer.v3_constructor_inject;

import static com.laioffer.Dagger2Log.CAR3_LOG_TAG;

import javax.inject.Inject;

import android.util.Log;

public class Wheels {

  @Inject
  public Wheels() {
    Log.d(CAR3_LOG_TAG, "Wheels constructor invoked...");
  }
}
