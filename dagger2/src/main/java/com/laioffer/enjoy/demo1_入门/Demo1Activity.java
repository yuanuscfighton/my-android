package com.laioffer.enjoy.demo1_入门;

import javax.inject.Inject;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @date 2022/10/3 9:44 下午
 */
public class Demo1Activity extends AppCompatActivity {

  @Inject
  Computer mComputer;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    DaggerComputerComponent.create().injectMainActivity(this);
  }
}
