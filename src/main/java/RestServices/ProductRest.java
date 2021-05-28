package RestServices;

import ejb.DataServicesBean;
import entities.ProductEntity;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.net.URI;
import java.util.List;

@Path("/product")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class ProductRest {

    @Inject
    DataServicesBean dataServicesBean;

    @Context
    private UriInfo uriInfo;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createProduct(ProductEntity product) {
        if (product == null)
            throw new BadRequestException();
        dataServicesBean.createProduct(product);
        URI productUri = uriInfo
                .getAbsolutePathBuilder()
                .path(String.valueOf(product.getIdProduct()))
                .build();
        return Response
                .created(productUri)
                .build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProduct(@PathParam("id") int productId) {
        ProductEntity product = dataServicesBean.findByProductId(productId);
        return Response
                .ok(product)
                .build();
    }

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProduct() {
        List<ProductEntity> products;
        products = dataServicesBean.findAllProduct();
        return Response
                .ok(products)
                .build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteProduct(@PathParam("id") int productId) {
        dataServicesBean.deleteProductId(productId);
        return Response
                .ok()
                .build();
    }
}