package com.example.mybatisplusdemo.modules.system.controller;


import com.example.mybatisplusdemo.modules.system.model.MyBatisPlusWrapper;
import com.example.mybatisplusdemo.modules.system.model.Test;
import com.example.mybatisplusdemo.modules.system.service.TestService;
import com.example.mybatisplusdemo.modules.system.util.ResultMessage;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ZhangZhiCheng
 * @since 2019-11-14
 */
@RestController
@RequestMapping("/test")
public class TestController extends BaseController {

    @Autowired
    private TestService testService;

    @GetMapping
    public ResultMessage get() {
        List<Test> result = this.testService.list();
        return CollectionUtils.isNotEmpty(result) ? ResultMessage.ok(result) : ResultMessage.build(200, "result null!");
    }

    @GetMapping("/getByExample")
    public ResultMessage getByExample(@RequestParam(value = "id", required = false) String id,
                                      @RequestParam(value = "name", required = false) String name,
                                      @RequestParam(value = "startCreateTime", required = false) LocalDateTime startCreateTime,
                                      @RequestParam(value = "endCreateTime", required = false) LocalDateTime endCreateTime) {
        MyBatisPlusWrapper<Test> wrapper = new MyBatisPlusWrapper<Test>();
        if (StringUtils.isNotEmpty(id)) {
            wrapper.eq("id", id);
        }
        if (StringUtils.isNotEmpty(name)) {
            wrapper.like("name", name);
        }
        // 大于等于
        if (null != startCreateTime) {
            wrapper.ge("create_time", startCreateTime);
        }
        // 小于等于
        if (null != endCreateTime) {
            wrapper.le("create_time", endCreateTime);
        }
        // 排序
        wrapper.orderByDesc("modify_time");
        List<Test> result = this.testService.list(wrapper);
        return CollectionUtils.isNotEmpty(result) ? ResultMessage.ok(result) : ResultMessage.build(200, "result null!");
    }

    @PostMapping
    public ResultMessage insert(@RequestBody Test test) {
        return this.testService.save(test) ? ResultMessage.ok(test) : ResultMessage.build(400, "insert error!");
    }
}
