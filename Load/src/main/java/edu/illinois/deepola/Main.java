package edu.illinois.deepola;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) throws Exception {
        try (Connection connection = DriverManager.getConnection("jdbc:avatica:remote:url=http://localhost:9000")) {
            try (Statement statement = connection.createStatement()) {

                statement.execute("CREATE TABLE test (a INT, b VARCHAR(100))");
                statement.execute("INSERT INTO test VALUES (1, 'a')");
                statement.execute("INSERT INTO test VALUES (2, 'a')");
                statement.execute("INSERT INTO test VALUES (3, 'b')");
                statement.execute("INSERT INTO test VALUES (4, 'b')");
                statement.execute("INSERT INTO test VALUES (5, 'a')");
                statement.execute("INSERT INTO test VALUES (6, 'a')");
                statement.execute("INSERT INTO test VALUES (7, 'b')");
                statement.execute("INSERT INTO test VALUES (8, 'b')");
                statement.execute("INSERT INTO test VALUES (9, 'a')");
                statement.execute("INSERT INTO test VALUES (10, 'a')");
                statement.execute("INSERT INTO test VALUES (11, 'b')");
                statement.execute("INSERT INTO test VALUES (12, 'b')");
                statement.execute("INSERT INTO test VALUES (13, 'a')");
                statement.execute("INSERT INTO test VALUES (14, 'a')");
                statement.execute("INSERT INTO test VALUES (15, 'b')");
                statement.execute("INSERT INTO test VALUES (16, 'b')");
            }
        }

    }
}
