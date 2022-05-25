import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class MyTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        MyTest myTest = new MyTest();
//        读取配置文件
        //        读取配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("/Users/liushuaibiao/Library/Mobile Documents/com~apple~CloudDocs/个人日常/20220520_反射/03ReflectionRelatedClass/src/main/resources/re.properties"));
        String classpath = properties.get("classpath").toString();
        String method = properties.get("method").toString();
        String attribute = properties.get("attribute").toString();
        System.out.println("classpath="+classpath);
        System.out.println("method="+method);
        System.out.println("attribute="+attribute);
//        加载类
        Class aClass = Class.forName(classpath);
//        创建类
        Object o = aClass.newInstance();
//        获取该类的方法类
        Method method1 = aClass.getMethod(method);
//        传统调用方法是对象.方法名，反射机制是 方法.invoke(传入对象)
        method1.invoke(o);
//        获取该类的属性
        Field field = aClass.getField(attribute);
//        注意这是get方法
        System.out.println("获取该类的属性:"+field.get(o));
//        获取构造器,()里面可以指定参数，不传代表无参构造
        Constructor constructor = aClass.getConstructor();
        System.out.println("获取无参构造:"+constructor);
//        获取有参构造器
        Constructor constructor1 = aClass.getConstructor(String.class);
        System.out.println("获取有参构造:"+constructor1);
    }



}
