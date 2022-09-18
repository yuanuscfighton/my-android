package com.laioffer.v3_constructor_inject;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.laioffer.dagger2.R;

public class Car3Activity extends AppCompatActivity {

  private Car mCar;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.empty_layout);

    //////////////////////////////////////////////////////////////////////////////////////////
    // We want Dagger to initiate Car object,
    // so we need to create a class called CarComponent, from where we will get car object.
    // ==> 因此，需要创建一个Component接口，(XxxComponent是一个接口)，在Component中我们可以拿到Car的实例.
    CarComponent component = DaggerCarComponent.create();
    mCar = component.getCar();
    //////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////

    mCar.drive();
  }
}
