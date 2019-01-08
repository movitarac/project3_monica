
package com.racic.lib.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.racic.lib.webservice package. 
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

    private final static QName _Init_QNAME = new QName("http://webservice.lib.racic.com/", "init");
    private final static QName _FindByUsernameAndPasswordResponse_QNAME = new QName("http://webservice.lib.racic.com/", "findByUsernameAndPasswordResponse");
    private final static QName _InitResponse_QNAME = new QName("http://webservice.lib.racic.com/", "initResponse");
    private final static QName _FindMemberByEmail_QNAME = new QName("http://webservice.lib.racic.com/", "findMemberByEmail");
    private final static QName _FindMemberByEmailResponse_QNAME = new QName("http://webservice.lib.racic.com/", "findMemberByEmailResponse");
    private final static QName _IsValidUserResponse_QNAME = new QName("http://webservice.lib.racic.com/", "isValidUserResponse");
    private final static QName _FindAllResponse_QNAME = new QName("http://webservice.lib.racic.com/", "findAllResponse");
    private final static QName _IsValidUser_QNAME = new QName("http://webservice.lib.racic.com/", "isValidUser");
    private final static QName _FindAll_QNAME = new QName("http://webservice.lib.racic.com/", "findAll");
    private final static QName _FindByUsernameAndPassword_QNAME = new QName("http://webservice.lib.racic.com/", "findByUsernameAndPassword");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.racic.lib.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Init }
     * 
     */
    public Init createInit() {
        return new Init();
    }

    /**
     * Create an instance of {@link FindByUsernameAndPasswordResponse }
     * 
     */
    public FindByUsernameAndPasswordResponse createFindByUsernameAndPasswordResponse() {
        return new FindByUsernameAndPasswordResponse();
    }

    /**
     * Create an instance of {@link InitResponse }
     * 
     */
    public InitResponse createInitResponse() {
        return new InitResponse();
    }

    /**
     * Create an instance of {@link FindMemberByEmail }
     * 
     */
    public FindMemberByEmail createFindMemberByEmail() {
        return new FindMemberByEmail();
    }

    /**
     * Create an instance of {@link FindMemberByEmailResponse }
     * 
     */
    public FindMemberByEmailResponse createFindMemberByEmailResponse() {
        return new FindMemberByEmailResponse();
    }

    /**
     * Create an instance of {@link IsValidUserResponse }
     * 
     */
    public IsValidUserResponse createIsValidUserResponse() {
        return new IsValidUserResponse();
    }

    /**
     * Create an instance of {@link FindAllResponse }
     * 
     */
    public FindAllResponse createFindAllResponse() {
        return new FindAllResponse();
    }

    /**
     * Create an instance of {@link IsValidUser }
     * 
     */
    public IsValidUser createIsValidUser() {
        return new IsValidUser();
    }

    /**
     * Create an instance of {@link FindAll }
     * 
     */
    public FindAll createFindAll() {
        return new FindAll();
    }

    /**
     * Create an instance of {@link FindByUsernameAndPassword }
     * 
     */
    public FindByUsernameAndPassword createFindByUsernameAndPassword() {
        return new FindByUsernameAndPassword();
    }

    /**
     * Create an instance of {@link Work }
     * 
     */
    public Work createWork() {
        return new Work();
    }

    /**
     * Create an instance of {@link Book }
     * 
     */
    public Book createBook() {
        return new Book();
    }

    /**
     * Create an instance of {@link Library }
     * 
     */
    public Library createLibrary() {
        return new Library();
    }

    /**
     * Create an instance of {@link Member }
     * 
     */
    public Member createMember() {
        return new Member();
    }

    /**
     * Create an instance of {@link Borrowing }
     * 
     */
    public Borrowing createBorrowing() {
        return new Borrowing();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Init }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.lib.racic.com/", name = "init")
    public JAXBElement<Init> createInit(Init value) {
        return new JAXBElement<Init>(_Init_QNAME, Init.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByUsernameAndPasswordResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.lib.racic.com/", name = "findByUsernameAndPasswordResponse")
    public JAXBElement<FindByUsernameAndPasswordResponse> createFindByUsernameAndPasswordResponse(FindByUsernameAndPasswordResponse value) {
        return new JAXBElement<FindByUsernameAndPasswordResponse>(_FindByUsernameAndPasswordResponse_QNAME, FindByUsernameAndPasswordResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InitResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.lib.racic.com/", name = "initResponse")
    public JAXBElement<InitResponse> createInitResponse(InitResponse value) {
        return new JAXBElement<InitResponse>(_InitResponse_QNAME, InitResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindMemberByEmail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.lib.racic.com/", name = "findMemberByEmail")
    public JAXBElement<FindMemberByEmail> createFindMemberByEmail(FindMemberByEmail value) {
        return new JAXBElement<FindMemberByEmail>(_FindMemberByEmail_QNAME, FindMemberByEmail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindMemberByEmailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.lib.racic.com/", name = "findMemberByEmailResponse")
    public JAXBElement<FindMemberByEmailResponse> createFindMemberByEmailResponse(FindMemberByEmailResponse value) {
        return new JAXBElement<FindMemberByEmailResponse>(_FindMemberByEmailResponse_QNAME, FindMemberByEmailResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsValidUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.lib.racic.com/", name = "isValidUserResponse")
    public JAXBElement<IsValidUserResponse> createIsValidUserResponse(IsValidUserResponse value) {
        return new JAXBElement<IsValidUserResponse>(_IsValidUserResponse_QNAME, IsValidUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.lib.racic.com/", name = "findAllResponse")
    public JAXBElement<FindAllResponse> createFindAllResponse(FindAllResponse value) {
        return new JAXBElement<FindAllResponse>(_FindAllResponse_QNAME, FindAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsValidUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.lib.racic.com/", name = "isValidUser")
    public JAXBElement<IsValidUser> createIsValidUser(IsValidUser value) {
        return new JAXBElement<IsValidUser>(_IsValidUser_QNAME, IsValidUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAll }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.lib.racic.com/", name = "findAll")
    public JAXBElement<FindAll> createFindAll(FindAll value) {
        return new JAXBElement<FindAll>(_FindAll_QNAME, FindAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByUsernameAndPassword }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.lib.racic.com/", name = "findByUsernameAndPassword")
    public JAXBElement<FindByUsernameAndPassword> createFindByUsernameAndPassword(FindByUsernameAndPassword value) {
        return new JAXBElement<FindByUsernameAndPassword>(_FindByUsernameAndPassword_QNAME, FindByUsernameAndPassword.class, null, value);
    }

}
