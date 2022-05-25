package com.liu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class MyTest {
    public static void main(String[] args) throws IOException {
        MyTest myTest = new MyTest();
//        读取配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("/Users/liushuaibiao/Library/Mobile Documents/com~apple~CloudDocs/个人日常/20220520_反射/01OutgoingReflection/src/main/resources/re.properties"));
        String classpath = properties.get("classpath").toString();
        String method = properties.get("method").toString();
        System.out.println("classpath="+classpath);
        System.out.println("method="+method);
    }


}
