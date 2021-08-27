package ru.avd.springmvc.controllers;

import org.apache.log4j.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;


@Controller

public class IndexController {
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
        return "redirect:/index";
    }
}
