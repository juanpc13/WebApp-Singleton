package ues.progra2.productosweb.singleton;

import java.util.List;
import javax.ejb.AccessTimeout;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.inject.Inject;
import javax.inject.Singleton;
import ues.progra2.productosweb.controller.CategoriaFacadeLocal;
import ues.progra2.productosweb.controller.ProductoFacadeLocal;
import ues.progra2.productosweb.entity.Categoria;
import ues.progra2.productosweb.entity.Producto;

/**
 *
 * @author jcpleitez
 */
@Singleton
public class SingletonController {    
    
    @Inject
    private ProductoFacadeLocal pfl;
    private CategoriaFacadeLocal cfl;
    
    @Lock(LockType.WRITE)
    @AccessTimeout(value = 1000)
    Producto createProducto(Producto p){
        return pfl.createObId(p);
    }
    
    @Lock(LockType.READ)    
    List<Producto> allProductos(){
        return pfl.findAll();
    }
    
    @Lock(LockType.WRITE)
    @AccessTimeout(value = 1000)
    Categoria createCategoria(Categoria p){
        return cfl.createObId(p);
    }
    
    @Lock(LockType.READ)    
    List<Categoria> allCategorias(){
        return cfl.findAll();
    }

    
    
}
