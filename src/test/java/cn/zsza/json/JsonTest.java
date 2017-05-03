package cn.zsza.json;

import net.sf.json.JSONObject;
import org.junit.Test;

/**
 * Created by ZhangSong on 2016/12/31.
 * 15:53
 */
public class JsonTest {
    @Test
    public void test1(){
        JSONObject jo = JSONObject.fromObject("{\"name\":\"zs\",\"age\":\"18\"}");

        Object name = jo.get("name");

        System.out.println("{\"name\":\"zs\",\"age\":\"18\"}");
        System.out.println(name);
    }
}
