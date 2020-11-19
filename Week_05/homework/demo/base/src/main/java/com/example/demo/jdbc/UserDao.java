package com.example.demo.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: menglinggang
 * @Date: 2020-11-19
 * @Time: 上午11:17
 */
@Component
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public void insert(User user) {
        String sql = "insert into `user` (`name`,`age`) values ('" + user.getName() + "', " + user.getAge() + ");";

        executeByStatement(sql);
    }


    public void insertStatement(User user) {
        String sql = "insert into `user` (`name`,`age`) values (?, ?);";
        Connection connection = DataBaseUtil.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setInt(2, user.getAge());
            statement.execute();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void batchInsert(List<User> users) {

        String sql = "insert into `user` (`name`,`age`) values (?, ?);";

        Connection connection = DataBaseUtil.getConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(sql);
            for (User user : users){
                statement.setString(1, user.getName());
                statement.setInt(2, user.getAge());
                statement.addBatch();
            }

            statement.executeBatch();
            connection.commit();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void update(User user) {
        String sql = "UPDATE  `user` SET `name` = '" + user.getName() + "', `age`=" + user.getAge() + " WHERE id = " + user.getId();

        jdbcTemplate.update(sql);
        //executeByStatement(sql);

    }

    public void updateStatement(User user) {
        String sql = "UPDATE  `user` SET `name` = ?, `age`=? WHERE id = ?;";
        try {
            Connection connection = DataBaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setInt(2, user.getAge());
            statement.setInt(3, user.getId());
            statement.execute();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int count(){
        String sql = "SELECT COUNT(*) FROM   `user` ";

        try {
            Connection connection = DataBaseUtil.getConnection();
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            int count = 0;
            while(resultSet.next()) {
                count = resultSet.getInt(1);
            }
            statement.close();
            connection.close();
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void delete(User user) {
        String sql = "DELETE `user` WHERE id = " + user.getId();
        executeByStatement(sql);
    }

    public void deleteStatement(User user) {
        String sql = "DELETE `user` WHERE id = ?";
        try {
            Connection connection = DataBaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, user.getId());
            statement.execute();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public User selectById(int id) {
        String sql = "select *  from  user where id =" + id;
        Connection connection = DataBaseUtil.getConnection();
        User user = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt(1));
                user.setAge(resultSet.getInt(3));
                user.setName(resultSet.getString(2));
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }



    private void executeByStatement(String sql){
        Connection connection = DataBaseUtil.getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
