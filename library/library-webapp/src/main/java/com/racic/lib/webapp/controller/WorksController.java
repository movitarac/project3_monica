package com.racic.lib.webapp.controller;

import com.racic.lib.business.service.contract.BookService;
import com.racic.lib.business.service.contract.WorksService;
import com.racic.lib.model.Book;
import com.racic.lib.model.Works;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WorksController {

	@Autowired
	WorksService worksService;

	@Autowired
	BookService bookService;

	@RequestMapping(value="/library/search", method=RequestMethod.GET)
	public ModelAndView workssearch(@RequestParam("author") String author){

		boolean result;
		ModelAndView modelAndView = null;
        result = worksService.isValidWork(author);
        List<Works> worksListFound = worksService.findWorksByAuthor(author);

		List<Book> booksListAvailableForOneWork= null;

		int nocopies = 0;

		if(worksListFound.size()>0  && author !=null) {

			if (result == true) {

				for (int i = 0; i < worksListFound.size(); i++) {
					Integer worksid = worksListFound.get(i).getWorksId();
					booksListAvailableForOneWork = bookService.findBooksByWorksWorksId(worksid);
					worksListFound.get(i).setCopiesAvailable(booksListAvailableForOneWork.size());
					System.out.println("Copies available " + worksListFound.get(i).getCopiesvailable());
				}

				modelAndView = new ModelAndView("works/worksfound");
				modelAndView.addObject("worksListFound",worksListFound);




			} else {
				modelAndView = new ModelAndView("borrowing/browse");
				modelAndView.addObject("msg","Cannot find the book,please retype the author and the title");
			}
		} else {
			modelAndView = new ModelAndView("library/error");
			modelAndView.addObject("msg","Error occured while processing");
		}

		return modelAndView;
	}

	//////////////FOR TEST//////////////////////////////
	@RequestMapping(value = "/library/work/{author}", method = RequestMethod.GET)
	public @ResponseBody String sayHello(@PathVariable String author) {

		List<Works> worksList = worksService.findWorksByAuthorIgnoreCase(author);

		String detail = "";
		for (Works work: worksList) {
				detail +=work.getTitle();
				detail += "  ";
		}
		return detail;
	}



}
