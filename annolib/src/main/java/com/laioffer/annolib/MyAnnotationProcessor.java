package com.laioffer.annolib;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;


/**
 * 这是一个注解处理程序
 */
@SupportedAnnotationTypes("com.laioffer. annotation.DemoAnn") // 只处理DemoAnn注解
public class MyAnnotationProcessor extends AbstractProcessor {
  @Override
  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    Messager messager = processingEnv.getMessager();
    messager.printMessage(Diagnostic.Kind.NOTE, "==========");
    return false;
  }
}

// 注意: 需要手动创建配置文件
// resources/META-INF.services/javax.annotation.processing.Processor
//    > com.laioffer.annolib.MyAnnotationProcessor(注解处理器的全类名)

// app:compileDebugJavaWithJavac: 用javac编译java的任务