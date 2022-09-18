package com.laioffer.v5_method_inject;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.laioffer.dagger2.R;

import javax.inject.Inject;

public class Car5Activity extends AppCompatActivity {

  @Inject
  Car mCar;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.empty_layout);

    CarComponent component = DaggerCarComponent.create();
    component.inject(Car5Activity.this);

    mCar.drive();
  }
}
