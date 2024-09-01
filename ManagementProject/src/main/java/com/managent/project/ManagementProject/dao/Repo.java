package com.managent.project.managementproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.managent.project.managementproject.entity.Agent;

public interface Repo extends JpaRepository<Agent,Integer> {

    //public User findByUserName(String userName);

}
