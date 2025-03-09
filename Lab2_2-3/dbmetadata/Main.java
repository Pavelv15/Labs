package dbmetadata;

import java.sql.*;

public class Main {
    public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    public static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/web?user=root&password=Lolk@$01";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER_NAME);
        try (Connection connection = DriverManager.getConnection(CONNECTION_STRING)) {

            //Получение информации о объектах БД
            DatabaseMetaData metaData  = connection.getMetaData();
// Получеие табличек
            try ( ResultSet result = metaData.getTables("web","web",null,null)) {
                while (result.next()) {
                    String tableName = result.getString("TABLE_NAME");
                    System.out.println(tableName);
                }
            }


            try ( ResultSet result = metaData.getProcedures("web","web",null)) {

                while (result.next()) {
                    String procedure = result.getString("PROCEDURE_NAME");

                    System.out.println(procedure);
                }
            }





        }
    }
}

