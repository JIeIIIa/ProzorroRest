package com.gmail.onishchenko.oleksii.prozorrorest.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

    private static final Logger LOG = LogManager.getLogger(WelcomeController.class);

    @RequestMapping(value = {"", "/", "index"})
    public String index() {
        LOG.traceEntry();
        return "redirect:/index.html";
    }
}
