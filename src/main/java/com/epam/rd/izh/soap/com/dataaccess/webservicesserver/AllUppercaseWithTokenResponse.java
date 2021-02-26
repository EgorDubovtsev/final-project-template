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
 *         &lt;element name="AllUppercaseWithTokenResult" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "allUppercaseWithTokenResult"
})
@XmlRootElement(name = "AllUppercaseWithTokenResponse")
public class AllUppercaseWithTokenResponse {

    @XmlElement(name = "AllUppercaseWithTokenResult", required = true)
    protected String allUppercaseWithTokenResult;

    /**
     * Gets the value of the allUppercaseWithTokenResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAllUppercaseWithTokenResult() {
        return allUppercaseWithTokenResult;
    }

    /**
     * Sets the value of the allUppercaseWithTokenResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAllUppercaseWithTokenResult(String value) {
        this.allUppercaseWithTokenResult = value;
    }

}
