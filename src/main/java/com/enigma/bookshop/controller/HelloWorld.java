package com.enigma.bookshop.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class HelloWorld {

//    http://localhost:8090/hello
    @GetMapping("/hello")       // ini utk uri nya
    String hello(){
        return "Hello World!";
    }

//    http://localhost:8090/hello/1
    @GetMapping("/hello/{var}")
    public String pathVar(@PathVariable String var){
        return "Path var: " + var;
    }

//    http://localhost:8090/req-query?var=alwi
    @GetMapping("/req-query")
    public String queryString(@RequestParam String var) {
        return "Request Param: " + var;
    }

    // POST
    // localhost:8090/hello-body
    @PostMapping("/hello-body")
    public String reqBody(@RequestBody HashMap<String, String> mapBody){
        return "Request Body: " + mapBody;
    }

}
