package Controller;


import ejb.ShoppingCartBean;
import entities.ProductEntity;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ShoppingCartController implements Serializable {

    @Inject
    private ShoppingCartBean cartBean;
    private List<ProductEntity> cart;


    @PostConstruct
    public void initialize() {
        cart=cartBean.getShoppingCart();
    }
    public void addCart(ProductEntity product) {
        if (cartBean.addProduct(product)){
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "The product is already in the list", "Product adding error"));
        }

    }

    public void removeProduct(ProductEntity product){
        cartBean.removeProduct(product);
    }

    public void emptyCart(){
        cartBean.empty();
    }

    public Double getTotal(){
        return cartBean.getTotal();
    }

    public List<ProductEntity> getCart() {
        return cart;
    }

}
