package com.faisal.chatApp.service;

import com.faisal.chatApp.dao.StatusRepository;
import com.faisal.chatApp.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService {
    @Autowired
    StatusRepository repository;
    public int saveStatus(Status status) {
        Status statusObj = repository.save(status);
        return statusObj.getStatusId();
    }
}
