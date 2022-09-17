package com.laioffer.my_rxjava.demo3_RxJava的观察者模式;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;

/**
 * @description: RxJava的观察者模式
 * step1: Observer的源码分析
 * step2: Observable创建过程，源码分析
 * step3: subscribe订阅过程，源码分析
 * @date: 2022/9/17 5:16 下午
 */
public class Demo3Activity extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // step2 Observable创建过程
    // 进入create()方法:
    // (1) RxJavaPlugins.onAssembly(new Observable<>(source)) -- 绝大部分的操作符都有RxJavPlugins这个hook
    // (2) new Observable<>(source):
    //    (i) 创建了ObservableCreate对象
    //    (ii) 把我们自己定义的source传进去
    Observable.create(
            // new ObservableOnSubscribe<String>(): 自定义source
            new ObservableOnSubscribe<String>() {
              // 这个重写的方法，在ObservableCreate#subscribeActual()中被调用source.subscribe(parent);
              @Override
              public void subscribe(@NonNull ObservableEmitter<String> emitter) {
                emitter.onNext("这是Observable的创建过程");
              }
            })

        // step3 subscribe订阅过程
        // 这里是上面创建的ObservableCreate对象调用的subscribe，因为Observable#create()会返回ObservableCreate对象
        .subscribe( // 在subscribe()里，调用抽象subscribeActual()方法，具体实现是在ObservableCreate类中
            // 自定义观察者
            new Observer<String>() {

              @Override
              public void onSubscribe(@NonNull Disposable d) {
                /**
                 * 当订阅的时候，会调用这个方法
                 * 因为:
                 * 在 {@link io.reactivex.rxjava3.internal.operators.observable.ObservableCreate#subscribeActual(Observer)}方法中，
                 * CreateEmitter<T> parent = new CreateEmitter<>(observer);
                 * observer.onSubscribe(parent);
                 */
              }

              @Override
              public void onNext(@NonNull String s) {

              }

              @Override
              public void onError(@NonNull Throwable e) {

              }

              @Override
              public void onComplete() {

              }
            }
        );
  }
}
