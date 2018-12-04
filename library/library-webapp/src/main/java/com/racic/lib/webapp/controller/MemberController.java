package com.racic.lib.webapp.controller;

import com.racic.lib.business.service.contract.MemberService;
import com.racic.lib.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;

import java.util.List;


@Controller
public class MemberController {

	@Autowired
	MemberService memberService;

	@Autowired
	ApplicationContext applicationContext;

	// login test without spring security//

	@RequestMapping(value = "/library/login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("message","Please enter your login details");
		return "member/login";
	}
	@RequestMapping(value="/library/login", method=RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, Member member){


		boolean result;
		ModelAndView modelAndView = null;
		String username=member.getUsername();
		String password=member.getPassword();


		if(member !=null && username !=null & password !=null) {

			result = memberService.isValidUser(username,password);

			if (result == true) {
				modelAndView = new ModelAndView("member/profile");
				//Boolean connected =true;

				Member memberConnected = memberService.findByUsernameAndPassword(username,password);
				String firstname = memberConnected.getFirstName();
				String lastname = memberConnected.getLastName();
				String email = memberConnected.getEmail();
				String address = memberConnected.getAddress();

				List<String> details = new ArrayList<>();
				details.add(firstname);
				details.add(lastname);
				details.add(username);
				details.add(email);
				details.add(address);
				modelAndView.addObject("details",details);

				request.getSession().setAttribute("connected", true);
				request.getSession().setAttribute("memberConnected",memberConnected);

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




	@RequestMapping(value="/library/logout")
	public String logout(HttpServletRequest request) {
	request.getSession().setAttribute("connected",false);
		return "member/login";
	}



	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

}
