package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.client.OpenApiClient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OpenApiService {
	
	final
	OpenApiClient OpenApiClient;
	
    public OpenApiService(OpenApiClient OpenApiClient) {
        this.OpenApiClient = OpenApiClient;
    }
	 
	public Map<String, Object> insertEmployee(Map<String, Object> request){
		
		Map<String, Object> result = new HashMap<>();
		
		
		try {
			
			result = OpenApiClient.insert(request);
						
		}catch(feign.RetryableException e) {
			
			e.printStackTrace();
			result.put("RC", "H68");
			result.put("RD", e.getMessage());
			return result;
			
		}catch (Exception e2) {
			e2.printStackTrace();
			result.put("RC", "H68");
			result.put("RD", e2.getMessage());
			return result;
		}
		
		return result;

	}
	
	public Map<String, Object> detailEmployee(String employee_id){
		
		Map<String, Object> result = new HashMap<>();
		
		
		try {
			
			result = OpenApiClient.getById(employee_id);
						
		}catch(feign.RetryableException e) {
			
			e.printStackTrace();
			result.put("RC", "H68");
			result.put("RD", e.getMessage());
			return result;
			
		}catch (Exception e2) {
			e2.printStackTrace();
			result.put("RC", "H68");
			result.put("RD", e2.getMessage());
			return result;
		}
		
		return result;

	}

}
