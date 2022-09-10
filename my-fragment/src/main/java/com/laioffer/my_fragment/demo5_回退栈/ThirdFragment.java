package com.laioffer.my_fragment.demo5_回退栈;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.my_fragment.R;

public class ThirdFragment extends Fragment {

  private Button mActionBtn;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.demo6_third_fragment, container, false);

    initView(view);
    toastInfo();

    return view;
  }

  private void toastInfo() {
    mActionBtn.setOnClickListener(v -> {
      // 在Fragment中可以通过getActivity()得到当前绑定的Activity的实例
      Toast.makeText(getActivity(), "Button in Third Fragment", Toast.LENGTH_SHORT).show();
    });
  }


  private void initView(View view) {
    mActionBtn = view.findViewById(R.id.demo3_3_action_btn);
  }
}
