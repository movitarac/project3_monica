package com.racic.lib.endpoint;

import com.racic.lib.business.service.contract.MemberService;

import com.racic.lib.gs_ws.*;
import com.racic.lib.model.Member;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;


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

    @PayloadRoot(namespace= NAMESPACE_URL, localPart = "findMemberbyEmailRequest")
    public FindMemberbyEmailResponse findMemberByEmail (@RequestPayload FindMemberbyEmailRequest request) {
        FindMemberbyEmailResponse response = new FindMemberbyEmailResponse();
        MemberInfo memberInfo = new MemberInfo();
        Member member = memberService.findMemberByEmail(request.getEmail());
        BeanUtils.copyProperties(member,memberInfo);
        response.getMember();
        return response;
    }

    @PayloadRoot(namespace= NAMESPACE_URL, localPart = "findMemberbyUsernameAndPassRequest")
    public FindMemberbyUsernameAndPassResponse findByUsernameAndPassword(@RequestPayload FindMemberbyUsernameAndPassRequest request){

        FindMemberbyUsernameAndPassResponse response = new FindMemberbyUsernameAndPassResponse();
        MemberInfo memberInfo = new MemberInfo();
        Member member = memberService.findByUsernameAndPassword(request.getUsername(),request.getPassword());
        BeanUtils.copyProperties(member,memberInfo);
        response.getMember();
        return response;
    }

    @PayloadRoot(namespace= NAMESPACE_URL, localPart = "isValidUserRequest")
    public IsValidUserResponse isValidUser(@RequestPayload IsValidUserRequest request) {
        IsValidUserResponse response = new IsValidUserResponse();
        ServiceStatus serviceStatus = new ServiceStatus();
       boolean flag =memberService.isValidUser(request.getUsername(),request.getPassword());
        if (flag == false) {
            serviceStatus.setStatusCode("Conflict");
            serviceStatus.setMessage("not a valid user");
            response.setServiceStatus(serviceStatus);
            response.setStatus(false);
        } else {
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("User is valid");
            response.setStatus(true);
        }
        return  response;
    }

}
