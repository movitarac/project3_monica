package com.racic.lib.webapp.controller;

import com.racic.lib.business.service.contract.BorrowingService;
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
	WorkService workService;


	@RequestMapping(value="/")
	public String home()
	{
		return "library/home";
	}


	@RequestMapping(value="/browse", method = RequestMethod.GET)
	public String works(HttpServletRequest request, Model model) {
		List<Work> worksList = workService.getAll();
		model.addAttribute("worksList", worksList);

		return "borrowing/browse";
	}


}