package com.blossom;

public class SqlStmt {
    public String getStmt(int option, String info) {
        return switch (option) {
            case 1 -> "SELECT * FROM users " + info; //SELECT
            case 2 -> "INSERT INTO users VALUES (?,?,?,?,?)";//INSERT
            case 3 -> "UPDATE users SET " + info + " = ? WHERE email = ?";//UPDATE
            case 4 -> "DELETE FROM users WHERE firstName = ? ";//DELETE
            default -> "";
        };
    }
}

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
