package ru.avd.springmvc.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileWriter;
import java.io.IOException;


@Controller

public class IndexController {
    private static final Logger logger = Logger.getLogger(IndexController.class);
    @GetMapping("/index")
    public String viewIndexPage() {
        return "index";
    }

    @RequestMapping("/send")
    public String viewSendPage(){
        return "send";
    }
    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String sendDate(@RequestParam(value = "data") String data) throws IOException {
        FileWriter writer = new FileWriter("text.txt");
        writer.write("data");
        writer.close();
        System.err.println(data);
        logger.info(data);

        return "redirect:/index";
    }
}
