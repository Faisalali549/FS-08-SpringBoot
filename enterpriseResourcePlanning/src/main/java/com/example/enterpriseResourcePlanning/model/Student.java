package com.example.enterpriseResourcePlanning.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class Student {
    private int RollNo;
    private String Name;
    private char Gender;
    private List<Double> Marks;
    private String City;

}
