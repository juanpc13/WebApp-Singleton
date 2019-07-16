package ues.progra2.productosweb.singleton;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.inject.Inject;
import ues.progra2.productosweb.controller.CategoriaFacadeLocal;


import ues.progra2.productosweb.controller.ProductoFacadeLocal;


/**
 *
 * @author jcpleitez
 */
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@Singleton
public class SingletonController {
    
    @Inject
    private ProductoFacadeLocal pfl;
    @Inject
    private CategoriaFacadeLocal cfl;
    
    @Lock(LockType.READ)
    public ProductoFacadeLocal getPfl() {
        return pfl;
    }
    
    @Lock(LockType.READ)
    public CategoriaFacadeLocal getCfl() {
        return cfl;
    }
    
    public String getIdHashCode(){        
        return hashCode()+"";
    }
    
}
