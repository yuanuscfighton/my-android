package com.laioffer.enjoy.demo4_全局单例.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.laioffer.dagger2.R;
import com.laioffer.enjoy.demo4_全局单例.app.MyApplication;
import com.laioffer.enjoy.demo4_全局单例.obj.HttpObject;

import javax.inject.Inject;

/**
 * @description: 全局单例
 * @date: 2022/9/18 10:52 下午
 */
public class SecondActivity extends AppCompatActivity {

  public static final String TAG = "[" + SecondActivity.class.getSimpleName() + "]";

  @Inject
  HttpObject mHttpObject;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.empty_layout);

    ((MyApplication)getApplication())
        .getAppComponent()
        .injectSecondActivity(this);


    Log.e("[demo3]", TAG + "obj:" + mHttpObject.hashCode());
  }
}
