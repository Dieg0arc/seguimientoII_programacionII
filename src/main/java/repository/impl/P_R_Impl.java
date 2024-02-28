package repository.impl;

import application.D_b_Connection;
import models.Product;
import repository.Repository;

import java.sql.*;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class P_R_Impl implements Repository<Product>{

    private Connection getConnection() throws SQLException {
        return D_b_Connection.getInstance();
    }
    private Product createProduct(ResultSet resultSet) throws SQLException {
        Product product = new Product();
        product.setId(resultSet.getLong("id"));
        product.setNombre(resultSet.getString("nombre"));
        product.setPrecio(resultSet.getDouble("precio"));

        java.sql.Timestamp registerTimestamp = resultSet.getTimestamp("fecha_registro");
        if (registerTimestamp != null) {
            product.setFecha_registro(registerTimestamp.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
        } else {
            product.setFecha_registro(null);
        }

        return product;
    }

    @Override
    public List<Product> list() {
        List<Product> productList = new ArrayList<>();
        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM new_table")) {
            while (resultSet.next()) {
                Product product = createProduct(resultSet);
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public Product byId(Long id) {
        Product product = null;
        try (PreparedStatement preparedStatement = getConnection()
                .prepareStatement("SELECT * FROM new_table WHERE id = ?")) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                product = createProduct(resultSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public void delete(Long id) {

    }
}