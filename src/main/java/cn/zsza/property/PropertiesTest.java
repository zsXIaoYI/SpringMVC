package cn.zsza.property;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by ZhangSong on 2016/11/1.
 * 21:21
 */
@Component
public class PropertiesTest {
    private static Properties properties = new Properties();
    public PropertiesTest(){
        init();
    }
    private static void init() {
        InputStream in = PropertiesTest.class.getClassLoader().getResourceAsStream("property/zs.properties");

        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object getValue(String key){
        return properties.get(key);
    }
}
