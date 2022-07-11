package edu.illinois.deepola;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;


public class Client {
    public static void main(String[] args) throws Exception {
        try (Connection connection = DriverManager.getConnection("jdbc:avatica:remote:url=http://localhost:9000")) {
            try (Statement statement = connection.createStatement()) {
                statement.execute("CREATE TABLE test (a INT, b VARCHAR(100))");
                statement.execute("INSERT INTO test VALUES (1, 'a')");
                statement.execute("INSERT INTO test VALUES (2, 'a')");
                statement.execute("INSERT INTO test VALUES (3, 'b')");
                statement.execute("INSERT INTO test VALUES (4, 'b')");
                statement.execute("PREPARE TABLE test");


            }
        }
    }
}
