package restfulClient;


import entities.CategoryEnum;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import entities.ProductEntity;

import java.net.URI;
import java.util.List;

import static entities.CategoryEnum.Fitness;


public class RestfulClient {
    private static final String baseURI = "http://localhost/a20da21/rest/product";
    private static final URI uri = UriBuilder.fromUri(baseURI).port(8080).build();


    public static void main(String[] args) {
       // createProduct("Jsonproduct",123.45,"Trying Json product",5,Fitness,2);
       // deleteProduct(127);
        productList();
        getProduct(5);
        getProduct(3);
    }

    private static WebTarget getWebTarget() {
        return ClientBuilder
                .newClient()
                .target(uri);
    }

    private static void productList() {
        String path = "getAll";
        List<ProductEntity> products = getWebTarget()
                .path(path)
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<ProductEntity>>() {
                });
        System.out.println("There are totally "+products.size()+" products in your inventory ");
    }

    private static void getProduct(int productId) {
        ProductEntity product = getWebTarget()
                .path(String.valueOf(productId))
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get(ProductEntity.class);
        System.out.println("Product id : "+product.getIdProduct()+" , Product name: "+product.getName());
    }

    private static void createProduct(String name, double price, String description, int stock, CategoryEnum category, int star) {
        ProductEntity newProduct = new ProductEntity();
        newProduct.setName(name);
        newProduct.setDescription(description);
        newProduct.setPrice(price);
        newProduct.setStock(stock);
        newProduct.setCategory(category);
        newProduct.setStar(star);
        Response response = getWebTarget()
                .request()
                .post(Entity.entity(newProduct, MediaType.APPLICATION_JSON), Response.class);
        System.out.println(response);
    }

    private static void deleteProduct(int productId) {
        Response response = getWebTarget()
                .path(String.valueOf(productId))
                .request()
                .delete();
        System.out.println(response);
    }
}
