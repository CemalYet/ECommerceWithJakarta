package ejb;

import entities.*;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.security.enterprise.identitystore.Pbkdf2PasswordHash;
import jakarta.transaction.Transactional;

import javax.crypto.SecretKeyFactory;
import java.util.List;


@Stateless
public class DataServicesBean {


    @PersistenceContext(unitName = "DAdemoPU")
    EntityManager em;
   /* @Inject
    Pbkdf2PasswordHash passwordHash;*/


    public DataServicesBean() {
    }


    @Transactional
    public UserEntity createUser(String name, String email, String password, String surname, String street,
                                 String city, int zipcode) {

        //passwordHashInitialize();
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

    @Transactional
    public CommentEntity createComment() {

        UserEntity newUser = findUserById(2);
        ProductEntity newProduct = findByProductId(4);
        CommentEntity newComment = new CommentEntity("This product is amazing", 3);
        newComment.setProduct(newProduct);
        newComment.setUser(newUser);
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




}
