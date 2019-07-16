package ues.progra2.productosweb.backing;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import ues.progra2.productosweb.entity.Producto;
import ues.progra2.productosweb.singleton.SingletonController;

/**
 *
 * @author jcpleitez
 */
@Named
@ViewScoped
public class MainView implements Serializable{
    
    @EJB
    SingletonController sc;
    
    List<Producto> productos;
    
    @PostConstruct
    public void init(){
        productos = sc.getPfl().findAll();
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    
    
}
