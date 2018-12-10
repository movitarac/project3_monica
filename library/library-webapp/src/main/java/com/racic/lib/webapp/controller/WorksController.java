package com.racic.lib.webapp.controller;

import com.racic.lib.business.service.contract.BookService;
import com.racic.lib.business.service.contract.WorksService;
import com.racic.lib.model.Book;
import com.racic.lib.model.Works;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class WorksController {

    @Autowired
    WorksService worksService;

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/library/search", method = RequestMethod.GET)
    public ModelAndView workssearch(@RequestParam("author") String author) {

        boolean result;
        ModelAndView modelAndView = null;

        List<Works> worksListFound = worksService.findWorksByAuthor(author);
        result = worksService.isValidWork(author);

        if (author != null) {

            if (result == true) {
                modelAndView = new ModelAndView("works/worksfound");
                modelAndView.addObject("worksListFound", worksListFound);

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
        ModelAndView mv = new ModelAndView("works/works-detail");
        Works work = worksService.findWorksById(worksId);
        mv.addObject("work", work);
        return mv;
    }

    //////////////////////////////FOR TEST//////////////////////////////
    @RequestMapping(value = "/library/work/{author}", method = RequestMethod.GET)
    public @ResponseBody
    String sayHello(@PathVariable String author) {

        List<Works> worksList = worksService.findWorksByAuthorIgnoreCase(author);

        String detail = "";
        for (Works work : worksList) {
            detail += work.getTitle();
            detail += "  ";
        }
        return detail;
    }
}
