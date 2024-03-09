package service;

import models.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;

public class Service {
    private Product createProduct(ResultSet resultSet) throws SQLException {
        Product product = new Product();
        product.setId_empresas(resultSet.getInt("id_empresa"));
        product.setId_practicas(resultSet.getInt("id_practicas"));
        product.setId_personas(resultSet.getInt("id_personas"));
        product.setId_proyecto(resultSet.getInt("id_proyecto"));
        product.setId_roles(resultSet.getInt("id_roles"));

        return product;
    }

    }

