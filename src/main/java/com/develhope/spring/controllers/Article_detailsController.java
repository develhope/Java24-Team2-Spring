package com.develhope.spring.controllers;

import com.develhope.spring.services.Article_detailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dettagliArticolo")
public class Article_detailsController {
    @Autowired
    private Article_detailService articleDetailService;


}
