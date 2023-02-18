package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("crossorigin/api")
public class CrossOriginController {
	@GetMapping("")
    public String execute(@RequestParam(required = false) String callback, HttpServletResponse response) {
		// JSON形式の固定文言
		String json = "{ \"name\": \"suzuki\", \"age\": \"30\" }";
		
//		パターン4の回避用
//		response.setHeader("Access-Control-Allow-Origin", "http://localhost:50001");

		// JSONPを使用する場合
		if (callback != null) {
			// JSONP用
			return callback + "(" + json + ")";
		}
		return json;
    }
}
