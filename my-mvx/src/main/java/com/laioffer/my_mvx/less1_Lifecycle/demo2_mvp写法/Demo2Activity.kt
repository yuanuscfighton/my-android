package com.laioffer.my_mvx.less1_Lifecycle.demo2_mvp写法

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.laioffer.my_mvx.R

/**
 * @description: 版本2: MVP，P层监听生命周期函数
 * @date: 2022/9/19 7:52 上午
 */
class Demo2Activity : AppCompatActivity() {

  private var mMyPresenter: MyPresenter? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.empty_layout)

    mMyPresenter = MyPresenter()
  }

  override fun onStart() {
    super.onStart()
    mMyPresenter?.start()
  }

  override fun onStop() {
    super.onStop()
    mMyPresenter?.stop()
  }
}