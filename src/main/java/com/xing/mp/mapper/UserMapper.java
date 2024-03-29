package com.xing.mp.mapper;

import com.xing.mp.model.User;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper {



    int deleteByPrimaryKey(Long id);


    Long insert(User record);


    int insertSelective(User record);



    User selectByPrimaryKey(Long id);


    int updateByPrimaryKeySelective(User record);


    int updateByPrimaryKey(User record);


    User selectByOpenid(String openid);
}