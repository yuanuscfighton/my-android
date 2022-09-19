package com.laioffer.my_mvx.less1_Lifecycle.demo1_原始写法

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.laioffer.my_mvx.R

/**
 * @description: 版本1: 监听器监听生命周期
 * @date: 2022/9/19 7:52 上午
 */
class Demo1Activity : AppCompatActivity() {

  private var myListener: MyListener? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.empty_layout)

    myListener = MyListener()
  }

  override fun onStart() {
    super.onStart()
    myListener?.start()
  }

  override fun onStop() {
    super.onStop()
    myListener?.stop()
  }
}