package cn.zsza.dailyTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ZhangSong on 2016/12/26.
 * 20:46
 */
@Controller
@RequestMapping("/jstl")
public class JstlController {

    @RequestMapping("/test")
    public String getValue(ModelMap map){
        System.out.println("执行.......");
        map.put("is_share","1");
        return "jstl";
    }

    @RequestMapping("/test2")
    public String getValueTest(ModelMap map){
        System.out.println("执行.......");
        map.addAttribute("aa","test_aa");
        return "test";
    }
}
