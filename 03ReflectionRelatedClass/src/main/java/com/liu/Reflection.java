package com.liu;

/**
 * @program: Reflection
 * @description: 反射对应的类
 * @author: 刘帅彪
 * @create: 2022-05-20 16:42
 **/


public class Reflection {
    public String testName="我是testName的值";
    public void hi(){
        System.out.println("hi,反射调用方法");
    }

    public Reflection() {
    }

    public Reflection(String testName) {
        this.testName = testName;
    }
}
