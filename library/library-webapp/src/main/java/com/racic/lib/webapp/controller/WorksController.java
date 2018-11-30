package com.racic.lib.webapp.controller;

import com.racic.lib.business.service.contract.WorksService;
import com.racic.lib.model.Book;
import com.racic.lib.model.Member;
import com.racic.lib.model.Works;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WorksController {

	@Autowired
	WorksService worksService;


	@RequestMapping(value="/library/", method=RequestMethod.POST)
	public ModelAndView workssearch(HttpServletRequest request, @ModelAttribute("works")
			Works works){


		boolean result;
		ModelAndView modelAndView = null;
		String author=works.getAuthor();
		String title=works.getTitle();

		String bookdesc = worksService.findWorksByAuthorIgnoreCase(author).getBookDescription();
		int publicationyear = worksService.findWorksByAuthorIgnoreCase(author).getPublicationYear();
		List <Book> bookcopies = worksService.findWorksByAuthorIgnoreCase(author).getBooks();



		if(works !=null && author !=null && title !=null) {

			result = worksService.isValidWork(author,title);
			if (result == true) {
				modelAndView = new ModelAndView("works/worksfound");

				List<Object> list = new ArrayList<>();
				list.add(title);
				list.add(author);
				list.add(bookdesc);
				list.add(publicationyear);
				System.out.println(title + " by " + author);
				modelAndView.addObject("list",list);

			} else {
				modelAndView = new ModelAndView("/library/");
				modelAndView.addObject("msg","Cannot find the book,please retype the author and the title");
			}
		} else {
			modelAndView = new ModelAndView("/library/");
			modelAndView.addObject("msg","Error occured while processing");
		}

		return modelAndView;
	}

	//////////////FOR TEST//////////////////////////////
	@RequestMapping(value = "/library/work/{id}", method = RequestMethod.GET)
	public @ResponseBody String sayHello(@PathVariable Integer id) {

		System.out.println("works found");
		String title = worksService.findWorksById(id).getTitle();
		return "The book is " + title;
	}



	@RequestMapping(value = "/library/works/{id}", method = RequestMethod.GET)
	public String getWorks(@PathVariable Integer id, Model model) {

		System.out.println("works found");
		String title = worksService.findWorksById(id).getTitle();
		String author = worksService.findWorksById(id).getAuthor();
		String description = worksService.findWorksById(id).getBookDescription();
		int publicationyear = worksService.findWorksById(id).getPublicationYear();
		model.addAttribute("title",title);
		model.addAttribute("author",author);
		model.addAttribute("description",description);
		model.addAttribute("publicationyear",publicationyear);
		return "works/works-detail";
	}

}
