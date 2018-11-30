package com.racic.lib.webapp.controller;

import com.racic.lib.business.service.contract.LibraryService;
import com.racic.lib.business.service.contract.WorksService;
import com.racic.lib.model.Works;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LibraryController {

   @Autowired
    LibraryService libraryService;

   @Autowired
	WorksService worksService;

	
	 @RequestMapping(value="/library")
	    public String home() {

	    	return "library/home";
	    }
	 @RequestMapping(value="/library/connections")
	    public String login() {

	    	return "member/logins";
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
	public String condition() {
		System.out.println("we are in librarycontroller");
		//libraryService.getWorkList(works)
		return "library/condition";
	}

	@RequestMapping(value="/library/browse", method = RequestMethod.GET)
	public String works(Model model) {
		System.out.println("we are in library browsing works");
		List<Works> worksList = worksService.getAll();
		model.addAttribute("worksList",worksList);

		for (Works work: worksList)
		{
			System.out.println(work.getTitle());
			System.out.println(work.getAuthor());
		}
		return "borrowing/browse";
	}



}
