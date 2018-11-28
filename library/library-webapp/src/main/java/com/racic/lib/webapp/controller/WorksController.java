package com.racic.lib.webapp.controller;

import com.racic.lib.business.service.contract.WorksService;
import com.racic.lib.model.Works;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WorksController {

	@Autowired
	WorksService worksService;

	@RequestMapping(value = "/library/work/{id}", method = RequestMethod.GET)
	public @ResponseBody String sayHello(@PathVariable String id) {

		System.out.println("works found");
		String title = worksService.findWorksById(id).getTitle();
		return "The book is " + title;
	}


	@RequestMapping(value = "/library/works/{id}", method = RequestMethod.GET)
	public String getWorks(@PathVariable String id, Model model) {

		System.out.println("works found");
		String title = worksService.findWorksById(id).getTitle();
		String author = worksService.findWorksById(id).getAuthor();
		String description = worksService.findWorksById(id).getBookDescription();
		int copies = worksService.findWorksById(id).getCopies();
		int publicationyear = worksService.findWorksById(id).getPublicationYear();
		model.addAttribute("title",title);
		model.addAttribute("author",author);
		model.addAttribute("description",description);
		model.addAttribute("copies",copies);
		model.addAttribute("publicationyear",publicationyear);
		return "works/works-detail";
	}

}
