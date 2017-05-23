package cn.zsza.dailyTest.spring4.springAop.demo2;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zs on 2017/5/23.
 * 11:51
 * 静态普通方法名匹配切面
 * StaticMethodMatcherPointAdvisor抽象类唯一需要定义的是matches()方法.在默认情况下,
 * 该切面匹配所有的类,这里通过覆盖getClassFilter()方法,让它仅匹配Waiter类及其子类.
 */
public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor {
    @Override
    public boolean matches(Method method, Class<?> clazz) {

        return "greetTo,serverTo".contains(method.getName());
    }

    public ClassFilter getClassFilter(){
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> clazz) {
                List<Class> list = new ArrayList<>();
                list.add(Waiter.class);
                list.add(Seller.class);

                return list.contains(clazz);
//                return Waiter.class.isAssignableFrom(clazz);
            }
        };
    }
}
