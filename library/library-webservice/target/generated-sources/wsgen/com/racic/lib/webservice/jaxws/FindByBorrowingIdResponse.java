
package com.racic.lib.webservice.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "findByBorrowingIdResponse", namespace = "http://webservice.lib.racic.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findByBorrowingIdResponse", namespace = "http://webservice.lib.racic.com/")
public class FindByBorrowingIdResponse {

    @XmlElement(name = "return", namespace = "")
    private com.racic.lib.model.Borrowing _return;

    /**
     * 
     * @return
     *     returns Borrowing
     */
    public com.racic.lib.model.Borrowing getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(com.racic.lib.model.Borrowing _return) {
        this._return = _return;
    }

}
