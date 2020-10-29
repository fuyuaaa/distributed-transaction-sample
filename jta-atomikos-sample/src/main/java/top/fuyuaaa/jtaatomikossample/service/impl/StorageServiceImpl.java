package top.fuyuaaa.jtaatomikossample.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.fuyuaaa.jtaatomikossample.mapper.storage.StorageMapper;
import top.fuyuaaa.jtaatomikossample.service.StorageService;

/**
 * @author : fuyuaaa
 * @date : 2020-10-29 15:52
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Autowired
    StorageMapper storageMapper;

    @Override
    public Boolean reduce(String productId, Integer reduceNum) {
        int reduce = storageMapper.reduce(productId, reduceNum);
        return reduce > 0;
    }
}
