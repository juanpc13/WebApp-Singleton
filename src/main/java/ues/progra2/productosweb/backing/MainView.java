package ues.progra2.productosweb.backing;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import ues.progra2.productosweb.entity.Categoria;
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
    List<Categoria> categorias;
    
    private Producto producto;
    
    @PostConstruct
    public void init(){
        producto = new Producto();
        producto.setIdCategoria(new Categoria());
        productos = sc.getPfl().findAll();
        categorias = sc.getCfl().findAll();
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    public void saveProducto(){
        sc.getPfl().create(producto);
        init();
        addMessage("Producto Registrado");
    }
    
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public String getInstanceID(){
        return sc.getIdHashCode();
    }
}
