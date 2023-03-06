package com.faisal.chatApp.controller;

import com.faisal.chatApp.model.Status;
import com.faisal.chatApp.service.StatusService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/status")
public class StatusController {
    @Autowired
    StatusService service;
    @PostMapping(value = "/create-status")
    public ResponseEntity<String> createStatus(@RequestBody String statusData) {
        Status status = setStatus(statusData);
        int statusId = service.saveStatus(status);
        return new ResponseEntity<>("status saved -" + statusId, HttpStatus.CREATED);
    }

    private Status setStatus(String statusData) {
        Status status = new Status();
        JSONObject object = new JSONObject(statusData);
        status.setStatusName(object.getString("statusName"));
        status.setStatusDescription(object.getString("statusDescription"));

        return status;
    }
}
