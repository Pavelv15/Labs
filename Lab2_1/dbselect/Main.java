package dbselect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Main {
    public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    public  static final String CONNECTION_STRING  = "jdbc:mysql://localhost:3306/web?user=******&password=****";
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Class.forName(DRIVER_NAME);
        System.out.println("Введите слово для фильтрации(Если ничего не ввести и нажать на enter, выведится весь список)");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String search = reader.readLine();


        try (Connection connection = DriverManager.getConnection(CONNECTION_STRING)){
//            String sql = "SELEcT title,length FROM courses order by title;";
//            Statement cmd = connection.createStatement();
//            ResultSet result =  cmd.executeQuery(sql);  //SELECT
             // для INSERT, UPDATE ,DELETE используется cmd.executeUpdate()

            String sql = "SELEcT title,length FROM courses where title LIKE ? order by title;";
            PreparedStatement cmd = connection.prepareStatement(sql);
            cmd.setString(1,"%" + search +"%");
            ResultSet result = cmd.executeQuery();

            while (result.next()) {
                String title = result.getString("title");
                int length = result.getInt("length");
                System.out.printf("%-40s %d\n",title,length);


            }
            result.close();


        }


    }
}
