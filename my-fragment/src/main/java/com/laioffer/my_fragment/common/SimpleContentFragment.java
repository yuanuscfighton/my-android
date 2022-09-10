package com.laioffer.my_fragment.common;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.laioffer.my_fragment.R;

/**
 * 内容布局
 */
public class SimpleContentFragment extends Fragment {

  private TextView mContentTextView;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.simple_content_fragment, container, false);
    mContentTextView = view.findViewById(R.id.content_textview);
    return view;
  }

  public void setContent(@NonNull String content) {
    mContentTextView.setText(content);
  }
}
