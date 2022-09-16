package com.gestion.productos.gestionproductos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 60)
    private String nombre;

    @Column(nullable = false, length = 60)
    private String marca;

    @Column(nullable = false, length = 60)
    private String echoEn;

    @Column(nullable = false)
    private String precio;

    public Producto() {
    }

    public Producto(Long id, String nombre, String marca, String echoEn, String precio) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.echoEn = echoEn;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getEchoEn() {
        return echoEn;
    }

    public void setEchoEn(String echoEn) {
        this.echoEn = echoEn;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

  

    
    
}
