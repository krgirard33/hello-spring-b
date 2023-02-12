package org.launchcode.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("hello")
public class HelloController {

    // Handles request at path /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // lives at /hello/hello
    // Handles request from hello/form - helloForm()
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value="hello")
    public String helloWithQueryParam(@RequestParam String name, Model model) {
        String greeting = "Hello, "+name+"!";
        model.addAttribute("greeting",greeting);
        return "hello";
    }

    // lives at /hello/LaunchCode
    // Handles request of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name, Model model) {
        String greeting = "Hello, "+name+"!";
        model.addAttribute("greeting",greeting);
        return "hello";
    }
    // lives at /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "form";
    }

    // lives at /hello/language
    @GetMapping("language")
    public String helloFormLanguage() {
        return "helloFormLanguage";
    }

    @RequestMapping(method = RequestMethod.POST, value="greeting")
    public static String createMessage(@RequestParam String name, @RequestParam String language, Model model) {
        String greeting = "";

        switch(language) {
            case "en":
                greeting = "Hello ";
                break;
            case "hi":
                greeting = "नमस्ते (Namaste) ";
                break;
            case "zh-Hans":
                greeting = "你好 (Nǐ hǎo) ";
                break;
            case "sp":
                greeting = "Halo ";
                break;
            case "eu":
                greeting = "Kaixo ";
                break;
        }
        String greetingFull = greeting+", "+name+"!";
        model.addAttribute("greetingFull", greetingFull);
        return "helloLanguage";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("Ken");
        names.add("Alesia");
        names.add("Tim");
        model.addAttribute("names", names);
        return "hello-names";
    }
}
