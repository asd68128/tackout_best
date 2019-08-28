package com.sl.tackout.mapper;

import com.sl.tackout.pojo.UserTable;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by happy on 2019/8/21.
 */
@Mapper
public interface UserMapper {

    //通过用户名查找用户信息
    public UserTable findUserByLoginName(String userName);

    //获取最大id
    public int findMaxUserId();

    //添加注册的用户
    public int addUser(UserTable userTable);

    //修改当前用户角色（购买会员）
    public int addMemberRole(String userName);
}
