package com.racic.lib.webapp.controller;

import com.racic.lib.business.service.contract.MemberService;
import com.racic.lib.model.Member;
import com.racic.lib.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;


@Controller
public class MemberController {

	@Autowired
	MemberService memberService;



	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "member/login";
	}

	/**
	 * this controller will be called when submit button from login page is clicked
	 * @param request
	 * @param member
	 * @return
	 */
	@RequestMapping(value="/profile", method=RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, Member member){


		boolean result;
		ModelAndView modelAndView = null;
		String username=member.getUsername();
		String password=member.getPassword();


		if(member !=null && username !=null & password !=null) {

			result = memberService.isValidUser(username,password);

			if (result == true) {
				modelAndView = new ModelAndView("member/profile");
				Member memberConnected = memberService.findByUsernameAndPassword(username,password);
				request.getSession().setAttribute("connected", true);
				request.getSession().setAttribute("memberConnected",memberConnected);
				Member loggedInMember = (Member)request.getSession().getAttribute("memberConnected");
				modelAndView.addObject("memberConnected",memberConnected);

				System.out.println(loggedInMember.getFirstName());
			} else {
				modelAndView = new ModelAndView("member/login");
				modelAndView.addObject("msg","Wrong username and or password");
			}
		} else {
			modelAndView = new ModelAndView("library/error");
		}
		return modelAndView;
	}

	@RequestMapping(value="/profile")
	public ModelAndView getprofile(HttpServletRequest request) {
		ModelAndView mv = null;
		if (request!=null && request.getSession().getAttribute("connected") != null) {
			mv = new ModelAndView("member/profile");
			Member memberConnected = (Member)request.getSession().getAttribute("memberConnected");
			mv.addObject("memberConnected",memberConnected);
		} else {
			mv = new ModelAndView("library/error");
		}

		return mv;
	}

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) {
		Member m1 =(Member)request.getSession().getAttribute("memberConnected");
		System.out.println("before logged out " + m1.getFirstName());
		ModelAndView modelAndView = new ModelAndView("member/login");
		modelAndView.addObject("msg","You are successfully logged out!");
		request.getSession().invalidate();
		return modelAndView;
	}
/*

	@RequestMapping(value = "/register/", method = RequestMethod.POST)
	public ModelAndView register(HttpServletRequest request,
								 @ModelAttribute("member") Member member, User user){

		ModelAndView modelAndView = null;
		memberService.addUser(user.getUsername(),user.getPassword());
		memberService.addMember(member.getFirstName(),member.getLastName(),
				member.getEmail(),member.getAddress());

		modelAndView = new ModelAndView("member/welcome");

		System.out.println("new memmber" + member.getFirstName());
		return modelAndView;
	}
*/


	////////////////////////TEST/////////////////////////////

	@RequestMapping(value="/addusermember/{booksids}",method = RequestMethod.GET)
	public @ResponseBody String getBorrowingsByMember(@PathVariable String booksids) {
		String[] idsbooks = booksids.split("-");
		List<String> listDetails = new ArrayList<>();
		Collections.addAll(listDetails,idsbooks);
		return "add borrowing list";
	}

	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

}
