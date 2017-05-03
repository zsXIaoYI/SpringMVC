package cn.zsza.user.service.impl;

import cn.zsza.user.dao.UserDao;
import cn.zsza.user.entity.User;
import cn.zsza.user.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
/**
 * Created by ZhangSong on 2016/12/23.
 * 21:21
 */
@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserDao userDao;

    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
    @Override
    public List<User> findAllUser() {
        System.out.println("执行..........");
        List<User> userList = userDao.findAllUser();

        LOGGER.info("userList=" + userList);
        return userList;
    }
}
