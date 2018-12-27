package com.racic.lib.endpoint;

import com.racic.lib.business.service.contract.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@Service
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use= SOAPBinding.Use.LITERAL)
public class LibraryWS {

    @Autowired
    LibraryService libraryService;


}
