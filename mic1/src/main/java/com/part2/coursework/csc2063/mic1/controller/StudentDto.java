package com.part2.coursework.csc2063.mic1.controller;

import java.util.ArrayList;
import java.util.HashMap;

public class StudentDto {
    private String id;
    private ArrayList<String> moduleCodes = new ArrayList<>();
    private HashMap<String, Integer> grades = new HashMap<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<String> getModuleCodes() {
        return moduleCodes;
    }

    public void setModuleCodes(ArrayList<String> moduleCodes) {
        this.moduleCodes = (moduleCodes == null) ? new ArrayList<>() : moduleCodes;
    }

    public HashMap<String, Integer> getGrades() {
        return grades;
    }

    public void setGrades(HashMap<String, Integer> grades) {
        this.grades = (grades == null) ? new HashMap<>() : grades;
    }
}