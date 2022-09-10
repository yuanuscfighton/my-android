package com.laioffer.my_fragment.demo5_回退栈;

import android.os.Bundle;
import android.view.Window;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.my_fragment.R;
import com.example.my_fragment.common.TitleFragment;

/**
 * demo4:FragmentTransaction方法
 */
public class Demo5Activity extends AppCompatActivity {

  public static final String TAG = "Demo3Activity";

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.activity_demo5);
    configTitle();

    setDefaultFragment();
  }

  private void configTitle() {
    TitleFragment titleFragment =
        (TitleFragment) getSupportFragmentManager().findFragmentById(R.id.title_fragment);
    titleFragment.setTitle("[FragmentTransaction操作]");
  }

  private void setDefaultFragment() {
    FirstFragment firstFragment = new FirstFragment();
    FragmentManager fm = getSupportFragmentManager();
    FragmentTransaction ft = fm.beginTransaction();
    ft.add(R.id.demo3_fragment_container, firstFragment);
    ft.commit();
  }
}
