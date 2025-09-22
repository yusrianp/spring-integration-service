package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.process.DetailEmployee;
import com.example.demo.process.InsertEmployee;
import com.example.demo.util.UtilsHelper;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class DemoController {
	
	@Autowired
	InsertEmployee insertEmployee;
	
	@Autowired
	DetailEmployee detailEmployee;
	
	@PostMapping("${demo.insert}")
	public HashMap<String, Object> insertEmp(@RequestBody HashMap<String, Object> param) {
		HashMap<String, Object> response = new HashMap<>();
				
		response = insertEmployee.insert(param);
		
		return response;
		
	}
	
	@PostMapping("${demo.getId}")
	public HashMap<String, Object> getId(@RequestBody HashMap<String, Object> param) {
		HashMap<String, Object> response = new HashMap<>();
		
		
		response = detailEmployee.detail(param);
		
		return response;
		
	}
	
	
	
	

}
