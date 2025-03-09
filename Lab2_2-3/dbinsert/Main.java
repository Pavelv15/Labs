package dbinsert;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    public  static final String CONNECTION_STRING  = "jdbc:mysql://localhost:3306/web?user=root&password=Lolk@$01";
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName(DRIVER_NAME);
        try (Connection connection = DriverManager.getConnection(CONNECTION_STRING)){
            Scanner sc  = new Scanner(System.in);
            System.out.print("Название курса:");
            String title = sc.nextLine().trim();
            System.out.print("Длительность курса");
            int length = sc.nextInt();
            if(sc.hasNextLine()) sc.nextLine();
            System.out.print("Описание курса:");
            String description = sc.nextLine().trim();

            String sql = "INSERT INTO Courses (title,length,description)" + " VALUES (?,?,?)";
            PreparedStatement  cmd = connection.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);
            cmd.setString(1,title);
            cmd.setInt(2,length);
            cmd.setString(3,description);

            if ( cmd.executeUpdate() == 1) {
                try (ResultSet ids = cmd.getGeneratedKeys()) {
                    if (ids.next()) {
                        int generated_id = ids.getInt(1);
                        System.out.printf("Курс добавлен. ID %d\n",generated_id);
                    }

                }
            }







        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
