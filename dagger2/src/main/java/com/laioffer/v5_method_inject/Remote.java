package com.laioffer.v5_method_inject;

import javax.inject.Inject;

import android.util.Log;

import com.laioffer.Dagger2Log;

public class Remote {

  @Inject
  public Remote() {
  }

  public void setListener(Car car) {
    Log.d(Dagger2Log.CAR5_LOG_TAG, "Remote connected");
  }
}
