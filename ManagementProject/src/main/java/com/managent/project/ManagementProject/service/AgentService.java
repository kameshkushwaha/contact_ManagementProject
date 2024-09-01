package com.managent.project.managementproject.service;

import java.util.List;

import com.managent.project.managementproject.entity.Agent;

public interface AgentService {
        
    public List<Agent> getUser();

	public void save(Agent agent);

	public Agent findById(Integer id);

	public Agent findbyUserName(String userName);

	public void delete(Agent agent);
    
}