package com.laioffer.enjoy.demo3_局部单例.ui;

import javax.inject.Inject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.laioffer.dagger2.R;
import com.laioffer.enjoy.demo3_局部单例.component.DaggerObjComponents;
import com.laioffer.enjoy.demo3_局部单例.obj.HttpObject;

/**
 * @description 局部单例
 * @date 2022/9/18 10:52 下午
 */
public class SecondActivity extends AppCompatActivity {

  public static final String TAG = "[demo3_局部单例]" + SecondActivity.class.getSimpleName();

  @Inject
  HttpObject mHttpObject;

  @SuppressLint("SetTextI18n")
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.simple_item_layout);
    TextView itemText = findViewById(R.id.item_text_view);
    itemText.setText("[demo3_局部单例][SecondActivity]");

    DaggerObjComponents.create().injectSecondActivity(this);

    Log.e(TAG, "obj:" + mHttpObject.hashCode()); // 185929891
  }
}
