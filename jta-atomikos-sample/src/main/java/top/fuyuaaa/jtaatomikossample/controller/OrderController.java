package top.fuyuaaa.jtaatomikossample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.fuyuaaa.jtaatomikossample.entity.Order;
import top.fuyuaaa.jtaatomikossample.service.OrderService;

import java.util.UUID;

/**
 * @author : fuyuaaa
 * @date : 2020-10-29 16:11
 */
@RestController
@RequestMapping
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/placeOrder")
    public Boolean placeOrder(String productId,Integer num) {
        Order order = new Order();
        order.setProductNum(num);
        order.setProductId(productId);
        order.setOrderId(UUID.randomUUID().toString().replace("-",""));
        orderService.placeOrder(order);
        return true;
    }
}
