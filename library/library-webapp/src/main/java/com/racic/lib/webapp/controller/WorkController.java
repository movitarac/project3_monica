package com.racic.lib.webapp.controller;

import com.racic.lib.business.service.contract.BookService;
import com.racic.lib.business.service.contract.WorkService;
import com.racic.lib.model.Work;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class WorkController {

    @Autowired
    WorkService workService;

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/library/searchbyauthor", method = RequestMethod.GET)
    public ModelAndView workssearchbyauthor(@RequestParam("author") String author) {

        boolean result;
        ModelAndView modelAndView = null;

        List<Work> worksListFoundByAuthor = workService.findWorksByAuthorContain(author);
        result = workService.isValidWorkByAuthor(author);


        if (result == true) {
            if (author != null) {
                modelAndView = new ModelAndView("work/worksfound");
                modelAndView.addObject("worksListFound", worksListFoundByAuthor);
            } else {
                modelAndView = new ModelAndView("library/error");
                modelAndView.addObject("msg", "Error occured while processing");
            }
        } else {
            modelAndView = new ModelAndView("library/error");
            modelAndView.addObject("msg", "Error occured while processing");
        }

        return modelAndView;
    }

    @RequestMapping(value = "/library/workinfo/{worksId}")
    public ModelAndView getWorkInfo(@PathVariable Integer worksId) {
        ModelAndView mv = new ModelAndView("work/works-detail");
        Work work = workService.findWorksById(worksId);
        mv.addObject("work", work);
        return mv;
    }

}