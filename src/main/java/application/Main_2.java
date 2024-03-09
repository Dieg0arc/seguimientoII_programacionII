package application;

import models.Product;
import repository.Repository;
import repository.impl.P_R_Impl;

import java.sql.Connection;
import java.sql.SQLException;

public class Main_2 {
    public static void main(String[] args) {
        try (Connection conn = D_b_Connection.getInstance()) {
            Repository<Product> repository = new P_R_Impl();
            System.out.println("*** List products from database");
            repository.list().forEach(System.out::println);
            System.out.println("*** Get by Id: 1");
            System.out.println(repository.byId(1).toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
