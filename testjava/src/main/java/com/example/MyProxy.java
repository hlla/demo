package com.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.AccessController;

import sun.security.action.GetBooleanAction;

public class MyProxy {

    public interface IHello {
        void sayHello();
    }

    static class Hello implements IHello {
        public void sayHello() {
            System.out.println("Hello world!!");
        }
    }

    //自定义InvocationHandler
    static class HWInvocationHandler implements InvocationHandler {
        //目标对象
        private Object target;

        public HWInvocationHandler(Object target) {
            this.target = target;
        }

        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("------插入前置通知代码-------------");
            //执行相应的目标方法
            Object rs = method.invoke(target, args);
            System.out.println("------插入后置处理代码-------------");
            System.out.println("proxy=" + proxy.getClass());
//            Exception exception = new Exception();
//            exception.printStackTrace();
            return rs;
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        byte[] bytes = new byte[80960];
        long time = System.currentTimeMillis();
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("Person.txt");
            int result = inputStream.read(bytes, 0, bytes.length);
            System.out.println("result=" + result);
            throw new NullPointerException();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("file 时间:" + (System.currentTimeMillis() - time) + " byte=" + bytes[1]);
        bytes = new byte[80960];
        time = System.currentTimeMillis();
        FileInputStream inputStream1 = null;
        try {
            inputStream1 = new FileInputStream("weixin_1320.apk");
            int result = inputStream1.read(bytes, 0, bytes.length);
            System.out.println("result1=" + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != inputStream1) {
                try {
                    inputStream1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("file2 时间:" + (System.currentTimeMillis() - time) + " byte=" + bytes[1]);
        //生成$Proxy0的class文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        boolean saveGeneratedFiles = (Boolean) AccessController.doPrivileged(new GetBooleanAction
                ("sun.misc.ProxyGenerator.saveGeneratedFiles"));
        System.out.println(saveGeneratedFiles);
        //获取动态代理类
        Class proxyClazz = Proxy.getProxyClass(IHello.class.getClassLoader(), IHello.class);
        //获得代理类的构造函数，并传入参数类型InvocationHandler.class
        Constructor constructor = proxyClazz.getConstructor(InvocationHandler.class);
        //通过构造函数来创建动态代理对象，将自定义的InvocationHandler实例传入
        IHello iHello = (IHello) constructor.newInstance(new HWInvocationHandler(new Hello()));
        //通过代理对象调用目标方法
        iHello.sayHello();
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        IHello ihello = (IHello) Proxy.newProxyInstance(IHello.class.getClassLoader(),  //加载接口的类加载器
                new Class[]{IHello.class},      //一组接口
                new HWInvocationHandler(new Hello())); //自定义的InvocationHandler
        ihello.sayHello();
    }
}