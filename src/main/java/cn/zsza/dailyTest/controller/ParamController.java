package cn.zsza.dailyTest.controller;

import cn.zsza.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;


/**
 * Created by ZhangSong on 2016/9/26.
 * 21:07
 * SpringMVC Controller中的方法接收参数
 */
@Controller
@RequestMapping("/param")
public class ParamController {
    @RequestMapping("tt")
    @ResponseBody
    public String resResult(){
        return "中文";
    }
    /**
     * @param count
     * @return
     * 当浏览器url的count指定的值不为整型时，则报错
     *   The request sent by the client was syntactically incorrect.
     * int 换成String 时，可以接收字符串
     */
    @RequestMapping("t1")
    @ResponseBody
    public String test1(int count){
        System.out.println("...." + count);
        return "your number is " + count;
    }
    /**
     * @param count
     * @return
     * 当指定count的类型为包装类时，count可以指定为空
     */
    @RequestMapping("t2")
    @ResponseBody
    public  String test2(Integer count){
        return "your test2 is " + count;
    }
    /**
     * @param user
     * @return
     * 指定自定义对象类型
     */
    @RequestMapping("t3")
    @ResponseBody
    public String test3(User user){

        return user.toString();
    }

    /**
     * @param user
     * @return
     * 指定参数为自定义复合类型
     *   http://localhost:8087/SpringMVC/param/t4.do?id=1&name=xx&address.province=%E6%B2%B3%E5%8C%97&address.city=%E8%A1%A1%E6%B0%B4
     */
    @RequestMapping("t4")
    @ResponseBody
    public String test4(User user) throws UnsupportedEncodingException {
        String str = user.toString() +" .."+  user.getAddress().getProvince() + "..." +user.getAddress().getCity();

//
//     return new String(str.getBytes(),"ISO-8859-1");
        return str;
    }

    /**
     * @RequestParam 注解用于给后面声明的变量赋值
     * @param str
     * @return
     */
    @RequestMapping("t5")
    @ResponseBody
    public String testParam(@RequestParam("strs") String str){

        return "Hello," + str;
    }



}
