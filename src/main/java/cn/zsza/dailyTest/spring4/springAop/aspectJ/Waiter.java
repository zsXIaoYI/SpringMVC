package cn.zsza.dailyTest.spring4.springAop.aspectJ;

/**
 * Created by zs on 2017/5/18.
 * 11:28
 */
public interface Waiter {
    void greetTo(String name);
    void serveTo(String name);

    void introduce(String name,int age);

}
