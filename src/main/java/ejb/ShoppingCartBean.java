package ejb;

import entities.ProductEntity;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Remove;
import jakarta.ejb.Stateful;
import jakarta.inject.Inject;
import jakarta.interceptor.Interceptors;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@Stateful
public class ShoppingCartBean {
    private List<ProductEntity> shoppingCart;
    @Inject
    MessageProducerBean messageProducerBean;

    @PostConstruct
    public void init() {
        shoppingCart = new ArrayList<>();
    }

    @Interceptors(CartInterceptor.class)
    public boolean addProduct(ProductEntity product) {
        if (!shoppingCart.contains(product)) {
            shoppingCart.add(product);
            if(product.getOrderQuantity()>5){
                String message=product.getOrderQuantity() +" "+ product.getName()+" is ordered";
                messageProducerBean.sendJMSMessageToOrderDest(message);
            }
            return true;
        }
        return false;
    }

    @Interceptors(CartInterceptor.class)
    public boolean  removeProduct(ProductEntity product) {
        if (shoppingCart.contains(product)) {
            shoppingCart.remove(product);
            return true;
        }
        return false;
    }



    public Integer getCartSize() {
        if (shoppingCart == null || shoppingCart.isEmpty()) {
            return 0;
        }
        return shoppingCart.size();
    }

    public Double getTotal() {
        if (shoppingCart == null || shoppingCart.isEmpty()) {
            return 0.0;
        }
        double total = 0.0;
        for (ProductEntity product : shoppingCart
        ) {
            total += product.getPrice()*product.getOrderQuantity();
        }
        return total;
    }

    public void empty() {
        if (shoppingCart != null)
            shoppingCart.clear();
    }

    @Remove
    public void checkout() {
        shoppingCart.clear();
    }


    public List<ProductEntity> getShoppingCart() {
        return shoppingCart;
    }
}
