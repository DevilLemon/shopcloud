package com.my.product.Mapper;

import com.my.product.MyObject.Good;
import com.my.product.MyObject.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "UserMapper ")
public interface UserMapper {
    //User专用查询可显商品
    @Select(" select * from shop_user where name = #{name} ")
    User login_check(@Param("name") String name);
}
