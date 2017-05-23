package cn.zsza.dailyTest.spring4.springAop.demo1;

/**
 * Created by zs on 2017/5/18.
 * 11:29
 */
public class NaiveWaiter implements Waiter,Waitress {



    @Override
    public void greetTo(String name) {
        System.out.println("greet to " + name);
    }

    @Override
    public void serveTo(String name) {
        System.out.println("serve to" + name);
    }

    @Override
    public String say(String mes) {
        return mes;
    }

    @Override
    public String toString() {
        return "NaiveWaiter{}";
    }

    @Override
    public void printSex(String sex) {
        System.out.println("I am " + sex);
    }
}
