package com.test.producto;

import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository<Producto, Long> {

    public Producto findByNombre(String nombre);

}
