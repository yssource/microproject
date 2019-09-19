package com.treasuremountain.demo.manager.implementation;

import com.treasuremountain.demo.manager.DemoManager;
import com.treasuremountain.demo.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 示例业务实现类
 *
 * @author : mengyuanming
 * @date : Created in 2019/3/20 0020 21:05
 * @since : 1.0
 */
@Service
public class DemoManagerImpl implements DemoManager {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String add(Message message) {

        try {
            String sql = "INSERT INTO message (name,message) VALUES (?,?)";
            jdbcTemplate.update(sql, message.getName(), message.getMessage());
            return "添加成功！";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Override
    public String edit(Message message) {
        try {

            String sql = "UPDATE message m SET m.name = ?, m.message= ? WHERE id = ?";
            jdbcTemplate.update(sql, message.getName(), message.getMessage(), message.getId());
            return "修改成功！";

        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Override
    public List<Message> query() {
        try {
            String sql = "SELECT m.id,m.name,m.message FROM message m";
            List<Message> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Message.class));
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("出现异常，请联系管理人员");
        }

    }

    @Override
    public Message getById(int id) {
        try {
            String sql = "SELECT m.id,m.name,m.message FROM message m WHERE m.id = ?";
            Message message = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Message.class), id);
            return message;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("出现异常，请联系管理人员");
        }

    }

    @Override
    public String delete(int id) {
        try {

            String sql = "DELETE FROM message WHERE id = ?";
            jdbcTemplate.update(sql, id);
            return "删除成功！";

        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

}
