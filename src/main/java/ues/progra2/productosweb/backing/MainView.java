package ues.progra2.productosweb.backing;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import ues.progra2.productosweb.controller.ProductoFacadeLocal;

/**
 *
 * @author jcpleitez
 */
@Named
@ViewScoped
public class MainView implements Serializable{
    
    @Inject
    private ProductoFacadeLocal pfl;    
    
    private Integer numbreOfProducts;
    
    @PostConstruct
    public void init(){
        numbreOfProducts = pfl.count();
    }

    public Integer getNumbreOfProducts() {
        return numbreOfProducts;
    }

    public void setNumbreOfProducts(Integer numbreOfProducts) {
        this.numbreOfProducts = numbreOfProducts;
    }
    
}
