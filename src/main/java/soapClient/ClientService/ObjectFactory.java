
package soapClient.ClientService;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the soapservices package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ProductEntity_QNAME = new QName("http://SoapServices/", "productEntity");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: soapservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ProductEntity }
     * 
     */
    public ProductEntity createProductEntity() {
        return new ProductEntity();
    }

    /**
     * Create an instance of {@link ProductPhotoEntity }
     * 
     */
    public ProductPhotoEntity createProductPhotoEntity() {
        return new ProductPhotoEntity();
    }

    /**
     * Create an instance of {@link CommentEntity }
     * 
     */
    public CommentEntity createCommentEntity() {
        return new CommentEntity();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProductEntity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://SoapServices/", name = "productEntity")
    public JAXBElement<ProductEntity> createProductEntity(ProductEntity value) {
        return new JAXBElement<ProductEntity>(_ProductEntity_QNAME, ProductEntity.class, null, value);
    }

}
