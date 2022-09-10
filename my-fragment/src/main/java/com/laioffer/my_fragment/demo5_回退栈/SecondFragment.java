package com.laioffer.my_fragment.demo5_回退栈;

import static com.example.my_fragment.demo5_回退栈.Demo5Activity.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.my_fragment.R;

public class SecondFragment extends Fragment {

  private Button mActionBtn;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    Log.e(TAG, "SecondFragment#onCreateView()");

    View view = inflater.inflate(R.layout.demo6_second_fragment, container, false);
    initView(view);

    openThirdFragment();

    return view;
  }


  private void openThirdFragment() {
    mActionBtn.setOnClickListener(v -> {
      ThirdFragment thirdFragment = new ThirdFragment();
      FragmentManager fm = getParentFragmentManager();
      FragmentTransaction ft = fm.beginTransaction();

      // 隐藏当前fragment
      ft.hide(this);
      // 添加ThirdFragment的实例
      ft.add(R.id.demo3_fragment_container, thirdFragment, "Third Fragment");
      // 将事务添加到回退栈
      ft.addToBackStack(null);
      ft.commit();
    });
  }

  private void initView(View view) {
    mActionBtn = view.findViewById(R.id.demo3_2_action_btn);
  }
}
