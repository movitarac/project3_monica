package com.racic.lib.webapp.controller;



import com.racic.lib.client.WorkWeb;
import com.racic.lib.client.WorkWs;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class LibraryController {

	@RequestMapping(value="/")
	public String home()
	{
		return "library/home";
	}


	@RequestMapping(value="/browse", method = RequestMethod.GET)
	public String works(HttpServletRequest request, Model model) {
		WorkWeb workWsService = new WorkWeb();
		WorkWs workWs = workWsService.getWorkWsPort();
		List<com.racic.lib.client.Work> worksList = workWs.getAll();
		model.addAttribute("worksList", worksList);

		return "borrowing/browse";
	}


}