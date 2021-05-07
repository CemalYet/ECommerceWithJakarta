package ejb;

import entities.CommentEntity;
import entities.ProductEntity;
import entities.UserEntity;
import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Singleton
public class CommentBean {
    @PersistenceContext(unitName = "DAdemoPU")
    EntityManager em;

    @Transactional
    public CommentEntity createComment(UserEntity user,ProductEntity product,int star,String comment) {
        CommentEntity newComment = new CommentEntity(comment, star);
        newComment.setProduct(product);
        newComment.setUser(user);
        em.persist(newComment);
        return newComment;
    }
}
