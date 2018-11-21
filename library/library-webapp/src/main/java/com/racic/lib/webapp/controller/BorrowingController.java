package com.racic.lib.webapp.controller;

import com.racic.lib.business.service.contract.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BorrowingController {

    @Autowired
    BorrowingService borrowingService;
}
