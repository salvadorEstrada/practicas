package com.test.producto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductoTest {
    @Autowired
    private ProductoRepository repository;

    @Test
    @Order(1)
    public void testGuardarProducto(){
        Producto newProd = new Producto();
        newProd.setId(1l);
        newProd.setNombre("Televisor HD");
        newProd.setPrecio(17.50f);
        Producto productoNuevo = repository.save(newProd);
        assertNotNull(productoNuevo);

    }

    @Test
    @Order(2)
    public void buscarProductoPorNombre(){
        String nombre ="Televisor HD";
        Producto producto = repository.findByNombre(nombre);
        assertNotNull(producto);
        assertThat(producto.getNombre()).isEqualTo(nombre);

    }


    @Test
    @Order(3)
    public void buscarProductoPorNombreNoExistente(){
        String nombre ="Televisor H";//confirmar qu el producto es nulo
        Producto producto = repository.findByNombre(nombre);
        assertNull(producto);
        //assertThat(producto.getNombre()).isEqualTo(nombre);

    }



}

