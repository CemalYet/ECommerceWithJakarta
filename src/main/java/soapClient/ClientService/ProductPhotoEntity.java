
package soapClient.ClientService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for productPhotoEntity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="productPhotoEntity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idPhoto" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="photo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="photoOrder" type="{http://www.w3.org/2001/XMLSchema}byte" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "productPhotoEntity", propOrder = {
    "idPhoto",
    "photo",
    "photoOrder"
})
public class ProductPhotoEntity {

    protected int idPhoto;
    protected String photo;
    protected Byte photoOrder;

    /**
     * Gets the value of the idPhoto property.
     * 
     */
    public int getIdPhoto() {
        return idPhoto;
    }

    /**
     * Sets the value of the idPhoto property.
     * 
     */
    public void setIdPhoto(int value) {
        this.idPhoto = value;
    }

    /**
     * Gets the value of the photo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * Sets the value of the photo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoto(String value) {
        this.photo = value;
    }

    /**
     * Gets the value of the photoOrder property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getPhotoOrder() {
        return photoOrder;
    }

    /**
     * Sets the value of the photoOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setPhotoOrder(Byte value) {
        this.photoOrder = value;
    }

}
