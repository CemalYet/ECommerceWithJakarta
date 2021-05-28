
package soapClient.ClientService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for productEntity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="productEntity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idProduct" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stock" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="star" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="category" type="{http://SoapServices/}categoryEnum" minOccurs="0"/>
 *         &lt;element name="productPhotos" type="{http://SoapServices/}productPhotoEntity" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="comments" type="{http://SoapServices/}commentEntity" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="orderQuantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "productEntity", propOrder = {
    "idProduct",
    "name",
    "price",
    "description",
    "stock",
    "star",
    "category",
    "productPhotos",
    "comments",
    "orderQuantity"
})
public class ProductEntity {

    protected int idProduct;
    protected String name;
    protected double price;
    protected String description;
    protected int stock;
    protected int star;
    @XmlSchemaType(name = "string")
    protected CategoryEnum category;
    @XmlElement(nillable = true)
    protected List<ProductPhotoEntity> productPhotos;
    @XmlElement(nillable = true)
    protected List<CommentEntity> comments;
    protected int orderQuantity;

    /**
     * Gets the value of the idProduct property.
     * 
     */
    public int getIdProduct() {
        return idProduct;
    }

    /**
     * Sets the value of the idProduct property.
     * 
     */
    public void setIdProduct(int value) {
        this.idProduct = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the price property.
     * 
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     */
    public void setPrice(double value) {
        this.price = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the stock property.
     * 
     */
    public int getStock() {
        return stock;
    }

    /**
     * Sets the value of the stock property.
     * 
     */
    public void setStock(int value) {
        this.stock = value;
    }

    /**
     * Gets the value of the star property.
     * 
     */
    public int getStar() {
        return star;
    }

    /**
     * Sets the value of the star property.
     * 
     */
    public void setStar(int value) {
        this.star = value;
    }

    /**
     * Gets the value of the category property.
     * 
     * @return
     *     possible object is
     *     {@link CategoryEnum }
     *     
     */
    public CategoryEnum getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link CategoryEnum }
     *     
     */
    public void setCategory(CategoryEnum value) {
        this.category = value;
    }

    /**
     * Gets the value of the productPhotos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the productPhotos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProductPhotos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProductPhotoEntity }
     * 
     * 
     */
    public List<ProductPhotoEntity> getProductPhotos() {
        if (productPhotos == null) {
            productPhotos = new ArrayList<ProductPhotoEntity>();
        }
        return this.productPhotos;
    }

    /**
     * Gets the value of the comments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the comments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommentEntity }
     * 
     * 
     */
    public List<CommentEntity> getComments() {
        if (comments == null) {
            comments = new ArrayList<CommentEntity>();
        }
        return this.comments;
    }

    /**
     * Gets the value of the orderQuantity property.
     * 
     */
    public int getOrderQuantity() {
        return orderQuantity;
    }

    /**
     * Sets the value of the orderQuantity property.
     * 
     */
    public void setOrderQuantity(int value) {
        this.orderQuantity = value;
    }

}
