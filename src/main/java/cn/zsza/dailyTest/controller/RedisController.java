package cn.zsza.dailyTest.controller;

import cn.zsza.common.util.RedisUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by ZhangSong on 2017/4/2.
 * 17:52
 */
@Controller
@RequestMapping("/redis")
public class RedisController {

    @Resource
    private RedisUtil redisUtil;

    @RequestMapping("set")
    @ResponseBody
    public String setKeyAndValue(String key,String value){
        redisUtil.set(key,value);
        return "success";
    }
    @RequestMapping("setAndTime")
    @ResponseBody
    public String setKeyAndValueAndTime(String key,String value){
        redisUtil.set(key,value,60);
        return "success";
    }

    /**
     * key不存在，则保存
     * @param key
     * @param value
     * @return
     */
    @RequestMapping("setnx")
    @ResponseBody
    public String setNx(String key,String value){
        Long setnx = redisUtil.setnx(key, value);
        System.out.println("............." + setnx.longValue());
        return "success";
    }

    /**
     * 设置key的过期时间
     * @param key
     * @param seconds
     * @return
     */
    @RequestMapping("setExpire")
    @ResponseBody
    public String setExpire(String key,int seconds){
        Long expire = redisUtil.expire(key,seconds);
        System.out.println("............." + expire.longValue());
        return "success";
    }
}
