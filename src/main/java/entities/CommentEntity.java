package entities;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;


@Entity
@Table(name="comment")
@NamedQuery(name = "findProductComments",
        query = "SELECT c from CommentEntity c where c.product.idProduct=:productId ")
 public class CommentEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentId ;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_id_user")
    private  UserEntity user;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PRODUCT_id_product")
    private ProductEntity product;

    @Column(name="comment")
    private String comment;

    @Column(name="star")
    private int star;


    public CommentEntity() {
    }

    public CommentEntity(String comment, int star) {
        this.comment = comment;
        this.star = star;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getCommentId() {
        return commentId;
    }
    @JsonbTransient
    public UserEntity getUser() {
        return user;
    }

    @JsonbTransient
    public ProductEntity getProduct() {
        return product;
    }

    public String getComment() {
        return comment;
    }

    public int getStar() {
        return star;
    }

}
