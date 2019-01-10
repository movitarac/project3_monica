
package com.racic.lib.webservice.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "findByMember", namespace = "http://webservice.lib.racic.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findByMember", namespace = "http://webservice.lib.racic.com/")
public class FindByMember {

    @XmlElement(name = "arg0", namespace = "")
    private com.racic.lib.model.Member arg0;

    /**
     * 
     * @return
     *     returns Member
     */
    public com.racic.lib.model.Member getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(com.racic.lib.model.Member arg0) {
        this.arg0 = arg0;
    }

}
