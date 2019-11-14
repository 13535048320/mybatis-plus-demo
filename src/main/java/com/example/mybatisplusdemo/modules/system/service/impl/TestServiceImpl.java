package com.example.mybatisplusdemo.modules.system.service.impl;

import com.example.mybatisplusdemo.modules.system.model.Test;
import com.example.mybatisplusdemo.modules.system.mapper.TestMapper;
import com.example.mybatisplusdemo.modules.system.service.TestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ZhangZhiCheng
 * @since 2019-11-14
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements TestService {
    @Autowired
    private TestMapper testMapper;

    @Override
    public Test insertSelective(Test test) {
        int result = this.testMapper.insert(test);
        System.out.println(test.getId());
        return result > 0 ? test : null;
    }
}
