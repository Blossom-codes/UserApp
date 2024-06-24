package com.blossom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "Blozzy200120";
//        String sql = "CREATE DATABASE testDb";
//        String sql = "use testdb";
//        String sql = " create table users(" +
//                "     userId INT NOT NULL," +
//                "     firstName VARCHAR(25)," +
//                "     lastName VARCHAR(25)," +
//                "     email VARCHAR(25)," +
//                "     pin INT NOT NULL," +
//                "     PRIMARY KEY (userId)" +
//                "     );";
//        String sql = " INSERT INTO users VALUES (1,'John', 'Doe', 'john@gmail.com',1234);";
        String sql = "select * from users;";
//        String sql = " select firstName, lastName from users where userId = 1";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(url, username, password);

            Statement stmt = connect.createStatement();
            ResultSet result = stmt.executeQuery(sql);


            while (result.next())
            {
                for (int i = 1; i <= 5; i++)
                {
                    System.out.print(" "+result.getString(i)+" | ");
                }
                System.out.println();
            }


        } catch (Exception e) {
            System.out.println(e);
        }

//        System.out.println("Hello and welcome!");
//        Input input = new Input();
//        for (int i = 1; i <= 2; i++) {
//            System.out.println("i = " + i);
//            String name = input.inputStringDataFromTerminal("Enter your name");
//            String email = input.inputStringDataFromTerminal("Enter your email");
//            int pin = input.inputIntDataFromTerminal("Set a pin");
//            Register signup = new Register(i, name, email, pin);
//            System.out.println(signup.name() + ", Registration was Successful");
//            System.out.println();
//
//        }
    }
}