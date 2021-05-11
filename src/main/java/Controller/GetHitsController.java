package Controller;


import ejb.GetHits;
import entities.CommentEntity;
import entities.ProductEntity;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@SessionScoped
public class GetHitsController implements Serializable {
    @EJB
    private GetHits getHits;
    private int visitNumber;

    @PostConstruct
    public void initialize() {
        visitNumber=0;
    }

    public int getVisitNumber() {
        visitNumber=getHits.getHits();
        return  visitNumber;
    }

    public void setVisitNumber(int visitNumber) {
        this.visitNumber = visitNumber;
    }
}
