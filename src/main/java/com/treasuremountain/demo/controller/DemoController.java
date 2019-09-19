package com.treasuremountain.demo.controller;

import com.treasuremountain.demo.manager.DemoManager;
import com.treasuremountain.demo.model.Message;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.List;

/**
 * 示例控制器
 *
 * @author : mengyuanming
 * @date : Created in 2019/3/22 0022 20:14
 * @since : 1.0
 */
@RestController
@RequestMapping("/demo")
@Api("简单示例")
public class DemoController {

    @Autowired
    private DemoManager demoManager;

    @ApiOperation("添加一段信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "名称", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "message", value = "信息", dataType = "String", paramType = "query")
    })
    @PutMapping(path = "/add")
    public String addMessage(@Valid @RequestBody Message message) {
        return demoManager.add(message);
    }

    @ApiOperation("修改一段信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ID", dataType = "number", paramType = "query"),
            @ApiImplicitParam(name = "name", value = "名称", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "message", value = "信息", dataType = "String", paramType = "query")
    })
    @PostMapping(path = "/edit")
    public String editMessage(@Valid @RequestBody @ApiIgnore Message message) {
        return demoManager.edit(message);
    }

    @ApiOperation(value = "查询信息列表", response = Message.class)
    @GetMapping(path = "/query")
    public List<Message> queryMessage() {
        return demoManager.query();
    }

    @ApiOperation(value = "查询信息列表", response = Message.class)
    @ApiImplicitParam(name = "id", value = "ID", dataType = "number", paramType = "query")
    @GetMapping(path = "/getMessageById")
    public Message getMessageById(@Valid @ApiIgnore int id) {
        return demoManager.getById(id);
    }


    @ApiOperation("删除一条信息")
    @DeleteMapping(path = "/delete")
    public String deleteMessage(int id) {
        return demoManager.delete(id);
    }

}
