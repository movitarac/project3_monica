
package com.racic.lib.webservice.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "findWorksByAuthorContainResponse", namespace = "http://webservice.lib.racic.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findWorksByAuthorContainResponse", namespace = "http://webservice.lib.racic.com/")
public class FindWorksByAuthorContainResponse {

    @XmlElement(name = "return", namespace = "")
    private List<com.racic.lib.model.Work> _return;

    /**
     * 
     * @return
     *     returns List<Work>
     */
    public List<com.racic.lib.model.Work> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<com.racic.lib.model.Work> _return) {
        this._return = _return;
    }

}
