package com.epam.rd.izh.soap.com.dataaccess.webservicesserver;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InvertCaseFirstAdjustStringToCurrentResult" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "invertCaseFirstAdjustStringToCurrentResult"
})
@XmlRootElement(name = "InvertCaseFirstAdjustStringToCurrentResponse")
public class InvertCaseFirstAdjustStringToCurrentResponse {

    @XmlElement(name = "InvertCaseFirstAdjustStringToCurrentResult", required = true)
    protected String invertCaseFirstAdjustStringToCurrentResult;

    /**
     * Gets the value of the invertCaseFirstAdjustStringToCurrentResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvertCaseFirstAdjustStringToCurrentResult() {
        return invertCaseFirstAdjustStringToCurrentResult;
    }

    /**
     * Sets the value of the invertCaseFirstAdjustStringToCurrentResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvertCaseFirstAdjustStringToCurrentResult(String value) {
        this.invertCaseFirstAdjustStringToCurrentResult = value;
    }

}
