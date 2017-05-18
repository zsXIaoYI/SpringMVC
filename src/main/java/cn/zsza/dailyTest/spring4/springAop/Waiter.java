package cn.zsza.dailyTest.spring4.springAop;

/**
 * Created by zs on 2017/5/18.
 * 11:28
 */
public interface Waiter {
    void greetTo(String name);
    void serveTo(String name);

    public String say(String mes);
}
