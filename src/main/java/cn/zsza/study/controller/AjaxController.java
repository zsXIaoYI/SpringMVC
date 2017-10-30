package cn.zsza.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ZhangSong on 2016/11/21.
 * 22:02
 */
@Controller
@RequestMapping("/ajax")
public class AjaxController {

    @RequestMapping("/get")
    @ResponseBody
    public String getValue(String name){
        int i = 1;
        System.out.println("执行............");
        if (i % 2 == 1){
            i++;
            return "success";
        }else{
            return "fail";
        }
    }
}
