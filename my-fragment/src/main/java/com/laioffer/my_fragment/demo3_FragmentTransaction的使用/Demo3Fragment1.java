package com.laioffer.my_fragment.demo3_FragmentTransaction的使用;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.my_fragment.R;

/**
 * @description: 第1个fragment
 */
public class Demo3Fragment1 extends Fragment {

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.demo3_first_fragment, container, false);
  }
}
