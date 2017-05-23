package cn.zsza.dailyTest.spring4.springAop.demo2;

/**
 * Created by zs on 2017/5/18.
 * 11:28
 */
public class Waiter {
    public void greetTo(String name) {
        System.out.println("waiter greet to " + name + "..." );
    }

    public void serveTo(String name) {
        System.out.println("waiter server to " + name + "..." );

    }

}
