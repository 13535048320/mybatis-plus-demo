package com.example.mybatisplusdemo.modules.system.service;

import com.example.mybatisplusdemo.modules.system.model.Test;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ZhangZhiCheng
 * @since 2019-11-14
 */
public interface TestService extends IService<Test> {
    Test insertSelective(Test test);
}
