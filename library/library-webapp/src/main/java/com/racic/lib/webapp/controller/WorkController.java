package com.racic.lib.webapp.controller;

import com.racic.lib.business.service.contract.BookService;
import com.racic.lib.business.service.contract.WorkService;
import com.racic.lib.model.Work;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;


@Controller
public class WorkController extends WebServiceGatewaySupport {

    @Autowired
    WorkService workService;

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/searchbyauthor", method = RequestMethod.GET)
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

    @RequestMapping(value = "/workinfo/{worksId}")
    public ModelAndView getWorkInfo(@PathVariable Integer worksId) {
        ModelAndView mv = new ModelAndView("work/works-detail");
        Work work = workService.findWorksById(worksId);
        mv.addObject("work", work);
        return mv;
    }
/*
    @RequestMapping(value = "/searchbyauthor", method = RequestMethod.GET)
    public ModelAndView workssearchbyauthor(@RequestParam("author") String author) {

        boolean result;
        ModelAndView modelAndView = null;
        String url = "http://localhost:8080/library-webapp/ws/workWs/findWorksByAuthorContain";
        String url1 = "http://localhost:8080/library-webapp/ws/workWs/IsValidWorkByAuthor";


        List<Work> worksListFoundByAuthor = (List<Work>)getWebServiceTemplate().marshalSendAndReceive(url,author);

        result = (Boolean)getWebServiceTemplate().marshalSendAndReceive(url1,author);

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
*/

}