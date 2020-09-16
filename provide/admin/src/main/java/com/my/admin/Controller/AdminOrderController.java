package com.my.admin.Controller;
/*
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "管理订单列表控制器",description = "管理订单列表描述信息")
public class AdminOrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/adminOrder")
    @ApiOperation(value = "订单列表查询方法",notes = "订单列表查询备注")
    public PageInfo<Order> orderList(
        @RequestParam(value = "start",defaultValue = "1") int start,
        @RequestParam(value = "size",defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start, size, "orderid DESC");
        List<Order> adminOrderList = orderService.adminOrderList();
        PageInfo<Order> adminOrderInfo = new PageInfo<>(adminOrderList);
        return adminOrderInfo;
    }
}*/