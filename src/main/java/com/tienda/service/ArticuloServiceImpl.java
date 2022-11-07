package com.tienda.service;

import com.tienda.dao.ArticuloDao;
import com.tienda.domain.Articulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service //Para considerar la clase servicio
public class ArticuloServiceImpl implements ArticuloService {

    @Autowired //La anotación crea el objeto en caso de no estar creado, si está creado lo usa
    private ArticuloDao articuloDao;

    @Override //Anotación para hacer cambios
    @Transactional(readOnly = true) //Anotación para consultas

    //Aquí abajo están los métodos para hacer un CRUD
    public List<Articulo> getArticulos(boolean filtro) {
        var lista = (List<Articulo>) articuloDao.findAll();
        if (filtro) {//Si es verdadero sólo los articulos activos se deben retornar
            lista.removeIf(e -> !e.isActivo()); //e = elemento
        }
        return lista;
    }

    public Articulo getArticulo(Articulo articulo) {
        return articuloDao.findById(articulo.getIdArticulo()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Articulo articulo) { //Este método sirve para guardar y para actualizar
        //***Si el idArticulo es 0, lo inserta, si tiene algún valor hace update de ése registro
        articuloDao.save(articulo);
    }

    @Override
    @Transactional
    public void delete(Articulo articulo) {
        articuloDao.delete(articulo);
    }
}
