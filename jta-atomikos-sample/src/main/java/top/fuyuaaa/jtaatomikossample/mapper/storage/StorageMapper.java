package top.fuyuaaa.jtaatomikossample.mapper.storage;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author : fuyuaaa
 * @date : 2020-10-29 15:37
 */
@Mapper
public interface StorageMapper {
    int reduce(@Param("productId") String productId, @Param("reduceNum") Integer reduceNum);
}
