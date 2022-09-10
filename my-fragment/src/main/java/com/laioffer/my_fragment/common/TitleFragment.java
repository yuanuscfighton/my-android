package com.laioffer.my_fragment.common;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.laioffer.my_fragment.R;


/**
 * 标题布局
 * <p>
 * 这是Fragment最简单的一种使用方式，把Fragment当成普通的控件，直接写在Activity的布局文件中
 * <p>
 * 步骤:
 * <p>
 * 1.继承Fragment，重写onCreateView决定TitleFragment布局<br>
 * 2.在Activity中声明TitleFragment，就当和普通view一样
 */
public class TitleFragment extends Fragment {

  private TextView mTitleTextView;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.title_fragment, container, false);

    ImageButton leftMenu = view.findViewById(R.id.title_left_btn);
    mTitleTextView = view.findViewById(R.id.title_fragment_textview);

    leftMenu.setOnClickListener(v -> {
      Toast.makeText(getActivity(), "TitleFragment中的ImageButton", Toast.LENGTH_SHORT).show();
    });

    return view;
  }

  public void setTitle(String title) {
    mTitleTextView.setText(title);
  }
}
