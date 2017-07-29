package cn.zsza.dailyTest.spring4.springAop.aspectJ;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by zs on 2017/5/23.
 * 16:26
 */
@Aspect            // 通过该注解将该类标识为一个切面
public class PreGreetingAspect {


    @Before("execution(* greetTo(..))")     // 定义切点和增强类型
    public void beforeGreeting(){           // 前置增强横切逻辑
        System.out.println("How are you");
    }
}
