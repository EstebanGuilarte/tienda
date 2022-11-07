package com.tienda.controller;

import com.tienda.domain.Articulo;
import com.tienda.service.ArticuloService;
import com.tienda.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticuloController {

    @Autowired //Para crear el objeto o para que se use si ya existe **No hace más de un objeto
    private ArticuloService articuloService;

    @Autowired //Para crear el objeto o para que se use si ya existe **No hace más de un objeto
    private CategoriaService categoriaService;

    @GetMapping("/articulo/listado")
    public String inicio(Model model) {
        var articulos = articuloService.getArticulos(false);
        model.addAttribute("articulos", articulos);
        return "/articulo/listado";
    }

    @GetMapping("/articulo/nuevo")
    public String articuloNuevo(Articulo articulo) {
        return "/articulo/modificar";
    }

    @PostMapping("/articulo/guardar") //Se usa Post porque no queremos que se vea la información en un URL
    public String articuloGuardar(Articulo articulo) {
        articuloService.save(articulo);
        return "redirect:/articulo/listado";
    }

    @GetMapping("/articulo/elimina/{idArticulo}")
    public String articuloElimina(Articulo articulo) {
        articuloService.delete(articulo);
        return "redirect:/articulo/listado";
    }

    @GetMapping("/articulo/actualiza/{idArticulo}")
    public String articuloActualiza(Articulo articulo, Model model) {
        articulo = articuloService.getArticulo(articulo);
        model.addAttribute("articulo", articulo);
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);
        return "/articulo/modificar";
    }
}
