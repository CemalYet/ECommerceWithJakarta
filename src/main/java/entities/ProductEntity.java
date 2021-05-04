package entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@NamedQuery(name = "findAllProduct",
        query = "SELECT p from ProductEntity p ")
@Entity
@Table(name="product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_product")
    private int idProduct;

    @Column(name="name",nullable = false)
    @Size(max = 100)
    private String name;

    @Column(name="price",nullable = false)
    private double price;

    @Column(name="description",nullable = false)
    @Size(max = 100)
    private String description;

    @Column(name="stock",nullable = false)
    private int stock;

    @Column(name="star")
    private int star;

    @Column(name="category",nullable = false)
    private CategoryEnum category;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval=true)
    @JoinColumn
    private List<ProductPhotoEntity> productPhotos;

    @OneToMany (mappedBy = "product",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<CommentEntity> comments;
    @Transient
    private int orderQuantity;

    public ProductEntity() {
    }

    public ProductEntity(String name, double price, String description, int stock, int star, CategoryEnum category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.stock = stock;
        this.star = star;
        this.category = category;
        this.productPhotos =new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public void setStar(int star) {
        this.star = star;
    }
    public void setProductPhotos() {
        this.productPhotos=new ArrayList<>();
    }
    public void setComments(List<CommentEntity> comments) {
        this.comments = comments;
    }
    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public int getIdProduct() {
        return idProduct;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public String getDescription() {
        return description;
    }
    public int getStock() {
        return stock;
    }
    public int getStar() {
        return star;
    }
    public List<ProductPhotoEntity> getProductPhotos() {
        return this.productPhotos;
    }
    public List<CommentEntity> getComments() {
        return comments;
    }
    public CategoryEnum getCategory() {
        return category;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }
    public int getCommentSize(){
        return  comments.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return idProduct == that.idProduct && stock == that.stock && name.equals(that.name)  && description.equals(that.description) && star == that.star && category == that.category && productPhotos.equals(that.productPhotos) && Objects.equals(comments, that.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct, name, price, description, stock, star, category, productPhotos, comments);
    }
}
