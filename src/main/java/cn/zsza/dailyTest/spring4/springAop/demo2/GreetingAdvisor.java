package cn.zsza.dailyTest.spring4.springAop.demo2;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import java.lang.reflect.Method;

/**
 * Created by zs on 2017/5/23.
 * 11:51
 * StaticMethodMatcherPointAdvisor抽象类唯一需要定义的是matches()方法.在默认情况下,
 * 该切面匹配所有的类,这里通过覆盖getClassFilter()方法,让它仅匹配Waiter类及其子类.
 */
public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor {
    @Override
    public boolean matches(Method method, Class<?> clazz) {

        return "greetTo".equals(method.getName());
    }

    public ClassFilter getClassFilter(){
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> clazz) {
                return Waiter.class.isAssignableFrom(clazz);
            }
        };
    }
}
