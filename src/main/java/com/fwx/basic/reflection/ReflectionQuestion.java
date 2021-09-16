package com.fwx.basic.reflection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectionQuestion {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Properties pro = new Properties();
        pro.load(new FileInputStream("src\\main\\resources\\reflection.properties"));
        String classfullpath = pro.get("classfullpath").toString();
        String methodName = pro.get("methodName").toString();

        Class cls = Class.forName(classfullpath);
        Object obj = cls.newInstance();
        Method method = cls.getMethod(methodName);
        method.invoke(obj);
        /**传统:对象.方法()  现在:方法.invoke(对象)**/
    }
}
