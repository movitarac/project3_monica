package com.racic.lib.webapp.controller;

import com.racic.lib.business.service.contract.MemberService;
import com.racic.lib.model.Borrowing;
import com.racic.lib.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;


	// login test without spring security//
	@RequestMapping(value = "/library/login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("message","Please enter your login details");
		return "member/login";
	}

	@RequestMapping(value="/library/login", method=RequestMethod.POST)
	public ModelAndView Login(HttpServletRequest request, @ModelAttribute("member")
							  Member member){


		boolean result;
		ModelAndView modelAndView = null;
		String username=member.getUsername();
		String password=member.getPassword();

		String firstname = memberService.findByUsername(username).getFirstName();
		String lastname = memberService.findByUsername(username).getLastName();
		String email = memberService.findByUsername(username).getEmail();
		String address = memberService.findByUsername(username).getAddress();

		if(member !=null && username !=null & password !=null) {

			result = memberService.isValidUser(username,password);
			if (result == true) {
				modelAndView = new ModelAndView("member/profile");
				Boolean connected =true;

				List<String> details = new ArrayList<>();
				details.add(firstname);
				details.add(lastname);
				details.add(username);
				details.add(email);
				details.add(address);
				modelAndView.addObject("details",details);

				HttpSession session = request.getSession();


				session.setAttribute("member",member);
				session.setAttribute("connected", true);


			} else {
				modelAndView = new ModelAndView("member/login");
				modelAndView.addObject("msg","Wrong username and or password");
			}
		} else {
			modelAndView = new ModelAndView("member/login");
			modelAndView.addObject("msg","Error occured while processing");
		}

		return modelAndView;
	}


	///LOGIN TEST///
	@RequestMapping(value = "/library/connection", method = RequestMethod.GET)
	public String initial(Model model) {
		model.addAttribute("message","Please enter your login details");
		return "member/logins";
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
