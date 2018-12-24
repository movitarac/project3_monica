
package com.racic.lib.webservice.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "updateBook", namespace = "http://webservice.lib.racic.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateBook", namespace = "http://webservice.lib.racic.com/")
public class UpdateBook {

    @XmlElement(name = "arg0", namespace = "")
    private com.racic.lib.model.Book arg0;

    /**
     * 
     * @return
     *     returns Book
     */
    public com.racic.lib.model.Book getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(com.racic.lib.model.Book arg0) {
        this.arg0 = arg0;
    }

}
