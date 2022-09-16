package com.gestion.productos.gestionproductos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.gestion.productos.gestionproductos.entity.Producto;
import com.gestion.productos.gestionproductos.services.ProductoServicio;

@Controller
public class ProductoControlador {
    
    @Autowired
    ProductoServicio productoServicio;

    @RequestMapping("/")
    public String verPaginaInicio(Model model, @Param("palabraClave") String palabraClave) {        
        List<Producto> listarProductos = productoServicio.listAll(palabraClave);

        model.addAttribute("listarProductos", listarProductos);
        model.addAttribute("palabraClave", palabraClave);
        return "index";
    }

    @RequestMapping("/nuevo")
    public String mostrarFormularioNuevoProducto(Model model) {
        Producto producto = new Producto();
        model.addAttribute("producto", producto);

        return "nuevo_producto";

    }
    
    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String guardarProducto(@ModelAttribute("producto") Producto producto) {
        productoServicio.save(producto);
        return "redirect:/";

    }
    
    @RequestMapping("/editar/{id}")
    public ModelAndView mostrarFormularioDeEditarProducto(@PathVariable Long id) {
        ModelAndView model = new ModelAndView("editar_producto");

        Producto producto = productoServicio.get(id);

        model.addObject("producto", producto);

        return model;

    }
    
    @RequestMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        productoServicio.delete(id);
        return "redirect:/";
        
    }
}
