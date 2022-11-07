package com.tienda.service;

import com.tienda.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    
    //Aquí abajo están los métodos para hacer un CRUD
    public List<Categoria> getCategorias(boolean activos);
    
    public Categoria getCategoria(Categoria categoria);
    
    public void save(Categoria categoria);
    
    public void delete(Categoria categoria);
}
