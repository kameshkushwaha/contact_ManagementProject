package com.managent.project.managementproject.controlar;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.managent.project.managementproject.entity.Agent;
import com.managent.project.managementproject.service.AgentService;

@RestController
@RequestMapping("/api")
public class AgentControlar {

    @Autowired
    private AgentService agentService;

    //for getting the data of all user
    @GetMapping("/agent")
    public ResponseEntity<?> getUser() {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		List<Agent> userList = agentService.getUser();
		if (!userList.isEmpty()) {
			map.put("status", 1);
			map.put("data", userList);
			return new ResponseEntity<>(map, HttpStatus.OK);
		} else {
			map.clear();
			map.put("status", 0);
			map.put("message", "Data is not found");
			return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
		}
	}



    
}
