package com.racic.lib.webapp.controller;

import com.racic.lib.business.service.contract.LibraryService;
import com.racic.lib.business.service.contract.WorksService;
import com.racic.lib.model.Member;
import com.racic.lib.model.Works;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.http.HttpServletRequest;
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
		return "library/condition";
	}

	@RequestMapping(value="/library/browse", method = RequestMethod.GET)
	public String works(HttpServletRequest request, Model model) {

			List<Works> worksList = worksService.getAll();
			model.addAttribute("worksList", worksList);

			Member memberConnected = (Member)request.getSession().getAttribute("memberConnected");
		System.out.println(memberConnected.getFirstName());
			for (Works works : worksList)
			{
				System.out.println(works.getTitle());
				System.out.println(works.getAuthor());
			}
			return "borrowing/browse";




	}


}
