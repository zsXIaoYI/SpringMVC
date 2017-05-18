package cn.zsza.dailyTest.spring4.aop;

import org.junit.Test;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by zs on 2017/5/18.
 * 11:31
 */
public class AopTest {
    @Test
    public void before(){
        Waiter target = new NaiveWaiter();
        BeforeAdvice advice = new GreetingBeforeAdvice();
        /**
         * Spring提供的代理工厂
         */
        ProxyFactory pf = new ProxyFactory();
        /**
         * 设置代理目标
         */
        pf.setTarget(target);
        /**
         * 为代理目标添加增强
         */
        pf.addAdvice(advice);

        Waiter proxy = (Waiter) pf.getProxy();

        /**
         * 代理类在调用目标类的方法时，会执行增强的业务逻辑
         */
        proxy.greetTo("John");

    }

}
