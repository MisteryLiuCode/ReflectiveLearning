package com.liu;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyTest {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        MyTest myTest = new MyTest();
        Class<?> aClass = Class.forName("com.liu.Person");
        Object o = aClass.newInstance();
        System.out.println(o);
//        调用公有方法和私有方法
        Method pubMethod = aClass.getDeclaredMethod("pubMethod");
        Method priMethod = aClass.getDeclaredMethod("priMethod");
        pubMethod.invoke(o);
//        设置为true
        priMethod.setAccessible(true);
        priMethod.invoke(o);
//        调用私有属性
        Field priName = aClass.getDeclaredField("priName");
        priName.setAccessible(true);
        System.out.println(priName.get(o));
//        给私有属性赋值
        priName.set(o, "我是强制给私有属性强制赋值后的属性");
        System.out.println(priName.get(o));
//        调用私有构造器，给私有构造器赋值
        Constructor<?> declaredConstructors = aClass.getDeclaredConstructor(String.class,int.class);
        declaredConstructors.setAccessible(true);
        Object o1 = declaredConstructors.newInstance("测试属性",10);
        System.out.println(o1);
    }


}
