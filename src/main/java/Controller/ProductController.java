package Controller;


import ejb.CommentBean;
import ejb.DataServicesBean;
import entities.CommentEntity;
import entities.ProductEntity;
import entities.ProductPhotoEntity;
import entities.UserEntity;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.primefaces.PrimeFaces;

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
    private List<ProductPhotoEntity> images;
    private CommentEntity comment;
    private List<CommentEntity> comments;
    @EJB
    private CommentBean commentBean;

    public ProductController() {
    }

    @PostConstruct
    public void initialize() {
        this.product = new ProductEntity();
        comment=new CommentEntity();
        products = dataServicesBean.findAllProduct();
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public CommentEntity getComment() {
        return comment;
    }

    public void doFindProductById() {
        product = dataServicesBean.findByProductId(product.getIdProduct());
    }

    public List<ProductPhotoEntity> getImages() {
        return product.getProductPhotos();
    }

    public List<CommentEntity> getComments() {
        comments= dataServicesBean.getUserComment(product.getIdProduct());
        return comments;
    }

    public void addComment(int user, int product){
        if (comment.getComment()==null || comment.getStar()==0  ) {
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Warning", "Comment and Star can not be null"));
        }else{
            dataServicesBean.createComment(user,product,comment.getStar(),comment.getComment());
            //commentBean.createComment(user,product,comment.getStar(),comment.getComment());
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Info", "Your comment was added"));
            PrimeFaces.current().executeScript("PF('manageCommentDialog').hide()");
        }

    }
}