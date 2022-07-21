//package edu.illinois.deepola;
//
//import java.sql.DriverManager;
//import java.sql.Connection;
//import java.sql.Statement;
//import java.sql.ResultSet;
//
//public class Main {
//    public static void main(String[] args) throws Exception {
//        try (Connection connection = DriverManager.getConnection("jdbc:avatica:remote:url=http://localhost:9000")) {
//            try (Statement statement = connection.createStatement()) {
//
//                try (ResultSet result = statement.executeQuery(
////                        "select l_returnflag, l_linestatus, sum(l_quantity) as sum_qty, sum(l_extendedprice) as sum_base_price, sum(l_extendedprice * (1 - l_discount)) as sum_disc_price, sum(l_extendedprice * (1 - l_discount) * (1 + l_tax)) as sum_charge, avg(l_quantity) as avg_qty, avg(l_extendedprice) as avg_price, avg(l_discount) as avg_disc, count(*) as count_order from lineitem where l_shipdate <= date '1998-12-01' - interval ':1' day group by l_returnflag, l_linestatus order by l_returnflag, l_linestatus"
//                        "select sum(l_extendedprice * l_discount) as revenue from lineitem"
//
//                )) {
//                    while (result.next()) {
//                        final double avg = result.getDouble(1);
//                        final String group = result.getString(2);
//                        final double progress = result.getDouble(3);
//
//                        // System.out.printf("%f | %s | %f\n", avg, group, progress);
//                        System.out.printf("%f | %s | %f\n", avg, group, progress);
//                    }
//                }
//
//            }
//        }
//    }
//}


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
                        "select progressive sum(l_quantity) as sum_qty, sum(l_extendedprice) as sum_base_price, sum(l_extendedprice * (100 - l_discount)) as sum_disc_price, sum(l_extendedprice * (100 - l_discount) * (100 + l_tax)) as sum_charge, avg(l_quantity) as avg_qty, avg(l_extendedprice) as avg_price, avg(l_discount) as avg_disc, l_returnflag, l_linestatus, PROGRESSIVE_PROGRESS() from lineitem group by l_returnflag, l_linestatus order by l_returnflag, l_linestatus"
                )) {
                    while (result.next()) {

                        final double sum_qty = result.getDouble(1);
                        final double sum_base_price = result.getDouble(2);
                        final double sum_disc_price = result.getDouble(3);
                        final double sum_charge = result.getDouble(4);
                        final double avg_qty = result.getDouble(5);
                        final double avg_price = result.getDouble(6);
                        final double avg_disc = result.getDouble(7);
                        final String return_flag = result.getString(8);
                        final String line_status = result.getString(9);
                        final double progress = result.getDouble(10);

                        System.out.printf("%f | %f | %f | %f | %f | %f | %f | %s | %s | %f\n", sum_qty, sum_base_price, sum_disc_price, sum_charge, avg_qty, avg_price, avg_disc, return_flag, line_status, progress);

                    }
                }

            }
        }
    }
}