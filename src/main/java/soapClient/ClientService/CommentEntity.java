
package soapClient.ClientService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for commentEntity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="commentEntity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="commentId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="star" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "commentEntity", propOrder = {
    "comment",
    "commentId",
    "star"
})
public class CommentEntity {

    protected String comment;
    protected int commentId;
    protected int star;

    /**
     * Gets the value of the comment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComment(String value) {
        this.comment = value;
    }

    /**
     * Gets the value of the commentId property.
     * 
     */
    public int getCommentId() {
        return commentId;
    }

    /**
     * Sets the value of the commentId property.
     * 
     */
    public void setCommentId(int value) {
        this.commentId = value;
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

}
