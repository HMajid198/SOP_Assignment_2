package com.part2.coursework.csc2063.mic3.lecturers;

import java.util.ArrayList;

public class Lecturers {

    private ArrayList<Lecturer> lecturers = new ArrayList<>();

    public Lecturers() {}

    public void setLecturers(ArrayList<Lecturer> lecturers) {
        this.lecturers = (lecturers == null) ? new ArrayList<>() : lecturers;
    }

    public ArrayList<Lecturer> getLecturers() {
        return lecturers;
    }
    
    public void addLecturer(Lecturer lecturer) {
        if (lecturer == null) return;
        this.lecturers.add(lecturer);
    }

    public Lecturer findLecturerById(String id) {
        if (id == null) return null;
        for (Lecturer l : lecturers) {
            if (id.equals(l.getId())) return l;
        }
        return null;
    }
}
