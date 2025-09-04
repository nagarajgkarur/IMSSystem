package com.iamsystem.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class FalconService {

	
	public Map<String,Object> userData() {
		
		String data = getUserData();
		 Map<String,Object> result = convertStringToMap(data);
		 return result;
	}
	
	public Map<String, Object> convertStringToMap(String data) {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = null;
		try {
			map = mapper.readValue(data, new TypeReference<Map<String, Object>>() {});
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	
	public  Map<String, Object> userDetailsData() {
		String userDetailsData = getUserDetailsData();
		 Map<String, Object> result = convertStringToMap(userDetailsData);
		 return result;
	}
	
	
	
	public String getUserData() {
		String userData = "{\r\n"
				+ " \"meta\": {\r\n"
				+ "  \"query_time\": 0.039553462,\r\n"
				+ "  \"pagination\": {\r\n"
				+ "   \"offset\": 0,\r\n"
				+ "   \"limit\": 100,\r\n"
				+ "   \"total\": 4\r\n"
				+ "  },\r\n"
				+ "  \"powered_by\": \"cs.flightcontrolapi\",\r\n"
				+ "  \"trace_id\": \"03c01aed-eece-4a38-ab6d-37c8fea7161b\"\r\n"
				+ " },\r\n"
				+ " \"resources\": [\r\n"
				+ "  \"663a7962-55d9-4718-931e-550eec6049a8\",\r\n"
				+ "  \"b781cb5b-2461-48ff-83e8-20fb3299fdb9\",\r\n"
				+ "  \"e9210ce9-c7cd-42af-89e0-1b519a1e622b\",\r\n"
				+ "  \"7f9df87f-3c2d-47ae-b133-74b3a51ec929\"\r\n"
				+ " ]\r\n"
				+ "}";
		return userData;
	}
	
	public String getUserDetailsData() {
		String userDetailsData = "{\r\n"
				+ " \"meta\": {\r\n"
				+ "  \"query_time\": 0.086944142,\r\n"
				+ "  \"powered_by\": \"cs.flightcontrolapi\",\r\n"
				+ "  \"trace_id\": \"b857c5bb-1f71-4d59-b078-081f3a96a662\"\r\n"
				+ " },\r\n"
				+ " \"resources\": [\r\n"
				+ "  {\r\n"
				+ "   \"uuid\": \"b781cb5b-2461-48ff-83e8-20fb3299fdb9\",\r\n"
				+ "   \"cid\": \"acd2baa84b65468fb10a4c5785fe165b\",\r\n"
				+ "   \"uid\": \"samtest1@shell.com\",\r\n"
				+ "   \"status\": \"active\",\r\n"
				+ "   \"first_name\": \"SAM\",\r\n"
				+ "   \"last_name\": \"test\",\r\n"
				+ "   \"created_at\": \"2025-07-05T11:57:19.302667Z\",\r\n"
				+ "   \"updated_at\": \"2025-07-05T11:57:19.276448Z\"\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "   \"uuid\": \"e9210ce9-c7cd-42af-89e0-1b519a1e622b\",\r\n"
				+ "   \"cid\": \"acd2baa84b65468fb10a4c5785fe165b\",\r\n"
				+ "   \"uid\": \"samtest@shell.com\",\r\n"
				+ "   \"status\": \"active\",\r\n"
				+ "   \"first_name\": \"SAM\",\r\n"
				+ "   \"last_name\": \"test\",\r\n"
				+ "   \"created_at\": \"2025-07-05T10:37:57.552823Z\",\r\n"
				+ "   \"updated_at\": \"2025-07-05T10:37:57.517347Z\"\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "   \"uuid\": \"663a7962-55d9-4718-931e-550eec6049a8\",\r\n"
				+ "   \"cid\": \"acd2baa84b65468fb10a4c5785fe165b\",\r\n"
				+ "   \"uid\": \"mahesh.m.shetty@shell.com\",\r\n"
				+ "   \"status\": \"active\",\r\n"
				+ "   \"first_name\": \"Mahesh\",\r\n"
				+ "   \"last_name\": \"Shetty\",\r\n"
				+ "   \"created_at\": \"2025-06-19T12:22:06.757307Z\",\r\n"
				+ "   \"updated_at\": \"2025-06-19T12:22:06.729535Z\"\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "   \"uuid\": \"7f9df87f-3c2d-47ae-b133-74b3a51ec929\",\r\n"
				+ "   \"cid\": \"acd2baa84b65468fb10a4c5785fe165b\",\r\n"
				+ "   \"uid\": \"shreya.biswas2@shell.com\",\r\n"
				+ "   \"status\": \"active\",\r\n"
				+ "   \"first_name\": \"shreya\",\r\n"
				+ "   \"last_name\": \"biswas\",\r\n"
				+ "   \"last_login_at\": \"2025-07-01T05:47:08.008696Z\",\r\n"
				+ "   \"factors\": [\r\n"
				+ "    \"TOTP\"\r\n"
				+ "   ],\r\n"
				+ "   \"created_at\": \"2025-06-19T11:59:07.895264Z\",\r\n"
				+ "   \"updated_at\": \"2025-07-01T05:47:11.447157Z\"\r\n"
				+ "  }\r\n"
				+ " ]\r\n"
				+ "}";
		
		return userDetailsData;
	}
}
