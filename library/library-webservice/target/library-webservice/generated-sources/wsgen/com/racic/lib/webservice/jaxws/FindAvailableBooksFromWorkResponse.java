
package com.racic.lib.webservice.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "findAvailableBooksFromWorkResponse", namespace = "http://webservice.lib.racic.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findAvailableBooksFromWorkResponse", namespace = "http://webservice.lib.racic.com/")
public class FindAvailableBooksFromWorkResponse {

    @XmlElement(name = "return", namespace = "")
    private List<com.racic.lib.model.Book> _return;

    /**
     * 
     * @return
     *     returns List<Book>
     */
    public List<com.racic.lib.model.Book> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<com.racic.lib.model.Book> _return) {
        this._return = _return;
    }

}
