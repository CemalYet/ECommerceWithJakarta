package ejb;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;


import static entities.CategoryEnum.Accessories;

public class DataInitializer {

    @Inject
    DataServicesBean dataServicesBean;

    public void execute(@Observes @Initialized(ApplicationScoped.class) Object event){
           /* dataServicesBean.createUser("cemal", "cemal@cemal",
                    "ali", "veli","kesseldellaan","leuven",32);

             dataServicesBean.createUser("Tom Matthews", "tmatthews",
                    "tmatthews", "mathews","bondgenotenlaan","brussel",31);

            dataServicesBean.createProduct("Black Watch", 35.55, "Product Description",
                    11, Accessories, 3);
            dataServicesBean.createProduct("Blue Band", 35.55, "Product Description",
                    5, Accessories, 2);
            dataServicesBean.createProduct("Blue Band", 35.55, "Product Description",
                    3, Accessories, 5);
            dataServicesBean.createProduct("Blue Band", 35.55, "Product Description",
                    2, Accessories, 4);
        UserEntity user1=dataServicesBean.findUserById(1);
        UserEntity user2=dataServicesBean.findUserById(2);
        UserEntity user3=dataServicesBean.findUserById(3);
        UserEntity user4=dataServicesBean.findUserById(4);

        ProductEntity product1=dataServicesBean.findByProductId(1);
        ProductEntity product2=dataServicesBean.findByProductId(1);
        ProductEntity product3=dataServicesBean.findByProductId(1);
        ProductEntity product4=dataServicesBean.findByProductId(1);*/
        //dataServicesBean.createComment();


    }

}
