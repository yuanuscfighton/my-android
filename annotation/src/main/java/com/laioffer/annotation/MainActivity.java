package com.laioffer.annotation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

@DemoAnn(value = "val", id = 1)
public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }
}