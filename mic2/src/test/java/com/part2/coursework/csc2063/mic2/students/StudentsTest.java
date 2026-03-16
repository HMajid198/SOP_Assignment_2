package com.part2.coursework.csc2063.mic2.students;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StudentsTest {

    @Test
    void addStudent_and_findStudentById_worksCorrectly() {
        Students students = new Students();

        Student s1 = new Student("S001");
        Student s2 = new Student("S002");

        students.addStudent(s1);
        students.addStudent(s2);

        Student found = students.findStudentById("S002");
        assertNotNull(found);
        assertEquals("S002", found.getId());

        assertNull(students.findStudentById("S999"));
        assertNull(students.findStudentById(null));
    }
}
