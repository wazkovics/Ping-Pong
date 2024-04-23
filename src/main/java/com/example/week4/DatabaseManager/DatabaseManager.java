package com.example.week4.DatabaseManager;

import com.example.week4.Game;
import com.example.week4.GameBuilder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {

    /**
     * Returns a game object which was created from data which was in the database
     * @param name The name of the save
     * @return The game object created from the data
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Game getGame(String name) throws ClassNotFoundException, SQLException
    {
        Connection connection = DatabaseConnector.getConnection();
        Statement statement = connection.createStatement();
        String sql = "select * from game where name ='"+name+"' ORDER BY id DESC LIMIT 1;";
        ResultSet rs= statement.executeQuery(sql);
        GameBuilder builder = new GameBuilder();
        while(rs.next())
        {

            builder.withPlayer1Name(rs.getString("player1Name"));
            builder.withPlayer1Score(rs.getInt("player1Score"));
            builder.withPlayer2Name(rs.getString("player2Name"));
            builder.withPlayer2Score(rs.getInt("player2Score"));
            builder.withTarget(rs.getInt("target"));
//            load.getPlayer1().setName(rs.getString("player1Name"));
//            load.getPlayer1().setScore(rs.getInt("player1Score"));
//            load.getPlayer2().setName(rs.getString("player2Name"));
//            load.getPlayer2().setScore(rs.getInt("player2Score"));
//            load.setGameendingscr(rs.getInt("target"));
//            //TODO
//            //Create a new game and set the variables here
//            return Game;
        }

        return builder.build();
    }

    /**
     * Prints the name of the save files so the user can choose which one to load
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void printGameNames() throws ClassNotFoundException, SQLException
    {
        Connection connection = DatabaseConnector.getConnection();
        Statement statement = connection.createStatement();
        String sql = "select * from game;";
        ResultSet rs= statement.executeQuery(sql);
        while(rs.next())
        {
            System.out.println(rs.getString("name"));
//            System.out.println(rs.getString("player2Name"));
//            System.out.println(rs.getInt("player1Score"));
//            System.out.println(rs.getInt("player2Score"));
//            System.out.println(rs.getInt("target"));
        }
    }

    /**
     * Save the game to the database
     * @param gameName Name of the save
     * @param player1Name The name of player 1
     * @param player2Name The name of player 2
     * @param player1Score The score of player 1
     * @param player2Score The score of player 2
     * @param gameEndingScore The score which ends the game
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void saveGame(String gameName,String player1Name, String player2Name,int player1Score,int player2Score,int gameEndingScore) throws ClassNotFoundException, SQLException
    {
        Connection connection = DatabaseConnector.getConnection();
        Statement statement = connection.createStatement();

        String sql = "INSERT INTO game (`player1Name`,`player2Name`,`player1Score`,`player2Score`,`target`,`name`) VALUES ('"+player1Name+"','"+player2Name+"','"+player1Score+"','"+player2Score+"','"+gameEndingScore+"','"+gameName+"');";
        //System.out.println("INSERT INTO game (`player1Name`,`player2Name`,`player1Score`,`player2Score`,`target`,`name`) VALUES ('"+player1Name+"','"+ player2Name+"','"+player1Score+"','"+player2Score+"','"+gameEndingScore+"','"+gameName+"');");
        System.out.println(sql);
        int rs= statement.executeUpdate(sql);

        System.out.println(rs);

    }
}
