package com.example.enterpriseResourcePlanning.controller;

import com.example.enterpriseResourcePlanning.model.Student;
import com.example.enterpriseResourcePlanning.service.ERPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/ERP-App")
public class ERPController {
//    CRUD
//    Topper
//    Least Score
//    Percentage
    @Autowired
    private ERPService erpService;
    @GetMapping("/find-all")
    public List<Student> findAllStudent() {
        return erpService.findAll();
    }
}
