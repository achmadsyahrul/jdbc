package cobajdbc;

import java.sql.*;

public class DBConnect {
    //String url = "jdbc:mysql://localhost/coba_jdbc";
    String url = "jdbc:mysql://localhost:3306/coba_jdbc?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String username = "root";
    String password = "";
    Connection connection;
    Statement statement;
    public DBConnect() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(url,username,password);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            System.out.println("Koneksi gagal");
        }
    }

    
}
