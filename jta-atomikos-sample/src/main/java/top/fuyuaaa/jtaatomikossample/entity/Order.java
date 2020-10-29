package top.fuyuaaa.jtaatomikossample.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : fuyuaaa
 * @date : 2020-10-29 15:44
 */
@Data
public class Order implements Serializable {
    private static final long serialVersionUID = -8694233885509456346L;
    private String orderId;
    private String productId;
    private Integer productNum;
}
