package cn.zsza.serviceTest;

import cn.zsza.BaseJunitTest;
import cn.zsza.user.dao.UserDao;
import cn.zsza.user.entity.User;
import cn.zsza.user.service.UserService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ZhangSong on 2017/2/28.
 * 21:10
 */
public class UserServiceTest extends BaseJunitTest {

    @Resource
    private UserService userService;

    @Resource
    private UserDao userDao;

    @Test
    public void test1(){
        List<User> allUser = userService.findAllUser();

        for (User user :
                allUser) {
            String name = user.getName();
            System.out.println("name=" + name);

        }
    }

    @Test
    public void test2(){
        List<User> allUser = userDao.findAllUser();
        System.out.println(allUser.size());
    }
}
