package com.my.product.Mapper;

import com.my.product.MyObject.Good;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import java.util.List;

@Mapper
@Component(value = "GoodMapper ")
public interface GoodMapper {
    //User专用查询可显商品
    @Select(" select * from shop_goods where status = '可显' ")
    List<Good> userGoodList();
    //插入商品
    @Insert(" insert into shop_goods ( name,num,pay,status,img ) values ( #{name},#{num},#{pay},#{status},#{img} ) ")
    int addGood(Good good);
    //公用查询单个商品
    @Select(" select * from shop_goods where goodid = #{goodid} ")
    Good getGood(Long goodid);
}
