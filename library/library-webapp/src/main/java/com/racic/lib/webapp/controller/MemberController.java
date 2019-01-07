package com.racic.lib.webapp.controller;


import com.racic.lib.client.*;

import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;


@Controller
public class MemberController {


	/**
	 * /login will be shown when the login button is clicked
	 * @return login page
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "member/login";
	}

	/**
	 * this method will be called when submit button from login page is clicked
	 * @param request
	 * @param member
	 * @return
	 */
	@RequestMapping(value="/profile", method=RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, com.racic.lib.client.Member member){


		boolean result;
		ModelAndView modelAndView = null;
		String username=member.getUsername();
		String password=member.getPassword();


		if(member !=null && username !=null & password !=null) {

			//call the webservice client
			MemberWeb memberWeb = new MemberWeb();
			MemberWs memberWs = memberWeb.getMemberWsPort();

			//call the webmethod
			result = memberWs.isValidUser(username,password);

			if (result == true) {
				modelAndView = new ModelAndView("member/profile");
				com.racic.lib.client.Member memberConnected = memberWs.findByUsernameAndPassword(username,password);
				request.getSession().setAttribute("connected", true);
				request.getSession().setAttribute("memberConnected",memberConnected);
				com.racic.lib.client.Member loggedInMember = (com.racic.lib.client.Member) request.getSession().getAttribute("memberConnected");
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
			com.racic.lib.client.Member memberConnected = (com.racic.lib.client.Member)request.getSession().getAttribute("memberConnected");
			mv.addObject("memberConnected",memberConnected);
		} else {
			mv = new ModelAndView("library/error");
		}

		return mv;
	}

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) {
		com.racic.lib.client.Member m1 =(com.racic.lib.client.Member)request.getSession().getAttribute("memberConnected");
		System.out.println("before logged out " + m1.getFirstName());
		ModelAndView modelAndView = new ModelAndView("member/login");
		modelAndView.addObject("msg","You are successfully logged out!");
		request.getSession().invalidate();
		return modelAndView;
	}


	////////////////////////TEST/////////////////////////////
/*
	@RequestMapping(value="/addusermember/{booksids}",method = RequestMethod.GET)
	public @ResponseBody String getBorrowingsByMember(@PathVariable String booksids) {
		String[] idsbooks = booksids.split("-");
		List<String> listDetails = new ArrayList<>();
		Collections.addAll(listDetails,idsbooks);
		return "add borrowing list";
	}
*/

}
