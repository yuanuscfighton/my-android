package com.laioffer.my_mvx.less1_Lifecycle.demo2_mvp写法

import android.util.Log

/**
 * @description: P层: P层需要把数据回传给Activity(UI)，如果此时Activity销毁了，就不应该回传数据给Activity了。
 *                因此P层需要监听Activity的声明周期
 * @date: 2022/9/19 7:55 上午
 */
class MyPresenter {

  private val TAG = MyPresenter::class.java.simpleName

  fun start() = Log.e(TAG, "start invoked ...")

  fun stop() = Log.e(TAG, "stop invoked ...")
}