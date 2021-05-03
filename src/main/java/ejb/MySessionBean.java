package ejb;

import entities.*;
import jakarta.persistence.EntityManager;

import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@jakarta.ejb.Stateless(name = "MySessionBeanEJB")
public class MySessionBean {
    @PersistenceContext(unitName = "DAdemoPU")
    EntityManager em;
    public MySessionBean() {
    }
    public List<UserNameEntity> findPersonByName(String name){
            return em.createNamedQuery("findPersonByName", UserNameEntity.class).
                    setParameter("searchname", "%" + name + "%").
                    getResultList();

    }
    public UserNameEntity findOnePersonByName(String name){
        return  em.createNamedQuery("findPersonByName", UserNameEntity.class)
                    .setParameter("searchname",name)
                    .getSingleResult();
    }


    public  UserNameEntity doSomethingReallyDifficult(int id){
       return em.find(UserNameEntity.class,id);

    }


    public UserNameEntity create(String name,String email){
        UserNameEntity userNameEntity=new UserNameEntity();
        userNameEntity.setName(name);
        userNameEntity.setEmail(email);
        em.persist(userNameEntity);
         return userNameEntity;
    }


    @Transactional
    public UserEntity createUser(String name,String surName,String email,String password,String street,String city,int zipcode){
        UserEntity newUser=new UserEntity();
        newUser.setEmail(email);
        newUser.setName(name);
        newUser.setPassword(password);
        newUser.setSurname(surName);
        AdressEntity newAddress=new AdressEntity();
        newAddress.setStreet(street);
        newAddress.setCity(city);
        newAddress.setZipcode(zipcode);
        newUser.setAddress(newAddress);
        em.persist(newAddress);
        em.persist(newUser);
        return newUser;

    }


    @Transactional
    public ProductEntity createProduct(String name, double price, String description, int stock, CategoryEnum category,int star){
        ProductEntity newProduct=new ProductEntity();
        newProduct.setName(name);
        newProduct.setDescription(description);
        newProduct.setPrice(price);
        newProduct.setStock(stock);
        newProduct.setCategory(category);
        newProduct.setStar(star);
        em.persist(newProduct);
        return newProduct;
    }

    public UserEntity findById(int id){
       return em.find(UserEntity.class,id);
    }



}
