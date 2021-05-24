package soapClient.Client;

import soapClient.ClientService.ProductEntity;
import soapClient.ClientService.ProductSoap;
import soapClient.ClientService.ProductSoapService;

public class Client {
    public static void main(String[] args) {

        ProductSoapService productSoapService =new ProductSoapService();
        ProductSoap productSoap = productSoapService.getProductSoap();
        ProductEntity askedProduct=productSoap.getProduct(1);
        System.out.println("Asked product id = "+askedProduct.getIdProduct());
        System.out.println("Asked product name = "+askedProduct.getName());
        System.out.println("Asked product price = "+askedProduct.getPrice()+" $");
        System.out.println("Asked product category = "+askedProduct.getCategory());
        System.out.println("Asked product first comment = "+askedProduct.getComments().get(0).getComment());
        System.out.println("Asked product has " +askedProduct.getStar()+" star");
    }
}
