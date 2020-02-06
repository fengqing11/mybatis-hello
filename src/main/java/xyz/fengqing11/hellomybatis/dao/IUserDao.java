package xyz.fengqing11.hellomybatis.dao;

import xyz.fengqing11.hellomybatis.domain.User;

import java.util.List;

public interface IUserDao {
    /**
     * 查询所有操作
     * @return 返回用户信息类表
     */
    List<User> findAll();
}
