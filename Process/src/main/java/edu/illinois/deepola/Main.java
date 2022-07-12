package edu.illinois.deepola;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) throws Exception {
        try (Connection connection = DriverManager.getConnection("jdbc:avatica:remote:url=http://localhost:9000")) {
            try (Statement statement = connection.createStatement()) {

                 statement.execute("PREPARE TABLE test");

                try (ResultSet result = statement.executeQuery("SELECT PROGRESSIVE AVG(a), b, PROGRESSIVE_PROGRESS() from test GROUP BY b")) {
                    while (result.next()) {
                        final double avg = result.getDouble(1);
                        final String group = result.getString(2);
                        final double progress = result.getDouble(3);

                        System.out.printf("%f | %s | %f\n", avg, group, progress);
                    }
                }

            }
        }
    }
}
