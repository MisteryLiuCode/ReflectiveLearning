package com;

import com.liu.TestReflection;

import java.lang.reflect.Field;

public class MyTest {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        MyTest myTest = new MyTest();
//        获取class对象
        String classPath="com.liu.TestReflection";
        Class aClass = Class.forName(classPath);
        System.out.println("Class对象"+aClass);
        System.out.println("类的运行类型"+aClass.getClass());
        System.out.println("类的包名"+aClass.getPackage().getName());
        System.out.println("全类名"+aClass.getName());
//        创建类的实例
        TestReflection o = (TestReflection) aClass.newInstance();
        System.out.println(o);//会调用toString方法
//        反射获取单个属性，和对象执行方法类似，是属性对象.get(对象)
        Field name1 = aClass.getField("name1");
        System.out.println("name1的属性值："+name1.get(o));//获取name1属性的值
//        通过反射给属性赋值
        name1.set(o,"我是name1属性通过反射赋值后的值");
        System.out.println("name1的属性值："+name1.get(o));//获取name1属性的值
//        获取全部的属性
        Field[] fields = aClass.getFields();
        for(Field field : fields){
            System.out.println(field.getName());
        }

    }


}
