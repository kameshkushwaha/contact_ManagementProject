package com.managent.project.managementproject.controlar;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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


    // for saving tha data to Database
    @PostMapping("/save")
	public ResponseEntity<?> saveUser(@RequestBody Agent agent) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		agentService.save(agent);
		map.put("status", 1);
		map.put("message", "Record is Saved Successfully!");
		return new ResponseEntity<>(map, HttpStatus.CREATED);
	}

     //for deleting tha data from Database by id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		try {
			Agent agent = agentService.findById(id);
			agentService.delete(agent);
			map.put("status", 1);
			map.put("message", "Record is deleted successfully!");
			return new ResponseEntity<>(map, HttpStatus.OK);
		} catch (Exception ex) {
			map.clear();
			map.put("status", 0);
			map.put("message", "Data is not found");
			return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
		}
	}


    @PutMapping("/update/{id}")
	public ResponseEntity<?> updateUserById(@PathVariable Integer id, @RequestBody Agent userDetail) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		try {
			Agent user = agentService.findById(id);
			user.setAgentFirstName(userDetail.getAgentFirstName());
			user.setAgentLastName(userDetail.getAgentLastName());
			user.setDateOfBirth(userDetail.getDateOfBirth());
			user.setJoiningDate(userDetail.getJoiningDate());
			agentService.save(user);
			map.put("status", 1);
			map.put("Massage", "Data has been updated sucessfully");
			map.put("data", agentService.findById(id));
			

			return new ResponseEntity<>(map, HttpStatus.OK);
		} catch (Exception ex) {
			map.clear();
			map.put("status", 0);
			map.put("message", "Data is not found");
			return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
		}
	}



    
}
