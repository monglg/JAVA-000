package com.example.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: menglinggang
 * @Date: 2020-11-19
 * @Time: 上午10:38
 */
public class DataBaseUtil {


    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            try {
                connection = DriverManager.getConnection("jdbc:h2:mem:testdb;MODE=MYSQL;DB_CLOSE_DELAY=-1", "sa", "");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static void initSchema(Connection connection) {
        String schema = "CREATE TABLE `user` (" +
                "  `id` int(11) unsigned NOT NULL AUTO_INCREMENT," +
                "  `name` varchar(100) NOT NULL," +
                "  `age` int(11) NOT NULL," +
                "  PRIMARY KEY (`id`)" +
                ");";

        try {
            Statement statement = connection.createStatement();
            statement.execute(schema);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
