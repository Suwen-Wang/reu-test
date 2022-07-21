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
////                statement.execute("CREATE TABLE IF NOT EXISTS test ( l_orderkey BIGINT, l_partkey INTEGER, l_suppkey INTEGER, l_linenumber INTEGER, l_quantity NUMERIC, l_extendedprice NUMERIC, l_discount NUMERIC, l_tax NUMERIC, l_returnflag CHAR(1), l_linestatus CHAR(1), l_shipdate DATE, l_commitdate DATE, l_receiptdate DATE, l_shipinstruct CHAR(25), l_shipmode CHAR(10), l_comment VARCHAR(44))");
//
////                statement.execute("CREATE TABLE IF NOT EXISTS lineitem ( l_orderkey BIGINT, l_partkey INTEGER, l_suppkey INTEGER, l_linenumber INTEGER, l_returnflag VARCHAR(44), l_linestatus VARCHAR(44), l_shipinstruct VARCHAR(44), l_shipmode VARCHAR(44), l_comment VARCHAR(44))");
//
//                  statement.execute("CREATE TABLE IF NOT EXISTS lineitem ( l_extendedprice BIGINT, l_discount BIGINT )");
//
//
////                statement.execute("INSERT INTO test VALUES (1, 155190, 7706, 1, 17, 21168.23, 0.04, 0.02, 'N', 'O', '1996-03-13', '1996-02-12', '1996-03-22', 'DELIVER IN PERSON', 'TRUCK', 'egular courts above the')");
////                statement.execute("INSERT INTO test VALUES (1, 67310, 7311, 2, 36, 45983.16, 0.09, 0.06, 'N', 'O', '1996-04-12', '1996-02-28', '1996-04-20', 'TAKE BACK RETURN', 'MAIL', 'ly final dependencies: slyly bold')");
////                statement.execute("INSERT INTO test VALUES (1, 63700, 3701, 3, 8, 13309.60, 0.10, 0.02, 'N', 'O', '1996-01-29', '1996-03-05', '1996-01-31', 'TAKE BACK RETURN', 'REG AIR', 'riously. regular, express dep')");
////                statement.execute("INSERT INTO test VALUES (1, 2132, 4633, 4, 28, 28955.64, 0.09, 0.06, 'N', 'O', '1996-04-21', '1996-03-30', '1996-05-16', 'NONE', 'AIR', 'lites. fluffily even de')");
//
//
////                statement.execute("INSERT INTO test VALUES (155190, 7706, 1, 17, 'N', 'O', 'DELIVER IN PERSON', 'TRUCK', 'egular courts above the')");
////                statement.execute("INSERT INTO test VALUES (67310, 7311, 2, 36, 'N', 'O', 'TAKE BACK RETURN', 'MAIL', 'ly final dependencies: slyly bold')");
////                statement.execute("INSERT INTO test VALUES (63700, 3701, 3, 8, 'N', 'O', 'TAKE BACK RETURN', 'REG AIR', 'riously. regular, express dep')");
////                statement.execute("INSERT INTO test VALUES (2132, 4633, 4, 28, 'N', 'O', 'NONE', 'AIR', 'lites. fluffily even de')");
//
//                statement.execute("INSERT INTO lineitem VALUES (4, 2)");
//                statement.execute("INSERT INTO lineitem VALUES (9, 6)");
//                statement.execute("INSERT INTO lineitem VALUES (10, 2)");
//                statement.execute("INSERT INTO lineitem VALUES (9, 6)");
//
//                statement.execute("PREPARE TABLE lineitem");
//
//            }
//        }
//
//    }
//}


package edu.illinois.deepola.suwen.lineitem;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) throws Exception {
        try (Connection connection = DriverManager.getConnection("jdbc:avatica:remote:url=http://localhost:9000")) {
            try (Statement statement = connection.createStatement()) {

                statement.execute("CREATE TABLE IF NOT EXISTS lineitem ( l_orderkey BIGINT, l_partkey INTEGER, l_suppkey INTEGER, l_linenumber INTEGER, l_quantity INTEGER, l_extendedprice INTEGER, l_discount INTEGER, l_tax INTEGER, l_returnflag VARCHAR(1), l_linestatus VARCHAR(1), l_shipdate VARCHAR(44), l_commitdate VARCHAR(44), l_receiptdate VARCHAR(44), l_shipinstruct VARCHAR(44), l_shipmode VARCHAR(44), l_comment VARCHAR(44))");

                statement.execute("INSERT INTO lineitem VALUES (1, 155190, 7706, 1, 1700, 21168, 4, 2, 'N', 'O', '1996-03-13', '1996-02-12', '1996-03-22', 'DELIVER IN PERSON', 'TRUCK', 'egular courts above the')");
                statement.execute("INSERT INTO lineitem VALUES (1, 67310, 7311, 2, 3600, 45983, 9, 6, 'N', 'O', '1996-04-12', '1996-02-28', '1996-04-20', 'TAKE BACK RETURN', 'MAIL', 'ly final dependencies: slyly bold')");
                statement.execute("INSERT INTO lineitem VALUES (1, 63700, 3701, 3, 800, 13310, 10, 2, 'N', 'O', '1996-01-29', '1996-03-05', '1996-01-31', 'TAKE BACK RETURN', 'REG AIR', 'riously. regular, express dep')");
                statement.execute("INSERT INTO lineitem VALUES (1, 2132, 4633, 4, 2800, 28956, 9, 6, 'N', 'O', '1996-04-21', '1996-03-30', '1996-05-16', 'NONE', 'AIR', 'lites. fluffily even de')");

                statement.execute("PREPARE TABLE lineitem");

            }
        }

    }
}