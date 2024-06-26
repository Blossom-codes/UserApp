package com.blossom;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {
    public void app() {
        try {
            Db db = new Db();

            if (db.connect().isValid(0)) {
                System.out.println("Hello Admin, Welcome!");
                Input input = new Input();
                SqlStmt sql = new SqlStmt();
//                *****SELECTING******
                int option = input.inputIntDataFromTerminal(
                        """
                                Enter 1 to view users
                                Enter 2 to create a new users
                                Enter 3 to edit a user's information
                                Enter 4 to delete a user
                                """);
                switch (option) {
                    case 1 -> { // SELECTING
                        String id = input.inputStringDataFromTerminal("Enter 0 to view all users or Enter in the user's id");
                        if (!id.isEmpty()) {
                            if (id.equals("0")) {
                                String sqlCommand = sql.getStmt(option, "");
                                Statement stmt = db.connect().createStatement(); // for normal selecting
                                ResultSet result = stmt.executeQuery(sqlCommand); //no parameters for selecting with prepared statement
                                while (result.next()) {
                                    for (int i = 1; i <= 5; i++) {
                                        System.out.print(" " + result.getString(i) + " | ");
                                    }
                                    System.out.println();
                                }
                                stmt.close();
                            } else {
                                String sqlCommand = sql.getStmt(option, "where userId = ?");
                                PreparedStatement stmt = db.connect().prepareStatement(sqlCommand);
                                stmt.setInt(1, Integer.parseInt(id));
                                ResultSet result = stmt.executeQuery(); //no parameters for selecting with prepared statement
                                while (result.next()) {
                                    for (int i = 1; i <= 5; i++) {
                                        System.out.print(" " + result.getString(i) + " | ");
                                    }
                                    System.out.println();
                                }
                                stmt.close();
                            }

                        } else {
                            System.out.println("Enter a valid response");
                        }
                    }
                    case 2 -> {// INSERTING
                        int userId = input.inputIntDataFromTerminal("Enter new user id: ");
                        String firstName = input.inputStringDataFromTerminal("Enter your first name");
                        String lastName = input.inputStringDataFromTerminal("Enter your last name");
                        String email = input.inputStringDataFromTerminal("Enter email: ");
                        int pin = input.inputIntDataFromTerminal("Set a pin");
                        if (!firstName.isEmpty() && !lastName.isEmpty() && !email.isEmpty()) {
                            PreparedStatement stmt = db.connect().prepareStatement(sql.getStmt(option, ""));
                            stmt.setInt(1, userId);
                            stmt.setString(2, firstName);
                            stmt.setString(3, lastName);
                            stmt.setString(4, email);
                            stmt.setInt(5, pin);
                            int insertCount = stmt.executeUpdate();
                            if (insertCount > 0) {
                                System.out.println("Successful");
                            } else {
                                System.out.println("Failed");
                            }
                            stmt.close();
                        } else {
                            System.out.println("Enter a valid response");
                        }
                    }

                    case 3 -> {// UPDATING
                        String column = input.inputStringDataFromTerminal("What column do you want to edit? (firstName, lastName, email, pin)");
                        if (!column.isEmpty() && (column.contains("firstName") || column.contains("lastName") || column.contains("email") || column.contains("pin"))) {
                            PreparedStatement stmt = db.connect().prepareStatement(sql.getStmt(option, column));
                            String name = input.inputStringDataFromTerminal("Enter user's first name to edit: ");
                            String newValue = input.inputStringDataFromTerminal("Enter user's new name: ");
                            stmt.setString(1, newValue);
                            stmt.setString(2, name);
                            int updateCount = stmt.executeUpdate();
                            if (updateCount > 0) {
                                System.out.println("Update was successful");
                            } else {
                                System.out.println("Update failed");
                            }
                            stmt.close();
                        } else {
                            System.out.println("Enter a valid response");
                        }
                    }

                    case 4 -> {// DELETING
                        PreparedStatement stmt = db.connect().prepareStatement(sql.getStmt(option, ""));
                        String name = input.inputStringDataFromTerminal("Enter user's first name to DELETE: ");
                        stmt.setString(1, name);
                        int updateCount = stmt.executeUpdate();
                        if (updateCount > 0) {
                            System.out.println("Delete was successful");
                        } else
                            System.out.println("Delete failed");
                        stmt.close();
                    }
                    default -> {
                        System.out.println("Enter a valid response next time!");
                    }
                }

                db.connect().close();

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
