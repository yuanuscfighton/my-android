package com.laioffer.my_fragment.demo1_静态fragment;

import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import com.laioffer.my_fragment.R;
import com.laioffer.my_fragment.common.SimpleContentFragment;
import com.laioffer.my_fragment.common.TitleFragment;

/**
 * demo1:静态fragment的使用
 */
public class Demo1Activity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.activity_demo1);

    configTitleFragment();
  }

  private void configTitleFragment() {
    TitleFragment titleFragment =
        (TitleFragment) getSupportFragmentManager().findFragmentById(R.id.title_fragment);
    SimpleContentFragment contentFragment =
        (SimpleContentFragment) getSupportFragmentManager().findFragmentById(
            R.id.simple_content_fragment);

    titleFragment.setTitle("[静态fragment]");
    contentFragment.setContent("demo1 Content Fragment");
  }
}