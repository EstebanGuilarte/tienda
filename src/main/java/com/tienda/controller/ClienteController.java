package com.tienda.controller;

import com.tienda.domain.Cliente;
import com.tienda.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClienteController {

    @Autowired //Para crear el objeto o para que se use si ya existe **No hace más de un objeto
    private ClienteService clienteService;

    @GetMapping("/cliente/listado")
    public String inicio(Model model) {
        var clientes = clienteService.getClientes();
        model.addAttribute("clientes", clientes);
        var limiteTotal = 0;
        for (var c : clientes) {
            limiteTotal += c.credito.limite;
        }
        model.addAttribute("limiteTotal", limiteTotal);
        model.addAttribute("totalClientes", clientes.size());
        return "/cliente/listado";
    }

    @GetMapping("/cliente/nuevo")
    public String clienteNuevo(Cliente cliente) {
        return "/cliente/modificar";
    }

    @PostMapping("/cliente/guardar") //Se usa Post porque no queremos que se vea la información en un URL
    public String clienteGuardar(Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/cliente/listado";
    }

    @GetMapping("/cliente/eliminar/{idCliente}")
    public String clienteElimina(Cliente cliente) {
        clienteService.delete(cliente);
        return "redirect:/cliente/listado";
    }

    @GetMapping("/cliente/modificar/{idCliente}")
    public String clienteActualiza(Cliente cliente, Model model) {
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "/cliente/modificar";
    }

    @GetMapping("/cliente/buscar")
    public String clienteBuscar(Cliente cliente) {
        return "/cliente/buscar";
    }

    @PostMapping("/cliente/busqueda")
    public String clienteBusqueda(Cliente cliente, Model model) {
        var clientes = clienteService.findByApellidos(cliente);
        model.addAttribute("clientes", clientes);
        return "/cliente/busqueda";
    }
}
