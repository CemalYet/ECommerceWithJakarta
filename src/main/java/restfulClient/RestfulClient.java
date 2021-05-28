package restfulClient;



import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

import jakarta.ws.rs.core.UriBuilder;
import entities.ProductEntity;

import java.net.URI;


public class RestfulClient {
    private static final String  baseURI = "http://localhost/a20da21/rest/product";
    private static final URI uri = UriBuilder. fromUri(baseURI).port(8080).build();



    public static void main(String[] args) {
        //productList();
        getProduct("5");
    }

    private static WebTarget getWebTarget() {
        return ClientBuilder
                .newClient()
                .target(uri);
    }

    private static void productList() {
        String path ="getAll";
        String response = getWebTarget()
                .path(path)
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get(String.class);
        System.out.println(response);
    }
    private static void getProduct(String productId){
        String product  = getWebTarget()
                .path(productId)
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get(String.class);
        System.out.println(product);
    }
}
