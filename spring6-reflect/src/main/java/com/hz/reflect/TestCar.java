package com.hz.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCar {


    //1、获取class 对象的多种方式
    @Test
    public void test1() throws Exception {
        //类型.class 对象.getClass()
        Class<Car> carClass = Car.class;
        Class car = new Car().getClass();
        Class clazz3 = Class.forName("com.hz.reflect.Car");

        // 实例化
        Car car11 = (Car) clazz3.getDeclaredConstructor().newInstance();

    }

    //2、获取构造方法
    @Test
    public void test2() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class clazz = Car.class;
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor.getName() + constructor.getParameterCount());
        }

        Constructor con = clazz.getConstructor(String.class, int.class, String.class);
        Car car = (Car) con.newInstance("艾力给", 1, "red");

    }

    //3、获取属性

    @Test
    public void test3() {
        Class clazz = Car.class;
        Field[] fields = clazz.getFields();
        Field[] declaredFields = clazz.getDeclaredFields();
    }

    //4、获取方法
    @Test
    public void test4() throws Exception {
        Car car = new Car("宝马X5L",1,"black");
        Class clazz = car.getClass();
        //
        Method[] methods = clazz.getMethods();
        Method[] declaredMethods = clazz.getDeclaredMethods();

    }
}
