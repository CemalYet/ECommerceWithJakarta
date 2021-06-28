package ejb;

import entities.*;
import jakarta.ejb.Schedule;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.security.enterprise.identitystore.Pbkdf2PasswordHash;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.security.MessageDigest;


@Stateless
public class DataServicesBean {

    @PersistenceContext(unitName = "DAdemoPU")
    EntityManager em;

    public DataServicesBean() {
    }

    @Transactional
    public UserEntity createUserByFields(String name, String email, String password, String surname, String street,
                                 String city, int zipcode) {
        //cascading event can be added
        UserEntity newUser = new UserEntity(name, surname, email,passwordHash(password));
        AdressEntity newAddress = new AdressEntity(street, city, zipcode);
        newUser.setAddress(newAddress);
        em.persist(newAddress);
        em.persist(newUser);
        em.flush();
        return newUser;
    }
    @Transactional
    public void createProduct(ProductEntity product){
        em.persist(product);
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
    //every wednesday 8.30 to announce the customer
    @Schedule(dayOfWeek="Wed", hour = "8", minute = "30")
    public void cargoFree(){
        System.out.println("Dear customer we have happy news for you today :" +
                " all your shopping that cost more than 20 euros are cargo free  until midnight.");
    }

    public String passwordHash(String passwordToHash){
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(passwordToHash.getBytes());
            //Get the hash's bytes
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
       return generatedPassword;
    }




}
