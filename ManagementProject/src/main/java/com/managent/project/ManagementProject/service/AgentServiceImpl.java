package com.managent.project.managementproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.managent.project.managementproject.dao.Repo;
import com.managent.project.managementproject.entity.Agent;


@Service
public class AgentServiceImpl implements AgentService {

        @Autowired
        private Repo repo;

        @Override
        public List<Agent> getUser() {
            // TODO Auto-generated method stub
           // throw new UnsupportedOperationException("Unimplemented method 'getUser'");
           return repo.findAll();
        }

        @Override
        public void save(Agent agent) {
            // TODO Auto-generated method stub
            //throw new UnsupportedOperationException("Unimplemented method 'save'");
            repo.save(agent);
        }

        @Override
        public Agent findById(Integer id) {
            // TODO Auto-generated method stub
            //throw new UnsupportedOperationException("Unimplemented method 'findById'");
            return repo.findById(id).get();
        }

        @Override
        public Agent findbyUserName(String agentFirstName) {
            // TODO Auto-generated method stub
           // throw new UnsupportedOperationException("Unimplemented method 'findbyUserName'");
           return repo.findByUserName(agentFirstName);

        }

        @Override
        public void delete(Agent agent) {
            // TODO Auto-generated method stub
           // throw new UnsupportedOperationException("Unimplemented method 'delete'");
           repo.delete(agent);
        }
    
       
           

    
    
    
}
