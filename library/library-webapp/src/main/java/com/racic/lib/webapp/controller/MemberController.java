package com.racic.lib.webapp.controller;

import com.racic.lib.business.service.contract.MemberService;
import com.racic.lib.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.util.Date;


@Controller
public class MemberController {


    @Autowired
    MemberService memberService;

    @RequestMapping(value="/")
    public String home() {
    	System.out.println("Member controller passing through to index.jsp");
    	return "index";
    }

    @RequestMapping(value="/member/{id}",method= RequestMethod.GET)
    public @ResponseBody Member sayHello(@PathVariable int id){

        System.out.println("member found");
        return this.memberService.getMemberById(id);
    }
    //TEST with model (to pass values from controller to view)
    @RequestMapping(value="members/{id}" ,method=RequestMethod.GET)
    public String members(@PathVariable("id") int id, Model model) {
    	System.out.println("try to go home jsp");
    	Member member = this.memberService.getMemberById(id);
    	String firstname = member.getFirstName();
    	String lastname = member.getLastName();
    	model.addAttribute("lastname", lastname);
    	model.addAttribute("firstname", firstname);
    	System.out.println("with model add atribute");
    	return "home";
    }

    public MemberService getMemberService() {
        return memberService;
    }

    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }
}
