package com.tienda.service;

import com.tienda.domain.Cliente;
import java.util.List;

public interface ClienteService {

    //Aquí abajo están los métodos para hacer un CRUD
    public List<Cliente> getClientes();

    public List<Cliente> getClientesPorApellidos(String apellidos);

    public List<Cliente> findByApellidos(Cliente cliente);

    public Cliente getCliente(Cliente cliente);

    public void save(Cliente cliente);

    public void delete(Cliente cliente);
}
