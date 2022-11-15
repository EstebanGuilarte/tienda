package com.tienda.dao;

import com.tienda.domain.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteDao extends JpaRepository<Cliente, Long> {

    //Asociaciones apliadasd "FindBy"
    public List<Cliente> findByApellidos(String apellidos);

    //Otros ejemplos de asociaciones ampliadas:
    public List<Cliente> findByNombre(String nombre);
    public List<Cliente> findByCorreo(String correo);

}
