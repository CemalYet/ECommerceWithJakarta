package Controller;


import ejb.DataServicesBean;
import entities.ProductEntity;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;


@ViewScoped
@Named
public class ProductController implements Serializable {

    @Inject
    private DataServicesBean dataServicesBean;
    private List<ProductEntity> products;
    private ProductEntity product;
    private List<ProductEntity> cart;

    public ProductController () {
    }

    @PostConstruct
    public void initialize() {
        this.product = new ProductEntity();
        products = dataServicesBean.findAllProduct();

    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public List<ProductEntity> getCart() {
        return cart;
    }

    public void doFindProductById() {
        product = dataServicesBean.findByProductId(product.getIdProduct());
    }


}
