package cn.zsza.dailyTest.spring4.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by zs on 2017/5/18.
 * 11:45
 * BeforeAdvice是前置增强的接口,方法前置增强MethodBeforeAdvice接口是其子类.
 * Spring目前只提供方法调用的的前置增强.
 *
 */


public class GreetingBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object obj) throws Throwable {
        String clientName = (String) args[0];
        System.out.println("How are you! Mr." + clientName + ".");
    }
}
