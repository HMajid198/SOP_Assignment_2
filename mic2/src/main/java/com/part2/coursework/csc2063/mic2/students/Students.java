package com.part2.coursework.csc2063.mic2.students;

import java.util.ArrayList;

public class Students {

    private ArrayList<Student> students = new ArrayList<>();

    public Students() {}

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = (students == null) ? new ArrayList<>() : students;
    }

    public void addStudent(Student student) {
        if (student == null) return;
        this.students.add(student);
    }

    public Student findStudentById(String id) {
        if (id == null) return null;
        for (Student s : students) {
            if (id.equals(s.getId())) return s;
        }
        return null;
    }
}
