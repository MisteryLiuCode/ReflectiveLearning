import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class MyTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        MyTest myTest = new MyTest();
        //        读取配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("/Users/liushuaibiao/Library/Mobile Documents/com~apple~CloudDocs/个人日常/20220520_反射/02QuickGetStart/src/main/resources/re.properties"));
        String classpath = properties.get("classpath").toString();
        String method = properties.get("method").toString();
        System.out.println("classpath="+classpath);
        System.out.println("method="+method);
//        加载类
        Class aClass = Class.forName(classpath);
//        创建类
        Object o = aClass.newInstance();
//        获取该类的方法类
        Method method1 = aClass.getMethod(method);
//        传统调用方法是对象.方法名，反射机制是 方法.invoke(传入对象)
        method1.invoke(o);

    }


}
