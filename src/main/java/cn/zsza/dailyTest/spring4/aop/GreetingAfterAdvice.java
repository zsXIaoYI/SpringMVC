package cn.zsza.dailyTest.spring4.aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by zs on 2017/5/18.
 * 11:45
 *
 */
public class GreetingAfterAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("...." + returnValue + "......" + method.getName());
        System.out.println("enjoy yourself");
    }
}
