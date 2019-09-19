package com.treasuremountain.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * 一段信息
 *
 * @author     : mengyuanming
 * @date       : Created in 2019/3/22 0022 20:34
 * @since      : 1.0
 */
@ApiModel("信息model")
public class Message implements Serializable {

    @ApiModelProperty(name = "id",value = "主键id",hidden = true)
    private int id;

    @NotEmpty(message = "名称不可为空")
    @ApiModelProperty(name = "name",value = "名称")
    private String name;

    @NotEmpty(message = "信息不可为空")
    @ApiModelProperty(name = "message",value = "信息")
    private String message;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
