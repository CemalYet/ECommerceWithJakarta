package SoapServices;

import ejb.DataServicesBean;
import entities.ProductEntity;
import jakarta.inject.Inject;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.Style;
import jakarta.jws.soap.SOAPBinding.Use;

@WebService(
        portName = "ProductSoap",
        serviceName = "ProductSoapService"
)
@SOAPBinding(
        //The SOAP message contains the parameters and the return values
        style = Style.RPC,
        use = Use.LITERAL
)
//wsimport was used to create soapClient  
public class ProductSoap {
    @Inject
    DataServicesBean dataServicesBean;

    public ProductSoap() {
    }

    @WebMethod
    public void createProduct(@WebParam(name = "Product") ProductEntity product) {
        this.dataServicesBean.createProduct(product);
    }
    @WebMethod
    public ProductEntity getProduct(@WebParam(name = "ProductId") int productId) {
        return this.dataServicesBean.findByProductId(productId);
    }
    @WebMethod
    public void deleteProduct(@WebParam(name = "ProductId") int productId) {
        this.dataServicesBean.deleteProductId(productId);
    }
}
