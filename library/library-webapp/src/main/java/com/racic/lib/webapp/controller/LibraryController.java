package com.racic.lib.webapp.controller;

import com.racic.lib.business.service.contract.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LibraryController {

    @Autowired
    LibraryService libraryService;
}
