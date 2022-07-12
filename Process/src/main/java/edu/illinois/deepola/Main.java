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

                try (ResultSet result = statement.executeQuery(
                        "select\n" +
                                "\tl_returnflag,\n" +
                                "\tl_linestatus,\n" +
                                "\tsum(l_quantity) as sum_qty,\n" +
                                "\tsum(l_extendedprice) as sum_base_price,\n" +
                                "\tsum(l_extendedprice * (1 - l_discount)) as sum_disc_price,\n" +
                                "\tsum(l_extendedprice * (1 - l_discount) * (1 + l_tax)) as sum_charge,\n" +
                                "\tavg(l_quantity) as avg_qty,\n" +
                                "\tavg(l_extendedprice) as avg_price,\n" +
                                "\tavg(l_discount) as avg_disc,\n" +
                                "\tcount(*) as count_order\n" +
                                "from\n" +
                                "\tlineitem\n" +
                                "where\n" +
                                "\tl_shipdate <= date '1998-12-01' - interval ':1' day\n" +
                                "group by\n" +
                                "\tl_returnflag,\n" +
                                "\tl_linestatus\n" +
                                "order by\n" +
                                "\tl_returnflag,\n" +
                                "\tl_linestatus"
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
