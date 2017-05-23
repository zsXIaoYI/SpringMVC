package cn.zsza.dailyTest.spring4.springAop;

import cn.zsza.dailyTest.spring4.springAop.demo1.GreetingBeforeAdvice;
import cn.zsza.dailyTest.spring4.springAop.demo1.NaiveWaiter;
import cn.zsza.dailyTest.spring4.springAop.demo1.Waiter;
import cn.zsza.dailyTest.spring4.springAop.demo1.Waitress;
import cn.zsza.dailyTest.spring4.springAop.demo2.Seller;
import org.junit.Test;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zs on 2017/5/18.
 * 11:31
 */
public class AopTest {
    private String configPath = "aop/spring-aop.xml";
    private ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);

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
         * 使用动态代理类的实例调用从Object类继承下来的方法时，会对toString()、equals()以及hashCode()这三个方法进行代
         *（委托到invoke()方法上反射执行），对于其他方法则不代理
         */
//        System.out.println(proxy.toString());
        /**
         * 代理类在调用目标类的方法时，会执行增强的业务逻辑
         */
        proxy.greetTo("John");
    }
    @Test
    public void testBeforeAdviceByXml(){
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        waiter.greetTo("Tom");

        Waitress waitress = (Waitress) ctx.getBean("waiter");
        waitress.printSex("female");

        System.out.println(waiter == waitress);
    }

    /**
     * 后置增强
     */
    @Test
    public void testAfterAdvice(){
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        waiter.say("I work in Beijing");
    }

    /**
     * 环绕增强
     */
    @Test
    public void testAround(){
        Waitress waitress = (Waitress) ctx.getBean("waiter");
        waitress.printSex("male");
    }
    /**......................spring-aop2.xml.............................*/

    @Test
    public void testAdvisor(){
        String configPath = "aop/spring-aop2.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);

        cn.zsza.dailyTest.spring4.springAop.demo2.Waiter waiter =
                (cn.zsza.dailyTest.spring4.springAop.demo2.Waiter) ctx.getBean("waiter");
        Seller seller = (Seller) ctx.getBean("seller");
        waiter.greetTo("Tom");
        seller.greetTo("John");
    }



}
