package com.racic.lib.webservice;

import com.racic.lib.business.service.contract.MemberService;
import com.racic.lib.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.annotation.PostConstruct;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@Service
@WebService(serviceName = "memberWeb",name = "memberWs")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
//@SOAPBinding(style = SOAPBinding.Style.RPC)
public class MemberWs{

    @Autowired
    MemberService memberService;

    @WebMethod
    public List<Member> findAll() {
        return memberService.findAll();
    }

    @WebMethod
    public Member findMemberByEmail (String email) {
        return memberService.findMemberByEmail(email);
    }

    @WebMethod
    public Member findByUsernameAndPassword(String username, String password){
        return memberService.findByUsernameAndPassword(username, password);
    }

    @WebMethod
    public boolean isValidUser(String userName, String passWord) {
        return memberService.isValidUser(userName, passWord);
    }

    @WebMethod
    @PostConstruct
    public void init() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }
}
