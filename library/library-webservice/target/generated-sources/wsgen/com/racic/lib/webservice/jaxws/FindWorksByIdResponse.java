
package com.racic.lib.webservice.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "findWorksByIdResponse", namespace = "http://webservice.lib.racic.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findWorksByIdResponse", namespace = "http://webservice.lib.racic.com/")
public class FindWorksByIdResponse {

    @XmlElement(name = "return", namespace = "")
    private com.racic.lib.model.Work _return;

    /**
     * 
     * @return
     *     returns Work
     */
    public com.racic.lib.model.Work getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(com.racic.lib.model.Work _return) {
        this._return = _return;
    }

}
