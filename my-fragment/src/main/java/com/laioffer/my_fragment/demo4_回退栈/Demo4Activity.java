package com.laioffer.my_fragment.demo4_回退栈;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.my_fragment.R;
import com.example.my_fragment.common.TitleFragment;

/**
 * demo4:回退栈
 * <p>
 * (1) 在commit()之前，使用addToBackStack()将fragment添加到回退栈中
 * FragmentTransaction#addToBackStack(String tag);
 * <p>
 * (2) 在需要回退的时候，使用popBackStack()将最上层的fragment弹出回退栈
 * FragmentManager#popBackStack();
 * <p>
 * (3) 当栈中有多层的时候，可以根据id或者tag标识来指定弹出到的所在层
 * ____ (a) popBackStack(int id, int flags); // param: id是当提交变更时transaction.commit()的返回值
 * ____ (b) popBackStack(String name, int flags); // param: name是transaction.addToBackStack
 * (String tag)中的tag值
 */
public class Demo4Activity extends AppCompatActivity {

  private static final String TAG1 = "Demo4Fragment1";
  private static final String TAG2 = "Demo4Fragment2";
  private static final String TAG3 = "Demo4Fragment3";
  private static final String TAG4 = "Demo4Fragment4";

  private int mStackId1;
  private int mStackId2;
  private int mStackId3;
  private int mStackId4;


  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.activity_demo4);
    configTitle();

    handleClickEvent(R.id.demo4_add_fragment1,
        v -> mStackId1 = addFragment(new Demo4Fragment1(), TAG1));
    handleClickEvent(R.id.demo4_add_fragment2,
        v -> mStackId2 = addFragment(new Demo4Fragment2(), TAG2));
    handleClickEvent(R.id.demo4_add_fragment3,
        v -> mStackId3 = addFragment(new Demo4Fragment3(), TAG3));
    handleClickEvent(R.id.demo4_add_fragment4,
        v -> mStackId4 = addFragment(new Demo4Fragment4(), TAG4));

    // 回退栈顶内容
    handleClickEvent(R.id.demo4_popback_fragment_op1, v -> popBackStack());
    // 回退到add fragment2之后的操作
    handleClickEvent(R.id.demo4_popback_fragment_op2, v -> popBackStackToFragment2());
    // 连带add fragment的操作一起出栈
    handleClickEvent(R.id.demo4_popback_fragment_op3, v -> popBackStackFragment2Include());
  }


  private void popBackStack() {
    FragmentManager fm = getSupportFragmentManager();
    fm.popBackStack();
  }

  /**
   * 回退到add fragment2之后的操作
   * <p>
   * flag设置为0，表示回退到add fragment2之后的操作，即，将add fragment2的操作置为栈顶.
   */
  private void popBackStackToFragment2() {
    FragmentManager fm = getSupportFragmentManager();

    // 有两种实现方式:
    // 方式1:指定TAG
    // fm.popBackStack(TAG2, 0);

    // 方式2:利用commit()返回的id
    fm.popBackStack(mStackId2, 0);
  }

  /**
   * 连带add fragment2的操作一起出栈
   * <p>
   * flag置为1，表示出栈时，连带add fragment2的操作一起出栈，放在栈顶的是add fragment1的操作，因此放在界面上就是显示的是fragment1
   */
  private void popBackStackFragment2Include() {
    FragmentManager fm = getSupportFragmentManager();

    // 有两种实现方式:
    // 方式1:指定TAG
    // fm.popBackStack(TAG2, FragmentManager.POP_BACK_STACK_INCLUSIVE);

    // 方式2:利用commit()返回的id
    fm.popBackStack(mStackId2, FragmentManager.POP_BACK_STACK_INCLUSIVE);
  }

  /**
   * 添加fragment
   *
   * @return Return the identifier of this transaction's back stack entry
   */
  private int addFragment(Fragment fragment, String tag) {
    FragmentManager fm = getSupportFragmentManager();
    FragmentTransaction ft = fm.beginTransaction();
    ft.add(R.id.demo4_fragment_container, fragment, tag);

    // 通过addToBackStack()将每次ADD操作添加到回退栈中
    ft.addToBackStack(tag);
    // 返回 每次commit()后返回的Transaction的id值，在后面调用popBackStack(int id, int flags)方法时，参数id就是这个值
    return ft.commit();
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////////////
  //////////////////////////////////////////////////////////////////////////////////////////////////////////
  private void handleClickEvent(int btnId, @NonNull View.OnClickListener l) {
    findViewById(btnId).setOnClickListener(l);
  }

  private void configTitle() {
    TitleFragment titleFragment =
        (TitleFragment) getSupportFragmentManager().findFragmentById(R.id.title_fragment);
    titleFragment.setTitle("[回退栈]");
  }
}
