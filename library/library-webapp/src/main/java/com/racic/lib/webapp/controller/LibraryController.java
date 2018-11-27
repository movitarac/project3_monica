package com.racic.lib.webapp.controller;

import com.racic.lib.business.service.contract.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LibraryController {

   @Autowired
    LibraryService libraryService;
	
	 @RequestMapping(value="/")
	    public String home() {
	    	System.out.println("we are in librarycontroller");
	    	return "library/home";
	    }
	 @RequestMapping(value="/connection")
	    public String login() {
	    	System.out.println("we are in librarycontroller");
	    	//libraryService.getWorkList(works)
	    	return "member/login";
	    }

	@RequestMapping(value="/registration")
	public String registration() {
		System.out.println("we are in librarycontroller");
		//libraryService.getWorkList(works)
		return "member/registration";
	}

	@RequestMapping(value="/information")
	public String information() {
		System.out.println("we are in librarycontroller");
		//libraryService.getWorkList(works)
		return "library/information";
	}

	@RequestMapping(value="/condition")
	public String condition() {
		System.out.println("we are in librarycontroller");
		//libraryService.getWorkList(works)
		return "library/condition";
	}
}
