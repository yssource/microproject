package com.treasuremountain.demo.manager;

import com.treasuremountain.demo.model.Message;

import java.util.List;

/**
 * 示例业务类
 *
 * @author     : mengyuanming
 * @date       : Created in 2019/3/20 0020 21:04
 * @since      : 1.0
 */
public interface DemoManager {

    /**
     * 添加信息
     * @param message 一段信息
     * @return 成功或错误提示
     */
    String add(Message message);

    /**
     * 修改信息
     * @param message 一段信息
     * @return 成功或错误提示
     */
    String edit(Message message);

    /**
     * 查询所有信息
     * @return 信息集合
     */
    List<Message> query();

    /**
     * 以id查询信息
     * @return 一条信息
     */
    Message getById(int id);

    /**
     * 删除一条信息
     * @param id 信息id
     * @return 成功或失败提示
     */
    String delete(int id);

}
