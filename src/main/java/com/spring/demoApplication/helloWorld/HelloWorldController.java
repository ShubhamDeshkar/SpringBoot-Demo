package com.spring.demoApplication.helloWorld;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    public String helloWorld() {
        return "Hello, World!";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello, Shubham!");
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldpathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello, %s", name));
    }
}
