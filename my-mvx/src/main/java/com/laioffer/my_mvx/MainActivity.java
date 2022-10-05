package com.laioffer.my_mvx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.laioffer.my_mvx.lesson1_lifecycle.demo2_mvp.Demo2Activity;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // lesson1:Lifecycle, demo2
    openDemo(R.id.lesson1_demo2_entry, Demo2Activity.class);
  }

  private void openDemo(int resId, @NonNull Class<?> clazz) {
    findViewById(resId).setOnClickListener(v -> {
      Intent intent = new Intent(this, clazz);
      startActivity(intent);
    });
  }
}