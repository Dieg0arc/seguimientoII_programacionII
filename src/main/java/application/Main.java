package application;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/proyectos";
        String user = "root";
        String password= "";
        try (Connection conn = DriverManager.getConnection(url,user,password);
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM practicas");
        ){
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id_empresa"));
            System.out.println("|");
            System.out.println(resultSet.getInt("id_practicas"));
            System.out.println("|");
            System.out.println(resultSet.getInt("id_personas"));
            System.out.println("|");
            System.out.println(resultSet.getInt("id_proyecto"));
            System.out.println("|");
            System.out.println(resultSet.getInt("id_roles"));


        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
}
}
