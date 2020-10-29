package top.fuyuaaa.jtaatomikossample.mapper.order;

import org.apache.ibatis.annotations.Mapper;
import top.fuyuaaa.jtaatomikossample.entity.Order;

/**
 * @author : fuyuaaa
 * @date : 2020-10-29 15:37
 */
@Mapper
public interface OrderMapper {
    int insert(Order order);
}
