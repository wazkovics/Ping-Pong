package com.example.week4.DatabaseManager;

import com.example.week4.Game;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    public Game getGame(String name) throws ClassNotFoundException, SQLException
    {
        Connection connection = DatabaseConnector.getConnection();
        Statement statement = connection.createStatement();
        String sql = "select * from game where name='"+name+"';";
        System.out.println(sql);
        ResultSet rs= statement.executeQuery(sql);
        while(rs.next())
        {
            System.out.println(rs.getString("player1Name"));
            System.out.println(rs.getString("player1Name"));
// just to compile and use
            Game game = new Game();
            return game;
        }
        return null;
    }
}
