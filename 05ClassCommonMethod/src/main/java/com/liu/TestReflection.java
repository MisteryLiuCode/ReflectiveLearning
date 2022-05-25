package com.liu;

/**
 * @program: Reflection
 * @description: 反射测试类
 * @author: 刘帅彪
 * @create: 2022-05-21 16:03
 **/


public class TestReflection {
    public String name1 = "我是属性1的值";
    public String name2 = "我是属性2的值";

    public TestReflection(String name1, String name2) {
        this.name1 = name1;
        this.name2 = name2;
    }

    public TestReflection() {
    }

    @Override
    public String toString() {
        return "TestReflection{" +
                "name1='" + name1 + '\'' +
                ", name2='" + name2 + '\'' +
                '}';
    }
}
