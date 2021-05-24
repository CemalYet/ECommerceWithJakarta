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
        style = Style.RPC,
        use = Use.LITERAL
)
public class ProductSoap {
    @Inject
    DataServicesBean dataServicesBean;

    public ProductSoap() {
    }

    @WebMethod
    public void createProduct(@WebParam(name = "Product") ProductEntity product) {
        this.dataServicesBean.createProduct(product);
    }

    public ProductEntity getProduct(@WebParam(name = "ProductId") int productId) {
        return this.dataServicesBean.findByProductId(productId);
    }

    public void deleteProduct(@WebParam(name = "ProductId") int productId) {
        this.dataServicesBean.deleteProductId(productId);
    }
}
