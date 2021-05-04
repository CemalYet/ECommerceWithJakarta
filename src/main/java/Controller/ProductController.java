package Controller;


import ejb.DataServicesBean;
import entities.ProductEntity;
import entities.ProductPhotoEntity;
import jakarta.annotation.PostConstruct;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@ViewScoped
@Named
public class ProductController implements Serializable {

    @Inject
    private DataServicesBean dataServicesBean;
    private List<ProductEntity> products;
    private ProductEntity product;
    private List<ProductEntity> cart;
    private ArrayList<String> images = new ArrayList<>();

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

    public ArrayList<String> findProductImage() {

        return images;
    }

    public ArrayList<String> getImages() {
        product = dataServicesBean.findByProductId(product.getIdProduct());
        for (ProductPhotoEntity image: product.getProductPhotos()
        ) {
            images.add(image.getPhoto());

        }
        return images;
    }
}
