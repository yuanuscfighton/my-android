package com.laioffer.v3_constructor_inject;

// 这个类非常重要。因为Car3Activity需要从这个类中获取Car的实例
// CarComponent create and store object, and provide them to us. We could call it Injector.
//
// There are 2 ways which Component can provide dependencies.
// (1) It can inject them into member variable of Car3Activity directly. 例如，Car3Activity中的mCar成员变量. <== 这个下个视频讲解
// (2) Provision methods. It is just a getter() method.

import dagger.Component;

// @Component: Dagger will implement this interface at compile time.
@Component
public interface CarComponent {

  Car getCar();
}
