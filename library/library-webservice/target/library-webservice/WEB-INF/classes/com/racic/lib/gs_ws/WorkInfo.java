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
 * <p>Java class for workInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="workInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="worksId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="author" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="publicationYear" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="bookDescription" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="copiesAvailable" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="imageUrl" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="library" type="{client.lib.racic.com}libraryInfo"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "workInfo", propOrder = {
    "worksId",
    "title",
    "author",
    "publicationYear",
    "bookDescription",
    "copiesAvailable",
    "imageUrl",
    "library"
})
public class WorkInfo {

    protected int worksId;
    @XmlElement(required = true)
    protected String title;
    @XmlElement(required = true)
    protected String author;
    protected int publicationYear;
    @XmlElement(required = true)
    protected String bookDescription;
    protected int copiesAvailable;
    @XmlElement(required = true)
    protected String imageUrl;
    @XmlElement(required = true)
    protected LibraryInfo library;

    /**
     * Gets the value of the worksId property.
     * 
     */
    public int getWorksId() {
        return worksId;
    }

    /**
     * Sets the value of the worksId property.
     * 
     */
    public void setWorksId(int value) {
        this.worksId = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the author property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the value of the author property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthor(String value) {
        this.author = value;
    }

    /**
     * Gets the value of the publicationYear property.
     * 
     */
    public int getPublicationYear() {
        return publicationYear;
    }

    /**
     * Sets the value of the publicationYear property.
     * 
     */
    public void setPublicationYear(int value) {
        this.publicationYear = value;
    }

    /**
     * Gets the value of the bookDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookDescription() {
        return bookDescription;
    }

    /**
     * Sets the value of the bookDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookDescription(String value) {
        this.bookDescription = value;
    }

    /**
     * Gets the value of the copiesAvailable property.
     * 
     */
    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    /**
     * Sets the value of the copiesAvailable property.
     * 
     */
    public void setCopiesAvailable(int value) {
        this.copiesAvailable = value;
    }

    /**
     * Gets the value of the imageUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * Sets the value of the imageUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageUrl(String value) {
        this.imageUrl = value;
    }

    /**
     * Gets the value of the library property.
     * 
     * @return
     *     possible object is
     *     {@link LibraryInfo }
     *     
     */
    public LibraryInfo getLibrary() {
        return library;
    }

    /**
     * Sets the value of the library property.
     * 
     * @param value
     *     allowed object is
     *     {@link LibraryInfo }
     *     
     */
    public void setLibrary(LibraryInfo value) {
        this.library = value;
    }

}