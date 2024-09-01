package com.managent.project.managementproject.entity;

import java.time.LocalDate;

import java.time.LocalDate;

import jakarta.persistence.Entity;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Agent {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String agentFirstName;
    private String agentLastName;
    
	private LocalDate dateOfBirth;
    private LocalDate joiningDate;

    
    public Agent() {
	}


    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getAgentFirstName() {
        return agentFirstName;
    }
    public void setAgentFirstName(String agentFirstName) {
        this.agentFirstName = agentFirstName;
    }
    public String getAgentLastName() {
        return agentLastName;
    }
    public void setAgentLastName(String agentLastName) {
        this.agentLastName = agentLastName;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public LocalDate getJoiningDate() {
        return joiningDate;
    }
    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

 public Agent(Integer id, String agentFirstName, String agentLastName, LocalDate dateOfBirth,
            LocalDate joiningDate) {
        this.id = id;
        this.agentFirstName = agentFirstName;
        this.agentLastName = agentLastName;
        this.dateOfBirth = dateOfBirth;
        this.joiningDate = joiningDate;
    }
    

    
}
