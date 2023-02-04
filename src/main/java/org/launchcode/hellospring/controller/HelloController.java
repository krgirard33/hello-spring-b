package org.launchcode.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    // Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // Handles request at path /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }
    // lives at /hello/hello
    // Handles request of the form /hello?=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value="hello")
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }
    // lives at /hello/LaunchCode
    // Handles request of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello " + name + "! How do you like this path?";
    }
    // lives at /hello/form
    @GetMapping("form")
    public String helloForm() {
        String html =
                "<html>" +
                        "<body>" +
                        "<form method = 'post' action = 'hello'>" +
                        "<input type = 'text' name = 'name' />" +
                        "<input type = 'submit' value = 'Greet Me!' />" +
                        "</form>" +
                        "</body>" +
                        "</html>";
        return html;
    }

    // lives at /hello/language
    @GetMapping("language")
    public String helloFormLanguage() {
        String html =
                "<html>" +
                        "<body>" +
                        "<form method = 'post' action = 'greeting'>" +
                        "<input type = 'text' name = 'name' />" +
                        "<select name='language' id='language'>" +
                        "<option value='en'>English</option>" + // Hello
                        "<option value='hi'>Hindi</option>" + // नमस्ते (Namaste)
                        "<option value='zh-Hans'>Chinese</option>" + // 你好 (Nǐ hǎo)
                        "<option value='sp'>Spanish</option>" + // Hola
                        "<option value='eu'>Basque</option>" + // Kaixo
                        "</select>" +
                        "<input type = 'submit' value = 'Greet Me!' />" +
                        "</form>" +
                        "</body>" +
                        "</html>";

        return html;
    }
    @RequestMapping(method = RequestMethod.POST, value="greeting")
    public static String createMessage(@RequestParam String name, @RequestParam String language) {
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
        String html = "<html>" +
                "<body>" +
                "<h1>" + greeting + name +
                "</h1>" +
                "</body>" +
               "</html>";


        return html;
    }
}
