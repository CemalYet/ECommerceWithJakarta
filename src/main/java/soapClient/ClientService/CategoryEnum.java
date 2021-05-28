
package soapClient.ClientService;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for categoryEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="categoryEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Accessories"/>
 *     &lt;enumeration value="Fitness"/>
 *     &lt;enumeration value="Clothing"/>
 *     &lt;enumeration value="Electronics"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "categoryEnum")
@XmlEnum
public enum CategoryEnum {

    @XmlEnumValue("Accessories")
    ACCESSORIES("Accessories"),
    @XmlEnumValue("Fitness")
    FITNESS("Fitness"),
    @XmlEnumValue("Clothing")
    CLOTHING("Clothing"),
    @XmlEnumValue("Electronics")
    ELECTRONICS("Electronics");
    private final String value;

    CategoryEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CategoryEnum fromValue(String v) {
        for (CategoryEnum c: CategoryEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
