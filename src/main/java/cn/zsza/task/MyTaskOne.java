package cn.zsza.task;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by ZhangSong on 2016/10/11.
 * 22:05
 */

public class MyTaskOne {

    public void print(){
        System.out.println("打印定时器");
    }


}
