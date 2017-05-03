package cn.zsza.user.controller;

import cn.zsza.common.util.RedisUtil;
import cn.zsza.user.entity.User;
import cn.zsza.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.io.*;
import java.util.List;

/**
 * Created by ZhangSong on 2016/12/23.
 * 21:17
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private RedisUtil redisUtil;

    @Resource
    private UserService userService;

    @RequestMapping("redis")
    @ResponseBody
    public Object testRedis(){
        redisUtil.set("address","北京");

        return "success";
    }
    @RequestMapping(value = "findAll", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Object findAllUser() throws FileNotFoundException {

        List<User> allUser = userService.findAllUser();
        System.out.println("allUser=" +allUser);
        return "success";
    }
}
