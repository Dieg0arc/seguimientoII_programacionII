package models;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder


public class Product {
    private Long id;
    private String nombre;
    private double precio;
    private LocalDateTime fecha_registro;


}
