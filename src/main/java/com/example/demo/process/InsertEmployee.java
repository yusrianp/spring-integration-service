package com.example.demo.process;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.service.OpenApiService;
import com.example.demo.util.UtilsHelper;

@Service
public class InsertEmployee {
	
	@Autowired
	OpenApiService openApiService;
	
	@Autowired
	UtilsHelper utilHelper;
	
	public HashMap<String, Object> insert(Map<String, Object> param){
		
		HashMap<String, Object> response = new HashMap<>();
		Map<String, Object> respApi = new HashMap<>();
		
		try {
			
			respApi = openApiService.insertEmployee(param);
			
			if(respApi.get("RC").toString().equals("00")) {
				
				response.put("RC", "00");
				response.put("RD", "SUCCESS");
				
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
