import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyTest {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        MyTest myTest = new MyTest();
        myTest.test1();
        myTest.test2();
        myTest.test3();
    }

    //    传统方式调用执行
    public void test1() {
        //        程序开始执行的时间
        long start = System.currentTimeMillis();
        ReflectionObject reflectionObject = new ReflectionObject();
        for (int i = 0; i < 90000000; i++) {
            reflectionObject.test();
        }
//        结束时间
        long end = System.currentTimeMillis();
        System.out.println("传统方式执行时间:" + (end - start));
    }

    //    反射方式调用执行
    public void test2() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        //        程序开始执行的时间
        long start = System.currentTimeMillis();
//        反射方式创建对象调用方法
        Class<?> reflectionObject = Class.forName("ReflectionObject");
//        创建对象
        Object o = reflectionObject.newInstance();
        Method test = reflectionObject.getMethod("test");
        for (int i = 0; i < 90000000; i++) {
            test.invoke(o);
        }
//        结束时间
        long end = System.currentTimeMillis();
        System.out.println("反射方式执行时间:" + (end - start));
    }

    //    反射优化执行
    public void test3() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        //        程序开始执行的时间
        long start = System.currentTimeMillis();
//        反射方式创建对象调用方法
        Class<?> reflectionObject = Class.forName("ReflectionObject");
        Object o = reflectionObject.newInstance();
        Method test = reflectionObject.getMethod("test");
        /*
        setAccessible设置为true，表示访问的对象在使用时取消访问检查，提高反射访问效率，为false时表示反射对象执行访问检查
         */
        test.setAccessible(true);
        for (int i = 0; i < 90000000; i++) {
            test.invoke(o);
        }
//        结束时间
        long end = System.currentTimeMillis();
        System.out.println("反射优化方式执行时间:" + (end - start));
    }

}
