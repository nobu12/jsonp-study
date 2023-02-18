package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class SameOriginController {
    @GetMapping
    public String index() {
        return "index";
    }
	
    @GetMapping("sameorigin/api")
    public String execute(@RequestParam(required = false) String callback, HttpServletResponse response) {
		// JSON形式の固定文言
		String json = "{ \"name\": \"suzuki\", \"age\": \"30\" }";
		
		// JSONPを使用する場合
		if (callback != null) {
			return callback + "(" + json + ")";
		}
		return json;
    }
}
