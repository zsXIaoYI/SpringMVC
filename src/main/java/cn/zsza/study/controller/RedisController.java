package cn.zsza.study.controller;

import cn.zsza.common.util.RedisUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        String str = redisUtil.set(key, value);
        System.out.println("res=" + str);
        return "success";
    }
    @RequestMapping("get")
    @ResponseBody
    public String getByKey(String key){
        String str = redisUtil.get(key);
        return str;
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

    /**
     * 获取锁
     * @param key
     * @param value
     * @return
     */
    @RequestMapping("lock")
    @ResponseBody
    public String lock(String key,String value){
        boolean lock = redisUtil.lock(key, value);
        System.out.println("lock:" + lock);
        return "success";
    }

    /**
     * 存放Map
     * @return
     */
    @RequestMapping("setMap")
    @ResponseBody
    public String setMap(){
        Map<String,String> map = new HashMap<>();
        map.put("sina","sina.com");
        map.put("baidu","baidu.com");
        boolean result = redisUtil.setMap("webSite",map,10);
        System.out.println("result:" + result);
        return "success";
    }

    /**
     * http://localhost:8086/SpringMVC/redis/getKey.do?key=website&field=yahoo
     * @param key
     * @param field
     * @return
     */
    @RequestMapping("getKey")
    @ResponseBody
    public String getKey(String key){
//        String result = redisUtil.getMapKey(key,field);
        List<String> result = redisUtil.getMapVal(key,new String[]{"yahoo","google"});
        System.out.println("result:" + result);
        return "success";
    }


}
