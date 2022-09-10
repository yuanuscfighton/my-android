package com.laioffer.my_fragment.demo3_FragmentTransaction的使用;

import android.os.Bundle;
import android.view.Window;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.my_fragment.R;
import com.example.my_fragment.common.TitleFragment;

/**
 * demo3:FragmentTransaction的使用
 * <p>
 * 1.页面布局:
 * 首先是三个Button，最下方是一个FrameLayout布局，它是用来做为container动态盛装fragment的，它就像是一个占位符，你设置多大，它其中的fragment
 * 就最大能有多大。作为fragment的容器，即可以用FrameLayout也可以用LinearLayout或者RelativeLayout，都是一样的
 * <p>
 * 2.fragment也是Activity中的一个普通控件而已，只不过它可以像Activity一样用于显示的同时还能用来盛装其它控件.
 */
public class Demo3Activity extends AppCompatActivity {

  private static final String TAG1 = "DEMO3_FRAGMENT1";
  private static final String TAG2 = "DEMO3_FRAGMENT2";

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.activity_demo3);
    configTitle();


    // 添加fragment1
    findViewById(R.id.demo3_add_fragment1).setOnClickListener(v -> {
      Demo3Fragment1 fragment = new Demo3Fragment1();
      addFragment(fragment, TAG1);
    });

    // 添加fragment2
    findViewById(R.id.demo3_add_fragment2).setOnClickListener(v -> {
      Demo3Fragment2 fragment = new Demo3Fragment2();
      addFragment(fragment, TAG2);
    });

    // 移除fragment2
    findViewById(R.id.demo3_remove_fragment2).setOnClickListener(v -> {
      removeSecondFragment();
    });

    // 替换fragment1
    findViewById(R.id.demo3_replace_fragment1).setOnClickListener(v -> {
      replaceFirstFragment();
    });

  }

  private void addFragment(Fragment fragment, String tag) {
    FragmentManager fm = getSupportFragmentManager();
    FragmentTransaction ft = fm.beginTransaction();

    /**
     * param1: 盛放fragment的容器.
     * param2: 要添加的fragment的实例.
     * param3:(tag) 当传进去TAG，它就会和fragment关联起来，当通过findFragmentByTag()
     * 时，就会根据TAG找到这个fragment的实例，进而对它进行操作.
     */
    ft.add(R.id.demo3_fragment_container, fragment, tag);

    ft.commit();
  }

  private void removeSecondFragment() {
    FragmentManager fm = getSupportFragmentManager();
    Fragment fragment = fm.findFragmentByTag(TAG2);
    FragmentTransaction ft = fm.beginTransaction();
    if (fragment != null) {
      ft.remove(fragment);
    }
    ft.commit();
  }

  private void replaceFirstFragment() {
    FragmentManager fm = getSupportFragmentManager();
    Demo3Fragment2 fragment2 = new Demo3Fragment2();
    FragmentTransaction ft = fm.beginTransaction();

    // param1: 容器的id
    // param2: 新增的fragment
    // replace的时候会把该container中的所有fragment清空，然后再把fragment2添加进去
    ft.replace(R.id.demo3_fragment_container, fragment2);
    ft.commit();
  }

  private void configTitle() {
    TitleFragment titleFragment =
        (TitleFragment) getSupportFragmentManager().findFragmentById(R.id.title_fragment);
    titleFragment.setTitle("[FragmentTransaction操作]");
  }
}
