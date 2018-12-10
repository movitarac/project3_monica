package com.racic.lib.webapp.controller;

import com.racic.lib.business.service.contract.LibraryService;
import com.racic.lib.business.service.contract.WorkService;
import com.racic.lib.model.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class LibraryController {

	@Autowired
	LibraryService libraryService;

	@Autowired
	WorkService workService;


	@RequestMapping(value="/library")
	public String home() {
		return "library/home";
	}

	@RequestMapping(value="/library/registration")
	public String registration() {

		return "member/registration";
	}

	@RequestMapping(value="/library/information")
	public String information() {

		return "library/information";
	}

	@RequestMapping(value="/library/condition")
	public String condition () {
		return "library/condition";
	}

	@RequestMapping(value="/library/browse", method = RequestMethod.GET)
	public String works(HttpServletRequest request, Model model) {
		List<Work> worksList = workService.getAll();
		model.addAttribute("worksList", worksList);
		return "borrowing/browse";
	}

	/*
	@RequestMapping(value="/library/condition")
	public String condition (HttpServletRequest request) {
		if(request != null && request.getSession().getAttribute("memberConnected") != null) {
			Member m1 =(Member)request.getSession().getAttribute("memberConnected");
			System.out.println("we can see the logged in member " + m1.getFirstName());
		} else {
			return "member/login";
		}
   	return "library/condition";
	}
	*/
}