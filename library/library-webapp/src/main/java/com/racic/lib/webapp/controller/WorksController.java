package com.racic.lib.webapp.controller;

import com.racic.lib.business.service.contract.WorksService;
import com.racic.lib.model.Works;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WorksController {

	@Autowired
	WorksService worksService;

	@RequestMapping(value = "/works/{id}", method = RequestMethod.GET)
	public @ResponseBody String sayHello(@PathVariable String id) {

		System.out.println("works found");
		String title = worksService.findWorksById(id).getTitle();
		return "The book is " + title;
	}

	@RequestMapping(value = "/allworks", method = RequestMethod.GET)
	public @ResponseBody String getWorksList() {

		List<Works> w1 = worksService.getAll();
		String explication =null;
		for (Works w : w1) {
			explication = w.getAuthor() + " " + w.getBookDescription() 
			+ " " + w.getTitle();
			return explication;
		}
		return explication;
			
	}

}
