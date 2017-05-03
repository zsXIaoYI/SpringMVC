package cn.zsza.user.dao;

import cn.zsza.user.entity.User;

import java.util.List;

/**
 * Created by ZhangSong on 2016/12/31.
 * 11:15
 */
public interface UserDao {

    public List<User> findAllUser();
}
