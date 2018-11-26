package com.racic.lib.webapp.controller;

import com.racic.lib.business.service.contract.MemberService;
import com.racic.lib.model.Borrowing;
import com.racic.lib.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;

	@RequestMapping(value = "/member")
	public String home() {
		System.out.println("Member controller passing through to header.jsp outside the web inf");
		// return "/_include/header";
		return "home";
	}

	@RequestMapping(value = "/member/{id}", method = RequestMethod.GET)
	public String sayHello(@PathVariable int id, Model model) {

		System.out.println("member found");
		String firstname = memberService.findMemberById(id).getFirstName();
		String lastname = memberService.findMemberById(id).getLastName();
		String email = memberService.findMemberById(id).getEmail();
		String address = memberService.findMemberById(id).getAddress();
		model.addAttribute("lastname", lastname);
		model.addAttribute("firstname", firstname);
		model.addAttribute("email", email);
		model.addAttribute("address", address);
		return "profile";
	}

	// TEST with model (to pass values from controller to view)
	@RequestMapping(value = "members/{id}", method = RequestMethod.GET)
	public String members(@PathVariable("id") int id, Model model) {
		System.out.println("try to go home jsp");
		Member member = this.memberService.findMemberById(id);
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
