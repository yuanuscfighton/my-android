package com.laioffer.v3_constructor_inject;

import static com.laioffer.Dagger2Log.CAR3_LOG_TAG;

import javax.inject.Inject;

import android.util.Log;

public class Engine {

  @Inject
  public Engine() {
    Log.d(CAR3_LOG_TAG, "Engine constructor invoked...");
  }
}
