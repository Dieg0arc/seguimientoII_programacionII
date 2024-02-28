package service;

import models.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;

public class Service {
    private Product createProduct(ResultSet resultSet) throws SQLException {
        Product product = new Product();
        product.setId(resultSet.getLong("id"));
        product.setNombre(resultSet.getString("nombre"));
        product.setPrecio(resultSet.getDouble("precio"));
        product.setFecha_registro(resultSet.getDate("fecha_registro") != null ?
                resultSet.getDate("fecha_regsitro")
                        .toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime():
                null);
        return product;
    }

    }

