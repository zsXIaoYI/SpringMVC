package cn.zsza.study.controller;

import cn.zsza.common.property.PropertiesTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;

/**
 * Created by ZhangSong on 2016/11/1.
 * 21:39
 * 通过PropertySource注解加载不同的配置文件
 * 可以添加多个该注解用以加载多个配置文件
 *
 */
@Controller
@RequestMapping("/pro")
@PropertySources({
        @PropertySource("classpath:ds.properties"),
        @PropertySource("classpath:test.properties")
})
public class PropertyController {

    @Resource
    private PropertiesTest pro;

    @Autowired
    private Environment env;

    @RequestMapping("/get")
    @ResponseBody
    public String getValue(){
        String name = (String) pro.getValue("name");
        System.out.println("name=" + name);
        return "success";
    }

    @RequestMapping("/getEnv")
    @ResponseBody
    public String getEnv(){


        return env.getProperty("jdbc.username") + "... " +  env.getProperty("zs.name");
    }
}
