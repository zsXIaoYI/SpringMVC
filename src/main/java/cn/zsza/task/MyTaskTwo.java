package cn.zsza.task;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by ZhangSong on 2016/11/1.
 * 22:15
 */
@Component
@EnableScheduling
public class MyTaskTwo {
//    @Scheduled(cron = "0/2 * * * * ?")
    public void print2(){
        System.out.println("scheduled注解定时器");
    }
}
