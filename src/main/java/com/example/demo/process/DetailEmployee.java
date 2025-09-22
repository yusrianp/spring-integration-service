package com.example.demo.process;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.service.OpenApiService;

@Service
public class DetailEmployee {
	
	@Autowired
	OpenApiService openApiService;
	
	public HashMap<String, Object> detail(Map<String, Object> param){
		
		HashMap<String, Object> response = new HashMap<>();
		Map<String, Object> respApi = new HashMap<>();
		Map<String, Object> respData = new HashMap<>();
		
		try {
			
			String employee_id = (String) param.get("employee_id");
				
			respApi = openApiService.detailEmployee(employee_id);
			
			
			if(respApi.get("RC").toString().equals("00")) {
				
				respData = (Map<String, Object>) respApi.get("Data");
				
				response.put("RC", "00");
				response.put("RD", "SUCCESS");
				response.put("Data", respData);
				
			}else if(respApi.get("RC").toString().equals("H68")) {
				
				response.put("RC", "H68");
				response.put("RD", respApi.get("RD"));
				
			}else {
				
				response.put("RC", "01");
				response.put("RD", "FAILED");
				
			}
						
			
		} catch (Exception e) {
			e.printStackTrace();
			response.put("RC", "01");
			response.put("RD", "FAILED");
		}
		
		return response ; 
		
	}

}
