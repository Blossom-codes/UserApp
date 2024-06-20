package com.blossom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/?user=root";
        String username = "root";
        String password = "";
        String sql = "SELECT * FROM users";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(url,username,password);

            Statement statement = connect.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next())
            {
                System.out.println(result.getInt(1)+" "+result.getString(2));
            }
            connect.close();
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