package top.fuyuaaa.jtaatomikossample.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.fuyuaaa.jtaatomikossample.entity.Order;
import top.fuyuaaa.jtaatomikossample.mapper.order.OrderMapper;
import top.fuyuaaa.jtaatomikossample.service.OrderService;
import top.fuyuaaa.jtaatomikossample.service.StorageService;

/**
 * @author : fuyuaaa
 * @date : 2020-10-29 15:51
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    StorageService storageService;

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void placeOrder(Order order) {
        int insert = orderMapper.insert(order);
        Boolean reduce = storageService.reduce(order.getProductId(), order.getProductNum());
        if (insert <= 0 || !reduce) {
            throw new RuntimeException("创建订单失败");
        }
    }
}
