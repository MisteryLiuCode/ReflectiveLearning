package com.liu;

/**
 * @program: Reflection
 * @description: 反射操作私有属性方法构造器
 * @author: 刘帅彪
 * @create: 2022-05-25 18:09
 **/


public class Person {

    @Override
    public String toString() {
        return "Person{" +
                "priName='" + priName + '\'' +
                ", age=" + age +
                '}';
    }

    private String priName="我是私有属性";

    public int age=10;

    public Person() {
    }

    private Person(String priName, int age) {
        this.priName = priName;
        this.age = age;
    }

    private void priMethod(){
        System.out.println("调用私有方法");
    }
    public void pubMethod(){
        System.out.println("调用公有方法");
    }
}
