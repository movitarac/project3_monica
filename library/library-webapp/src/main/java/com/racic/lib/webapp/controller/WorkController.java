package com.racic.lib.webapp.controller;

import com.racic.lib.client.Work;
import com.racic.lib.client.WorkWeb;
import com.racic.lib.client.WorkWs;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;


@Controller
public class WorkController {



    @RequestMapping(value = "/workinfo/{worksId}")
    public ModelAndView getWorkInfo(@PathVariable Integer worksId) {
        ModelAndView mv = new ModelAndView("work/works-detail");
        WorkWeb workWsService = new WorkWeb();
        WorkWs workWs = workWsService.getWorkWsPort();

        Work work = workWs.findWorksById(worksId);
        mv.addObject("work", work);
        return mv;
    }

    @RequestMapping(value = "/searchbyauthor", method = RequestMethod.GET)
    public ModelAndView workssearchbyauthor(@RequestParam("author") String author) {

        boolean result;
        ModelAndView modelAndView = null;

       WorkWeb workWsService = new WorkWeb();
       WorkWs workWs = workWsService.getWorkWsPort();
        List<com.racic.lib.client.Work> worksListFoundByAuthor = workWs.findWorksByAuthorContain(author);
        result = workWs.isValidWorkByAuthor(author);

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

}