package cn.zsza.dailyTest.spring4.aop;

/**
 * Created by zs on 2017/5/18.
 * 11:29
 */
public class NaiveWaiter implements Waiter {



    @Override
    public void greetTo(String name) {
        System.out.println("greet to " + name);
    }

    @Override
    public void serveTo(String name) {
        System.out.println("serve to" + name);
    }

    @Override
    public String toString() {
        return "NaiveWaiter{}";
    }
}
