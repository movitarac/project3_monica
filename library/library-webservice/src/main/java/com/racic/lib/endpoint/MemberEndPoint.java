package com.racic.lib.endpoint;

import com.racic.lib.business.service.contract.MemberService;

import com.racic.lib.gs_ws.FindAllMemberRequest;
import com.racic.lib.gs_ws.FindAllMemberResponse;
import com.racic.lib.gs_ws.MemberInfo;
import com.racic.lib.model.Member;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

//@EndPoint
public class MemberEndPoint {

    private static final String NAMESPACE_URL = "member.client.lib.racic.com";

    @Autowired
    MemberService memberService;


    @PayloadRoot(namespace= NAMESPACE_URL, localPart = "findAllMemberRequest")
    //@RequestPayload
    public FindAllMemberResponse findAll(@RequestPayload FindAllMemberRequest request) {
        FindAllMemberResponse response = new FindAllMemberResponse();
        List<MemberInfo> memberInfoList = new ArrayList<>();
        List<Member> memberList = memberService.findAll();
        for (int i = 0; i < memberList.size(); i++) {
            MemberInfo memberInfo = new MemberInfo();
            BeanUtils.copyProperties(memberList.get(i),memberInfo);
            memberInfoList.add(memberInfo);
        }
        response.getMember().addAll(memberInfoList);
        return response;
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
