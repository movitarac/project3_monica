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
	    	//libraryService.getWorkList(works)
	    	return "library/home";
	    }
	 @RequestMapping(value="/connection")
	    public String login() {
	    	System.out.println("we are in librarycontroller");
	    	//libraryService.getWorkList(works)
	    	return "member/connection";
	    }
}
