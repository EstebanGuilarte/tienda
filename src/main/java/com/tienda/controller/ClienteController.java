package com.tienda.controller;

import com.tienda.dao.ClienteDao;
import com.tienda.domain.Cliente;
import com.tienda.service.ClienteService;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClienteController {

    @Autowired //Para crear el objeto o para que se use si ya existe **No hace más de un objeto
    private ClienteService clienteService;

    @GetMapping("/cliente/nuevo")
    public String clienteNuevo(Cliente cliente) {
        return "modificarCliente";
    }

    @PostMapping("/cliente/guardar") //Se usa Post porque no queremos que se vea la información en un URL
    public String clienteGuardar(Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/";
    }
    
     @GetMapping("/cliente/elimina/{idCliente}")
    public String clienteElimina(Cliente cliente) {
        clienteService.delete(cliente);
        return "redirect:/";
    }

    @GetMapping("/cliente/actualiza/{idCliente}")
    public String clienteActualiza(Cliente cliente, Model model) {
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "modificarCliente";
    }
}
