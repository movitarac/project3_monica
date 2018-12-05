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



	@RequestMapping(value = "/library/login", method = RequestMethod.GET)
	public String login() {
		return "member/login";
	}

	/**
	 * this controller will be called when submit button from login page is clicked
	 * @param request
	 * @param member
	 * @return
	 */
	@RequestMapping(value="/library/profile", method=RequestMethod.POST)
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
				Member m1 = (Member)request.getSession().getAttribute("memberConnected");
				modelAndView.addObject("memberConnected",memberConnected);
				System.out.println(m1.getFirstName());
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

	@RequestMapping(value="/library/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) {
		Member m1 =(Member)request.getSession().getAttribute("memberConnected");
		System.out.println("before logged out " + m1.getFirstName());
		ModelAndView modelAndView = new ModelAndView("member/login");
		modelAndView.addObject("msg","You are successfully logged out!");
		request.getSession().invalidate();

		return modelAndView;
	}


	@RequestMapping(value = "/library/register/", method = RequestMethod.POST)
	public ModelAndView register(HttpServletRequest request,
								 @ModelAttribute("member") Member member, User user){

		ModelAndView modelAndView = null;
		memberService.addUserMember(user,member);
		modelAndView = new ModelAndView("member/welcome");

		System.out.println("new memmber" + member.getFirstName());
		return modelAndView;
	}


	////////////////////////TEST/////////////////////////////

	@RequestMapping(value="/library/addusermember/{details}",method = RequestMethod.GET)
	public @ResponseBody String getBorrowingsByMember(@PathVariable String details, User user) {
		String[] arraybookid = details.split("-");
		List<String> listDetails = new ArrayList<>();
		Collections.addAll(listDetails,arraybookid);

		memberService.addUser(user);
		return "add borrowing list";
	}

	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

}
