package com.gestion.productos.gestionproductos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gestion.productos.gestionproductos.entity.Producto;

public interface ProductoRepositorio extends JpaRepository<Producto, Long> {
    
    @Query("SELECT p FROM Producto p WHERE"
            + " CONCAT(p.id,p.nombre,p.echoEn,p.precio)"
            + " LIKE %?1%")
    public List<Producto> findAll(String palabraClave);
    
}
