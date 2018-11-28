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


	///LOGIN///
	@RequestMapping(value = "/library/connection", method = RequestMethod.GET)
	public String initial(Model model) {
		model.addAttribute("message","Please enter your login details");
		return "member/logins";
	}

	@RequestMapping (method = RequestMethod.POST)
	public String submitlogin(Model model, @ModelAttribute("member") Member member) {
		if(member != null && member.getUsername() !=null & member.getPassword() !=null) {
			if (member.getUsername().equals("georgelulu")
					&& member.getPassword().equals("1234lulu")) {

				String firstname =member.getFirstName();
				String lastname = member.getLastName();
				String email = member.getEmail();
				String username = member.getUsername();
				String address = member.getAddress();
				model.addAttribute("lastname", lastname);
				model.addAttribute("firstname", firstname);
				model.addAttribute("username",username);
				model.addAttribute("email", email);
				model.addAttribute("address", address);
				return "member/profile";
			} else {
				model.addAttribute("error","Invalid details");
				return "member/logins";
			}
		} else {
			model.addAttribute("error","Please enter details");
			return "member/logins";
		}

	}

	@RequestMapping(value = "/library/member")
	public String home() {
		System.out.println("Member controller passing through to header.jsp outside the web inf");
		// return "/_include/header";
		return "home";
	}

	@RequestMapping(value = "/library/member/{id}", method = RequestMethod.GET)
	public String sayHello(@PathVariable int id, Model model) {

		System.out.println("member found");
		String firstname = memberService.findMemberById(id).getFirstName();
		String lastname = memberService.findMemberById(id).getLastName();
		String email = memberService.findMemberById(id).getEmail();
		String username = memberService.findMemberById(id).getUsername();
		String address = memberService.findMemberById(id).getAddress();
		model.addAttribute("lastname", lastname);
		model.addAttribute("firstname", firstname);
		model.addAttribute("username",username);
		model.addAttribute("email", email);
		model.addAttribute("address", address);
		return "member/profile";
	}

	// TEST with model (to pass values from controller to view)
	@RequestMapping(value = "/library/members/{id}", method = RequestMethod.GET)
	public String members(@PathVariable("id") int id, Model model) {
		System.out.println("try to go home jsp");
		Member member = this.memberService.findMemberById(id);
		String firstname = member.getFirstName();
		String lastname = member.getLastName();
		model.addAttribute("lastname", lastname);
		model.addAttribute("firstname", firstname);
		System.out.println("with model add atribute");
		return "library/home";
	}

	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
}
