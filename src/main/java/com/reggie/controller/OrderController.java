package com.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.reggie.common.R;
import com.reggie.dto.OrdersDto;
import com.reggie.entity.Orders;
import com.reggie.entity.User;
import com.reggie.service.OrderService;
import com.reggie.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author caishihao
 * @version 2021.1
 * @date 2022/9/20 12:19
 */
@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    /**
     * 用户下单
     * @param orders
     * @return
     */
    @PostMapping("/submit")
    public R<String> submit(@RequestBody Orders orders){
        log.info("订单信息：{}",orders);

        orderService.submit(orders);

        return R.success("用户下单成功");
    }

    /**
     * 分页查询订单页面
     * @param page
     * @param pageSize
     * @param number
     * @param beginTime
     * @param endTime
     * @return
     */
    @GetMapping("/page")
    public R<Page> page(int page,int pageSize,String number
                        ,String beginTime,String endTime){

        log.info("beginTime:{}",beginTime);
        log.info("endTime:{}",endTime);

        //构造分页查询构造器
        Page<Orders> pageInfo = new Page<>(page, pageSize);
        Page<OrdersDto> orderDtoPage = new Page<>(page, pageSize);

        //构建查询构造器
        LambdaQueryWrapper<Orders> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StringUtils.hasLength(number),Orders::getId,number);
        if (StringUtils.hasLength(beginTime) && StringUtils.hasLength(endTime)){
            queryWrapper.between(Orders::getOrderTime,beginTime,endTime);
        }
        queryWrapper.orderByDesc(Orders::getCheckoutTime);
        orderService.page(pageInfo,queryWrapper);

        BeanUtils.copyProperties(pageInfo,orderDtoPage,"records");

        List<Orders> records = pageInfo.getRecords();

        List<OrdersDto> list = records.stream().map((item) -> {
            OrdersDto ordersDto = new OrdersDto();
            BeanUtils.copyProperties(item,ordersDto);
            Long userId = item.getUserId();
            User user = userService.getById(userId);
            if (user != null){
                ordersDto.setUserName(user.getName());
            }
            return ordersDto;
        }).collect(Collectors.toList());

        orderDtoPage.setRecords(list);

        return R.success(orderDtoPage);
    }

    /**
     * 修改订单状态信息
     * @param orders
     * @return
     */
    @PutMapping
    public R<String> update(@RequestBody Orders orders){
        LambdaUpdateWrapper<Orders> updateWrapper = new LambdaUpdateWrapper<>();
        //修改状态
        updateWrapper.eq(Orders::getId,orders.getId());
        updateWrapper.set(Orders::getStatus,orders.getStatus());

        orderService.update(updateWrapper);
        return R.success("修改状态成功");

    }
}
