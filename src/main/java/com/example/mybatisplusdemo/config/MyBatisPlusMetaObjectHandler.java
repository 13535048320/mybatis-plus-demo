package com.example.mybatisplusdemo.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MyBatisPlusMetaObjectHandler implements MetaObjectHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyBatisPlusMetaObjectHandler.class);

    @Override
    public void insertFill(MetaObject metaObject) {
        LOGGER.info("start insert fill ....");
        boolean hasSetter = metaObject.hasSetter("createTime");
        if (hasSetter) {
            this.setInsertFieldValByName("createTime", LocalDateTime.now(), metaObject);
        }
        hasSetter = metaObject.hasSetter("modifyTime");
        if (hasSetter) {
            this.setFieldValByName("modifyTime", LocalDateTime.now(), metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        LOGGER.info("start update fill ....");
        boolean hasSetter = metaObject.hasSetter("modify_time");
        if (hasSetter) {
            this.setFieldValByName("modify_time", LocalDateTime.now(), metaObject);
        }
    }
}
