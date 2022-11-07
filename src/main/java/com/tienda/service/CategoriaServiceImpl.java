package com.tienda.service;

import com.tienda.dao.CategoriaDao;
import com.tienda.domain.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service //Para considerar la clase servicio
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired //La anotación crea el objeto en caso de no estar creado, si está creado lo usa
    private CategoriaDao categoriaDao;

    @Override //Anotación para hacer cambios
    @Transactional(readOnly = true) //Anotación para consultas

    //Aquí abajo están los métodos para hacer un CRUD
    public List<Categoria> getCategorias(boolean filtro) {
        var lista = (List<Categoria>) categoriaDao.findAll();
        if (filtro) {//Si es verdadero sólo las categorias activas se deben retornar
            lista.removeIf(e -> !e.isActivo()); //e = elemento
        }
        return lista;
    }

    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Categoria categoria) { //Este método sirve para guardar y para actualizar
        //***Si el idCategoria es 0, lo inserta, si tiene algún valor hace update de ése registro
        categoriaDao.save(categoria);
    }

    @Override
    @Transactional
    public void delete(Categoria categoria) {
        categoriaDao.delete(categoria);
    }
}
