package com.example.mybatisplusdemo.modules.generator.controller;


import com.example.mybatisplusdemo.modules.generator.model.Test1;
import com.example.mybatisplusdemo.modules.generator.service.Test1Service;
import com.example.mybatisplusdemo.modules.system.controller.BaseController;
import com.example.mybatisplusdemo.modules.system.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ZhangZhiCheng
 * @since 2019-11-14
 */
@RestController
@RequestMapping("/test1")
public class Test1Controller extends BaseController {
    @Autowired
    private Test1Service test1Service;

    @GetMapping
    public ResultMessage get() {
        return ResultMessage.ok(this.test1Service.list());
    }

    @PostMapping
    public ResultMessage insert(@RequestBody Test1 test1) {
        this.test1Service.save(test1);
        return ResultMessage.ok(test1);
    }
}
