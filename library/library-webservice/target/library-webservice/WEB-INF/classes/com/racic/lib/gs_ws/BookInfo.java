//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.12.31 at 10:28:19 AM CET 
//


package com.racic.lib.gs_ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for bookInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bookInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="bookId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="isAvailable" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="work" type="{client.lib.racic.com}workInfo"/&gt;
 *         &lt;element name="borrowing" type="{client.lib.racic.com}borrowingInfo"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bookInfo", propOrder = {
    "bookId",
    "isAvailable",
    "work",
    "borrowing"
})
public class BookInfo {

    @XmlElement(required = true)
    protected String bookId;
    protected boolean isAvailable;
    @XmlElement(required = true)
    protected WorkInfo work;
    @XmlElement(required = true)
    protected BorrowingInfo borrowing;

    /**
     * Gets the value of the bookId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookId() {
        return bookId;
    }

    /**
     * Sets the value of the bookId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookId(String value) {
        this.bookId = value;
    }

    /**
     * Gets the value of the isAvailable property.
     * 
     */
    public boolean isIsAvailable() {
        return isAvailable;
    }

    /**
     * Sets the value of the isAvailable property.
     * 
     */
    public void setIsAvailable(boolean value) {
        this.isAvailable = value;
    }

    /**
     * Gets the value of the work property.
     * 
     * @return
     *     possible object is
     *     {@link WorkInfo }
     *     
     */
    public WorkInfo getWork() {
        return work;
    }

    /**
     * Sets the value of the work property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkInfo }
     *     
     */
    public void setWork(WorkInfo value) {
        this.work = value;
    }

    /**
     * Gets the value of the borrowing property.
     * 
     * @return
     *     possible object is
     *     {@link BorrowingInfo }
     *     
     */
    public BorrowingInfo getBorrowing() {
        return borrowing;
    }

    /**
     * Sets the value of the borrowing property.
     * 
     * @param value
     *     allowed object is
     *     {@link BorrowingInfo }
     *     
     */
    public void setBorrowing(BorrowingInfo value) {
        this.borrowing = value;
    }

}
