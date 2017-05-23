package cn.zsza.dailyTest.spring4.springAop.demo1;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by zs on 2017/5/23.
 * 11:10
 * 环绕增强
 */
public class GreetingInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        Object args[] = invocation.getArguments();    // 目标方法入参

        String clientName = (String) args[0];

        System.out.println("How are you! Mr." + clientName + ".");

        Object obj = invocation.proceed();

        System.out.println("Please enjoy yourself!");

        return obj;
    }
}
