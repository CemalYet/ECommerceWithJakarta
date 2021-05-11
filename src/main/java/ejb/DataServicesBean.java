package ejb;

import entities.*;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.security.enterprise.identitystore.Pbkdf2PasswordHash;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import javax.crypto.SecretKeyFactory;
import java.util.List;


@Stateless
public class DataServicesBean {


    @PersistenceContext(unitName = "DAdemoPU")
    EntityManager em;

    public DataServicesBean() {
    }

    public void createProduct(ProductEntity product){
        product = new ProductEntity();
        em.persist(product);
    }



    @Transactional
    public UserEntity createUserByFields(String name, String email, String password, String surname, String street,
                                 String city, int zipcode) {

        UserEntity newUser = new UserEntity(name, surname, email,password);
        AdressEntity newAddress = new AdressEntity(street, city, zipcode);
        newUser.setAddress(newAddress);
        em.persist(newAddress);
        em.persist(newUser);
        em.flush();
        return newUser;
    }

    @Transactional
    public ProductEntity createProduct(String name, double price, String description, int stock,
                                       CategoryEnum category, int star) {
        ProductEntity newProduct = new ProductEntity(name, price, description, stock, star, category);
        em.persist(newProduct);
        return newProduct;
    }

    public CommentEntity createComment(int userId,int productId,int star,String comment) {
        CommentEntity newComment = new CommentEntity(comment, star);
        newComment.setProduct(findByProductId(productId));
        newComment.setUser(findUserById(userId));
        em.persist(newComment);
        return newComment;
    }


    public UserEntity getUserByNameAndPassword(String username, String password) {
        List<UserEntity> checkUser = em.createNamedQuery("User.byUsername", UserEntity.class)
                .setParameter("username", username)
                .setParameter("password", password)
                .getResultList();
        if (checkUser.isEmpty()) {
            return null;
        }
        return checkUser.get(0);
    }

    public List<ProductEntity> findAllProduct() {
        return em.createNamedQuery("findAllProduct", ProductEntity.class)
                .getResultList();
    }

    public ProductEntity findByProductId(int id) {
        return em.find(ProductEntity.class, id);
    }

    public UserEntity findUserById(int id) {
        return em.find(UserEntity.class, id);
    }

    public List<CommentEntity> getUserComment(int productId){
        return em.createNamedQuery("findProductComments",CommentEntity.class)
                .setParameter("productId",productId)
                .getResultList();
    }

    public void deleteProductId(int productId){
        ProductEntity product=findByProductId(productId);
        if (product == null)
            throw new NotFoundException();
        em.remove(product);
    }




}
