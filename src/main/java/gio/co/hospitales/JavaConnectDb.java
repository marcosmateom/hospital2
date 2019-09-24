package gio.co.hospitales;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.SQLException;

public class JavaConnectDb {

    public static int hospNum = 3;

    public static int getHospNum() {
        return hospNum;
    }

    public static Connection connectDbH(int num) {
        Connection conn = null;
        int numHospital = 1;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            switch (numHospital) {
                case 1:
                    conn = DriverManager.getConnection("jdbc:oracle:thin:@25.14.71.30:1521:ORCL18", "c##hospital1", "admin");
                    break;
                case 2:
                    //conexion del abue
                    conn = DriverManager.getConnection("jdbc:oracle:thin:@25.14.71.30:1521:ORCL18", "c##hospital1", "admin");
                    break;
                case 3:
                    //conexion de manu
                    conn = DriverManager.getConnection("jdbc:oracle:thin:@25.14.71.30:1521:ORCL18", "c##hospital1", "admin");
                    break;
                default:
                    //por defecto es al hospital 1
                    conn = DriverManager.getConnection("jdbc:oracle:thin:@25.14.71.30:1521:ORCL18", "c##hospital1", "admin");
                    break;
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return conn;

    }
}




