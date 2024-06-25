package com.blossom;

import java.sql.*;

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
//
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(url, username, password);
            if (connect.isValid(0)) {

//                *****SELECTING******
                String sql = " select * from users";
                Statement stmt = connect.createStatement(); // for normal selecting
//                PreparedStatement stmt = connect.prepareStatement(sql);
//                Input input = new Input();
//                int id = input.inputIntDataFromTerminal("Enter user id: ");
//                stmt.setInt(1, id);
                ResultSet result = stmt.executeQuery(sql); //no parameters for selecting with prepared statement
                while (result.next()) {
                    for (int i = 1; i <= 5; i++) {
                        System.out.print(" " + result.getString(i) + " | ");
                    }
                    System.out.println();
                }

//                ****INSERTING****
//                String sql = " INSERT INTO users VALUES (?,?,?,?,?);";
//                String sql = "select * from users where userId = ?";
//                Input input = new Input();
//                int id = input.inputIntDataFromTerminal("Enter new user id: ");
//                String firstName = input.inputStringDataFromTerminal("Enter your first name");
//                String lastName = input.inputStringDataFromTerminal("Enter your last name");
//                String email = input.inputStringDataFromTerminal("Enter email: ");
//                int pin = input.inputIntDataFromTerminal("Set a pin");
//                PreparedStatement stmt = connect.prepareStatement(sql);
//                stmt.setInt(1, id);
//                stmt.setString(2, firstName);
//                stmt.setString(3, lastName);
//                stmt.setString(4, email);
//                stmt.setInt(5, pin);
//                int insertCount = stmt.executeUpdate();
//                if (insertCount > 0)
//                {
//                    System.out.println("Successful");
//                }else{
//                    System.out.println("Failed");
//                }

//                *****UPDATING******
//                String sql = "Update users SET firstName = ? where firstName = ? ";
//                PreparedStatement stmt = connect.prepareStatement(sql);
//                Input input = new Input();
//                String oldName = input.inputStringDataFromTerminal("Enter user's first name to edit: ");
//                String newName = input.inputStringDataFromTerminal("Enter user's new name: ");
//                stmt.setString(1,newName);
//                stmt.setString(2,oldName);
//                int updateCount = stmt.executeUpdate();
//                if (updateCount > 0)
//                    System.out.println("Update was successful");
//                else
//                    System.out.println("Update failed");

//                *****DELETING*****
//
//                String sql = "DELETE FROM users WHERE firstName = ? ";
//                PreparedStatement stmt = connect.prepareStatement(sql);
//                Input input = new Input();
//                String name = input.inputStringDataFromTerminal("Enter user's first name to DELETE: ");
//                stmt.setString(1,name);
//                int updateCount = stmt.executeUpdate();
//                if (updateCount > 0)
//                    System.out.println("Delete was successful");
//                else
//                  System.out.println("Delete failed");

                stmt.close();
                connect.close();


            }
        } catch (Exception e) {
            System.out.println(e);
        }

//        System.out.println("Hello and welcome!");
//        Input input = new Input();
//        for (int i = 1; i <= 2; i++) {
//            System.out.println("i = " + i);
//
//            Register signup = new Register(i, name, email, pin);
//            System.out.println(signup.name() + ", Registration was Successful");
//            System.out.println();
//
//        }
    }
}