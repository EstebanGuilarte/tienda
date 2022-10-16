package com.tienda.controller;

import com.tienda.dao.ClienteDao;
import com.tienda.domain.Cliente;
import com.tienda.service.ClienteService;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    
    @Autowired //Para crear el objeto o para que se use si ya existe **No hace más de un objeto
    //private ClienteDao clienteDao;
    private ClienteService clienteService;
    
    @GetMapping("/")
    public String inicio(Model model) {
        var texto="Estamos en semana #4";
        model.addAttribute("saludo", texto);
        
        /*Cliente cliente1=new Cliente("Pedro","Jiménez Retana","pjimenez@gmail.com","8888-8888");
        Cliente cliente2=new Cliente("Juan","Retana Jiménez","jretana@gmail.com","9999-9999");
        Cliente cliente3=new Cliente("Rodrigo","Retana Jiménez","Rretana@gmail.com","9999-9999");        
        var clientes=Arrays.asList(cliente1,cliente2,cliente3);
        var clientes = clienteDao.findAll();*/
        
        var clientes = clienteService.getClientes();
        
        model.addAttribute("clientes", clientes);
        
        return "index";
    }
}
