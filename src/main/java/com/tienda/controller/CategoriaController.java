package com.tienda.controller;

import com.tienda.domain.Categoria;
import com.tienda.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoriaController {

    @Autowired //Para crear el objeto o para que se use si ya existe **No hace más de un objeto
    private CategoriaService categoriaService;

    @GetMapping("/categoria/listado")
    public String inicio(Model model) {
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);
        return "/categoria/listado";
    }

    @GetMapping("/categoria/nuevo")
    public String categoriaNuevo(Categoria categoria) {
        return "/categoria/modificar";
    }

    @PostMapping("/categoria/guardar") //Se usa Post porque no queremos que se vea la información en un URL
    public String categoriaGuardar(Categoria categoria) {
        categoriaService.save(categoria);
        return "redirect:/categoria/listado";
    }

    @GetMapping("/categoria/elimina/{idCategoria}")
    public String categoriaElimina(Categoria categoria) {
        categoriaService.delete(categoria);
        return "redirect:/categoria/listado";
    }

    @GetMapping("/categoria/actualiza/{idCategoria}")
    public String categoriaActualiza(Categoria categoria, Model model) {
        categoria = categoriaService.getCategoria(categoria);
        model.addAttribute("categoria", categoria);
        return "/categoria/modificar";
    }
}
