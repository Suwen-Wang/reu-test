package edu.illinois.deepola;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) throws Exception {
        try (Connection connection = DriverManager.getConnection("jdbc:avatica:remote:url=http://localhost:9000")) {
            try (Statement statement = connection.createStatement()) {

                try (ResultSet result = statement.executeQuery(
                        "select l_returnflag, l_linestatus, sum(l_quantity) as sum_qty, sum(l_extendedprice) as sum_base_price, sum(l_extendedprice * (1 - l_discount)) as sum_disc_price, sum(l_extendedprice * (1 - l_discount) * (1 + l_tax)) as sum_charge, avg(l_quantity) as avg_qty, avg(l_extendedprice) as avg_price, avg(l_discount) as avg_disc, count(*) as count_order from lineitem where l_shipdate <= date '1998-12-01' - interval ':1' day group by l_returnflag, l_linestatus order by l_returnflag, l_linestatus"
                )) {
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
