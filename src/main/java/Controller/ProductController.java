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

    public void findProductImage() throws IOException {
        product = dataServicesBean.findByProductId(product.getIdProduct());
        byte[] image =product.getProductPhotos().get(0).getPhoto();
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletResponse response=(HttpServletResponse) context.getExternalContext().getResponse();
        response.reset();
        response.setContentType("image/jpeg");
        ServletOutputStream outputStream= response.getOutputStream();
        outputStream.write(image);

    }

}
