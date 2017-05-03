package cn.zsza.user.service.impl;

import cn.zsza.BaseJunitTest;
import cn.zsza.user.dao.UserDao;
import cn.zsza.user.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by ZhangSong on 2017/2/28.
 * 23:05
 */
public class UserServiceImplTest extends BaseJunitTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void findAllUser() throws Exception {
        List<User> allUser = userDao.findAllUser();
        System.out.println(allUser);
    }

}