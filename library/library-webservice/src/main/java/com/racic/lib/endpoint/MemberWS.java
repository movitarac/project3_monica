package com.racic.lib.endpoint;

import com.racic.lib.business.service.contract.MemberService;
import com.racic.lib.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@WebService
@Service
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use= SOAPBinding.Use.LITERAL)
public class MemberWS {

    @Autowired
    MemberService memberService;


    @WebMethod(operationName = "findAllMember")
    public List<Member> findAll() {
        return memberService.findAll();
    }

    @WebMethod(operationName = "findMemberByEmail")
    public Member findMemberByEmail (String email) {

        return memberService.findMemberByEmail(email);
    }

    @WebMethod(operationName = "findByUsernameAndPassword")
    public Member findByUsernameAndPassword(String username, String password){

        return memberService.findByUsernameAndPassword(username,password);
    }

    @WebMethod(operationName = "isValidUser")
    public boolean isValidUser(String userName, String passWord) {
    return memberService.isValidUser(userName, passWord);

    }
}
