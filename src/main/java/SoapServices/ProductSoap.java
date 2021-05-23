package SoapServices;


import ejb.DataServicesBean;
import entities.ProductEntity;
import jakarta.inject.Inject;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

import static jakarta.jws.soap.SOAPBinding.Style.RPC;
import static jakarta.jws.soap.SOAPBinding.Use.LITERAL;



@WebService (portName = "ProductSoap", serviceName = "ProductSoapService")
@SOAPBinding(style = RPC, use = LITERAL)
public class ProductSoap {
    @Inject
    DataServicesBean dataServicesBean;


    public void createProduct(@WebParam(name ="Product") ProductEntity product){
        dataServicesBean.createProduct(product);
    }

    public ProductEntity getProduct(@WebParam(name ="ProductId") int productId){
        return dataServicesBean.findByProductId(productId);
    }

    public double getProductPrice(@WebParam(name ="ProductId") int productId){
        return dataServicesBean.findByProductId(productId).getPrice();
    }

    public String getProductName(@WebParam(name ="ProductId") int productId){
        return dataServicesBean.findByProductId(productId).getName();
    }

    public void deleteProduct(@WebParam(name ="ProductId")int productId) {
        dataServicesBean.deleteProductId(productId);
    }

}
