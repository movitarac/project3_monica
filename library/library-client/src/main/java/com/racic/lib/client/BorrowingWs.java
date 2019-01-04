
package com.racic.lib.client;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10
 * Generated source version: 2.2
 * 
 */
@WebService(name = "borrowingWs", targetNamespace = "http://webservice.lib.racic.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface BorrowingWs {


    /**
     * 
     */
    @WebMethod
    @RequestWrapper(localName = "init", targetNamespace = "http://webservice.lib.racic.com/", className = "com.racic.lib.client.Init")
    @ResponseWrapper(localName = "initResponse", targetNamespace = "http://webservice.lib.racic.com/", className = "com.racic.lib.client.InitResponse")
    @Action(input = "http://webservice.lib.racic.com/borrowingWs/initRequest", output = "http://webservice.lib.racic.com/borrowingWs/initResponse")
    public void init();

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "returnBorrowing", targetNamespace = "http://webservice.lib.racic.com/", className = "com.racic.lib.client.ReturnBorrowing")
    @ResponseWrapper(localName = "returnBorrowingResponse", targetNamespace = "http://webservice.lib.racic.com/", className = "com.racic.lib.client.ReturnBorrowingResponse")
    @Action(input = "http://webservice.lib.racic.com/borrowingWs/returnBorrowingRequest", output = "http://webservice.lib.racic.com/borrowingWs/returnBorrowingResponse")
    public boolean returnBorrowing(
        @WebParam(name = "arg0", targetNamespace = "")
        Integer arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        Member arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<com.racic.lib.client.Borrowing>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getNotReturnedBorrowing", targetNamespace = "http://webservice.lib.racic.com/", className = "com.racic.lib.client.GetNotReturnedBorrowing")
    @ResponseWrapper(localName = "getNotReturnedBorrowingResponse", targetNamespace = "http://webservice.lib.racic.com/", className = "com.racic.lib.client.GetNotReturnedBorrowingResponse")
    @Action(input = "http://webservice.lib.racic.com/borrowingWs/getNotReturnedBorrowingRequest", output = "http://webservice.lib.racic.com/borrowingWs/getNotReturnedBorrowingResponse")
    public List<Borrowing> getNotReturnedBorrowing(
        @WebParam(name = "arg0", targetNamespace = "")
        XMLGregorianCalendar arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "extendBorrowing", targetNamespace = "http://webservice.lib.racic.com/", className = "com.racic.lib.client.ExtendBorrowing")
    @ResponseWrapper(localName = "extendBorrowingResponse", targetNamespace = "http://webservice.lib.racic.com/", className = "com.racic.lib.client.ExtendBorrowingResponse")
    @Action(input = "http://webservice.lib.racic.com/borrowingWs/extendBorrowingRequest", output = "http://webservice.lib.racic.com/borrowingWs/extendBorrowingResponse")
    public boolean extendBorrowing(
        @WebParam(name = "arg0", targetNamespace = "")
        Integer arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        Member arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "verifyBoksListAvailableSize", targetNamespace = "http://webservice.lib.racic.com/", className = "com.racic.lib.client.VerifyBoksListAvailableSize")
    @ResponseWrapper(localName = "verifyBoksListAvailableSizeResponse", targetNamespace = "http://webservice.lib.racic.com/", className = "com.racic.lib.client.VerifyBoksListAvailableSizeResponse")
    @Action(input = "http://webservice.lib.racic.com/borrowingWs/verifyBoksListAvailableSizeRequest", output = "http://webservice.lib.racic.com/borrowingWs/verifyBoksListAvailableSizeResponse")
    public boolean verifyBoksListAvailableSize(
        @WebParam(name = "arg0", targetNamespace = "")
        Integer arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "borrowBook", targetNamespace = "http://webservice.lib.racic.com/", className = "com.racic.lib.client.BorrowBook")
    @ResponseWrapper(localName = "borrowBookResponse", targetNamespace = "http://webservice.lib.racic.com/", className = "com.racic.lib.client.BorrowBookResponse")
    @Action(input = "http://webservice.lib.racic.com/borrowingWs/borrowBookRequest", output = "http://webservice.lib.racic.com/borrowingWs/borrowBookResponse")
    public boolean borrowBook(
        @WebParam(name = "arg0", targetNamespace = "")
        Integer arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        Member arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<Borrowing>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findByMember", targetNamespace = "http://webservice.lib.racic.com/", className = "com.racic.lib.client.FindByMember")
    @ResponseWrapper(localName = "findByMemberResponse", targetNamespace = "http://webservice.lib.racic.com/", className = "com.racic.lib.client.FindByMemberResponse")
    @Action(input = "http://webservice.lib.racic.com/borrowingWs/findByMemberRequest", output = "http://webservice.lib.racic.com/borrowingWs/findByMemberResponse")
    public List<Borrowing> findByMember(
        @WebParam(name = "arg0", targetNamespace = "")
        Member arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns Borrowing
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findByBorrowingId", targetNamespace = "http://webservice.lib.racic.com/", className = "com.racic.lib.client.FindByBorrowingId")
    @ResponseWrapper(localName = "findByBorrowingIdResponse", targetNamespace = "http://webservice.lib.racic.com/", className = "com.racic.lib.client.FindByBorrowingIdResponse")
    @Action(input = "http://webservice.lib.racic.com/borrowingWs/findByBorrowingIdRequest", output = "http://webservice.lib.racic.com/borrowingWs/findByBorrowingIdResponse")
    public Borrowing findByBorrowingId(
        @WebParam(name = "arg0", targetNamespace = "")
        Integer arg0);

    /**
     * 
     */
    @WebMethod
    @RequestWrapper(localName = "launchSendEmail", targetNamespace = "http://webservice.lib.racic.com/", className = "com.racic.lib.client.LaunchSendEmail")
    @ResponseWrapper(localName = "launchSendEmailResponse", targetNamespace = "http://webservice.lib.racic.com/", className = "com.racic.lib.client.LaunchSendEmailResponse")
    @Action(input = "http://webservice.lib.racic.com/borrowingWs/launchSendEmailRequest", output = "http://webservice.lib.racic.com/borrowingWs/launchSendEmailResponse")
    public boolean launchSendEmail();

}