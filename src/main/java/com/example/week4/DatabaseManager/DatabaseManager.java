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
            System.out.println(rs.getString("player2Name"));
            System.out.println(rs.getInt("player1Score"));
            System.out.println(rs.getInt("player2Score"));
            System.out.println(rs.getInt("target"));
            Game game = new Game();
            return game;
        }
        return null;
    }
    public void saveGame(String gameName,String player1Name, String player2Name,int player1Score,int player2Score,int gameEndingScore) throws ClassNotFoundException, SQLException
    {
        Connection connection = DatabaseConnector.getConnection();
        Statement statement = connection.createStatement();

        String sql = "INSERT INTO game (`player1Name`,`player2Name`,`player1Score`,`player2Score`,`target`,`name`) VALUES ('"+player1Name+"','"+ player2Name+"','"+player1Score+"','"+player2Score+"','"+gameEndingScore+"','"+gameName+"');";
        //System.out.println("INSERT INTO game (`player1Name`,`player2Name`,`player1Score`,`player2Score`,`target`,`name`) VALUES ('"+player1Name+"','"+ player2Name+"','"+player1Score+"','"+player2Score+"','"+gameEndingScore+"','"+gameName+"');");
        System.out.println(sql);
        int rs= statement.executeUpdate(sql);

        System.out.println(rs);

    }
}
