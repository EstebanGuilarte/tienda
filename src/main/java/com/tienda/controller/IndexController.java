package com.tienda.controller;

import com.tienda.dao.ClienteDao;
import com.tienda.domain.Cliente;
import com.tienda.service.ArticuloService;
import com.tienda.service.ClienteService;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired //Para crear el objeto o para que se use si ya existe **No hace más de un objeto

    private ArticuloService articuloService; //Se muestran los artículos porque el motivo de la página es motrar los artículos a la venta

    @GetMapping("/")
    public String inicio(Model model) {
        var articulos = articuloService.getArticulos(true);
        model.addAttribute("articulos", articulos);
        return "index";
    }
}
