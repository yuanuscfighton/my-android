package com.laioffer.my_fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.laioffer.my_fragment.demo1_静态fragment.Demo1Activity;
import com.laioffer.my_fragment.demo2_动态fragment.Demo2Activity;
import com.laioffer.my_fragment.demo3_FragmentTransaction的使用.Demo3Activity;
import com.laioffer.my_fragment.demo4_回退栈.Demo4Activity;
import com.laioffer.my_fragment.demo5_回退栈.Demo5Activity;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // demo1: 静态fragment
    openDemo(R.id.demo1_entry, Demo1Activity.class);

    // demo2: 动态fragment
    openDemo(R.id.demo2_entry, Demo2Activity.class);

    // demo3: FragmentTransaction的使用
    openDemo(R.id.demo3_entry, Demo3Activity.class);

    // demo4: 回退栈
    openDemo(R.id.demo4_entry, Demo4Activity.class);

    // demo5: show、hide
    openDemo(R.id.demo5_entry, Demo5Activity.class);

  }

  private void openDemo(int buttonRes, @NonNull Class<?> clazz) {
    findViewById(buttonRes).setOnClickListener(v -> {
      Intent intent = new Intent(this, clazz);
      startActivity(intent);
    });
  }
}