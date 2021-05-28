package soapClient.Client;



import soapClient.ClientService.CategoryEnum;
import soapClient.ClientService.ProductEntity;
import soapClient.ClientService.ProductSoap;
import soapClient.ClientService.ProductSoapService;

import static soapClient.ClientService.CategoryEnum.ELECTRONICS;

public class Client {
    private static final ProductSoapService productSoapService = new ProductSoapService();

    public static void main(String[] args) {
        //createProduct("SOAPproduct",123.45,"Trying SOAP product",5,ELECTRONICS,2);
        getProduct(6);
        //deleteProduct(122);


    }
    private static void createProduct(String name, double price, String description, int stock, CategoryEnum category, int star) {
        ProductSoap productSoap = productSoapService.getProductSoap();
        ProductEntity newProduct = new ProductEntity();
        newProduct.setName(name);
        newProduct.setDescription(description);
        newProduct.setPrice(price);
        newProduct.setStock(stock);
        newProduct.setCategory(category);
        newProduct.setStar(star);
        productSoap.createProduct(newProduct);
        System.out.println("SOAP Product has been created");
    }
    private static void getProduct(int productId){
        ProductSoap productSoap = productSoapService.getProductSoap();
        ProductEntity askedProduct=productSoap.getProduct(productId);
        System.out.println("Asked product id = "+askedProduct.getIdProduct());
        System.out.println("Asked product name = "+askedProduct.getName());
        System.out.println("Asked product price = "+askedProduct.getPrice()+" $");
        System.out.println("Asked product category = "+askedProduct.getCategory());
        System.out.println("Asked product first comment = "+askedProduct.getComments().get(0).getComment());
        System.out.println("Asked product has " +askedProduct.getStar()+" star");
    }

    private static void deleteProduct(int productId){
        ProductSoap productSoap = productSoapService.getProductSoap();
        productSoap.deleteProduct(productId);
        System.out.println("SOAP product id "+productId+" has been deleted");
    }
}
