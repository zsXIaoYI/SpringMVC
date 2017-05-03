package cn.zsza;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created by ZhangSong on 2017/2/28.
 * 21:04
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/beans.xml"})
public class BaseJunitTest {


    @Test
    public void test1(){

        System.out.println("ssssssss");
    }

}
