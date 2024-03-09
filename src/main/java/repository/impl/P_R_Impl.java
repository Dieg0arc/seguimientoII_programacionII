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
        product.setId_empresas(resultSet.getInt("id_empresa"));
        product.setId_practicas(resultSet.getInt("id_practicas"));
        product.setId_personas(resultSet.getInt("id_personas"));
        product.setId_proyecto(resultSet.getInt("id_proyecto"));
        product.setId_roles(resultSet.getInt("id_roles"));

        return product;
    }

    @Override
    public List<Product> list() {
        List<Product> productList = new ArrayList<>();
        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM practicas")) {
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
    public Product byId(Integer id_practicas) {
        Product product = null;
        try (PreparedStatement preparedStatement = getConnection()
                .prepareStatement("SELECT * FROM practicas WHERE id_practicas = ?")) {
            preparedStatement.setLong(1, id_practicas);
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