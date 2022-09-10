package com.laioffer.my_fragment.demo5_回退栈;

import static com.example.my_fragment.demo5_回退栈.Demo5Activity.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.my_fragment.R;

public class FirstFragment extends Fragment {

  private EditText mInputEditText;
  private Button mActionBtn;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    Log.e(TAG, "FirstFragment#onCreateView()");

    View view = inflater.inflate(R.layout.demo6_first_fragment, container, false);
    initView(view);
    openSecondFragment();

    return view;
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    Log.e(TAG, "FirstFragment#onDestroyView()");
  }

  private void openSecondFragment() {
    mActionBtn.setOnClickListener(v -> {
      SecondFragment secondFragment = new SecondFragment();
      FragmentManager fm = getParentFragmentManager();
      FragmentTransaction ft = fm.beginTransaction();
      ft.replace(R.id.demo3_fragment_container, secondFragment, "Second Fragment");

      // TODO: edittext数据返回后还在？？？ https://blog.csdn.net/zephyr_g/article/details/53516568
      // 如果不添加事务到回退栈，前一个Fragment实例会被销毁。
      // 调用ft.addToBackStack(null)
      // 将当前的事务添加到了回退栈，所以FragmentOne实例不会被销毁，但是视图层次依然会被销毁，即会调用onDestroyView和onCreateView
      ft.addToBackStack(null);
      ft.commit();
    });
  }

  private void initView(View view) {
    mInputEditText = view.findViewById(R.id.demo3_1_input_edittext);
    mActionBtn = view.findViewById(R.id.demo3_1_action_btn);
  }
}
