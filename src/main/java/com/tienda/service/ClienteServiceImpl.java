package com.tienda.service;

import com.tienda.dao.ClienteDao;
import com.tienda.dao.CreditoDao;
import com.tienda.domain.Cliente;
import com.tienda.domain.Credito;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service //Para considerar la clase servicio
public class ClienteServiceImpl implements ClienteService {
    
    @Autowired //La anotación crea el objeto en caso de no estar creado, si está creado lo usa
    private ClienteDao clienteDao;
    
    @Autowired
    private CreditoDao creditoDao;
    
    @Override //Anotación para hacer cambios
    @Transactional(readOnly = true) //Anotación para consultas

    //Aquí abajo están los métodos para hacer un CRUD
    public List<Cliente> getClientes() {
        return (List<Cliente>) clienteDao.findAll();
    }
    
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Cliente cliente) { //Este método sirve para guardar y para actualizar ***Si el idCliente es 0, lo inserta, si tiene algún valor hace update de ése registro
        Credito credito = cliente.getCredito();
        credito = creditoDao.save(credito);
        cliente.setCredito(credito);
        clienteDao.save(cliente);
    }
    
    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }
}
