package com.laioffer.my_fragment.demo2_动态fragment;

import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.my_fragment.R;
import com.example.my_fragment.common.SimpleContentFragment;
import com.example.my_fragment.common.TitleFragment;

/**
 * demo2:动态添加fragment
 * <p>
 * 步骤:
 * 1.获取FragmentManager，通过getSupportFragmentManager，在系统中原生的Fragment是通过getFragmentManager获得的
 * 2.开启一个事务，通过调用beginTransaction方法开启
 * 3.向容器内加入Fragment，一般使用add或者replace方法实现，需要传入容器的id和Fragment的实例
 * 4.提交事务，调用commit方法提交
 * <p>
 * ---------------------------------------------------------------------------------------------------------------------
 * ---------------------------------------------------------------------------------------------------------------------
 * FragmentManager:
 * (1) findFragmentById() 根据ID来找到对应的Fragment实例，主要用在静态添加fragment的布局中，因为静态添加的fragment才会有ID
 * (2) findFragmentByTag() 根据TAG找到对应的Fragment实例，主要用于在动态添加的fragment中，根据TAG来找到fragment实例
 * (3) getFragments() 获取所有被ADD进Activity中的Fragment
 * ---------------------------------------------------------------------------------------------------------------------
 * ---------------------------------------------------------------------------------------------------------------------
 * FragmentTransaction
 * (1) add: 将一个fragment实例添加到Activity的最上层
 * (2) remove: 将一个fragment实例从Activity的fragment队列中删除
 * (3) replace: 替换containerViewId中的fragment实例，它首先把containerViewId中所有fragment删除，然后再add进去当前的fragment
 */
public class Demo2Activity extends AppCompatActivity {

  private ImageView mChatView;
  private ImageView mFriendView;
  private ImageView mContactView;
  private ImageView mSettingView;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.activity_demo2);
    initView();

    // 设置默认展示的fragment
    initDefaultFragment();
    // 切换页面
    switchPage();
  }

  private void initDefaultFragment() {
    FragmentManager fm = getSupportFragmentManager();
    FragmentTransaction ft = fm.beginTransaction();
    SimpleContentFragment contentFragment = new SimpleContentFragment();
    ft.replace(R.id.demo2_fragment_container, contentFragment);
    ft.commit();
  }

  private void switchPage() {
    mChatView.setOnClickListener(v -> {
      ChatFragment chatFragment = new ChatFragment();
      replaceFragment(chatFragment);
    });

    mFriendView.setOnClickListener(v -> {
      FriendFragment friendFragment = new FriendFragment();
      replaceFragment(friendFragment);
    });

    mContactView.setOnClickListener(v -> {
      ContactFragment contactFragment = new ContactFragment();
      replaceFragment(contactFragment);
    });

    mSettingView.setOnClickListener(v -> {
      SettingFragment settingFragment = new SettingFragment();
      replaceFragment(settingFragment);
    });
  }

  private void initView() {
    mChatView = findViewById(R.id.demo2_chat_tab);
    mFriendView = findViewById(R.id.demo2_friend_tab);
    mContactView = findViewById(R.id.demo2_contact_tab);
    mSettingView = findViewById(R.id.demo2_setting_tab);

    TitleFragment titleFragment =
        (TitleFragment) getSupportFragmentManager().findFragmentById(R.id.title_fragment);
    titleFragment.setTitle("[动态添加fragment]");
  }

  private void replaceFragment(Fragment targetFragment) {
    FragmentManager fm = getSupportFragmentManager();
    FragmentTransaction ft = fm.beginTransaction();
    ft.replace(R.id.demo2_fragment_container, targetFragment);
    ft.commit();
  }
}
