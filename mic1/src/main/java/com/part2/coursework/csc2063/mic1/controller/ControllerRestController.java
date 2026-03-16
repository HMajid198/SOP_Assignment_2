package com.part2.coursework.csc2063.mic1.controller;

import com.part2.coursework.csc2063.mic1.client.LecturersClient;
import com.part2.coursework.csc2063.mic1.client.StudentsClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerRestController {

    private final StudentsClient studentsClient;
    private final LecturersClient lecturersClient;

    public ControllerRestController(StudentsClient studentsClient, LecturersClient lecturersClient) {
        this.studentsClient = studentsClient;
        this.lecturersClient = lecturersClient;
    }

    @PostMapping("/students/add/{studentId}")
    public StudentDto addStudent(@PathVariable String studentId) {
        return studentsClient.addStudent(studentId);
    }

    @PostMapping("/students/add/{studentId}/extra")
    public StudentDto addStudentExtra(@PathVariable String studentId) {
        return studentsClient.addStudent(studentId);
    }

    @PostMapping("/students/{studentId}/enrol/{moduleCode}")
    public StudentDto enrolStudent(@PathVariable String studentId, @PathVariable String moduleCode) {
        return studentsClient.enrolStudent(studentId, moduleCode);
    }

    @DeleteMapping("/students/{studentId}/enrol/{moduleCode}")
    public StudentDto unenrolStudent(@PathVariable String studentId, @PathVariable String moduleCode) {
        studentsClient.unenrolStudent(studentId, moduleCode);
        return studentsClient.findStudentById(studentId);
    }

    @PostMapping("/students/{studentId}/grade/{moduleCode}/{value}")
    public StudentDto registerGrade(@PathVariable String studentId,
                                    @PathVariable String moduleCode,
                                    @PathVariable int value) {
        return studentsClient.registerGrade(studentId, moduleCode, value);
    }

    @DeleteMapping("/students/{studentId}/grade/{moduleCode}")
    public StudentDto unregisterGrade(@PathVariable String studentId, @PathVariable String moduleCode) {
        studentsClient.unregisterGrade(studentId, moduleCode);
        return studentsClient.findStudentById(studentId);
    }

    @PostMapping("/lecturers/add/{lecturerId}")
    public LecturerDto addLecturer(@PathVariable String lecturerId) {
        return lecturersClient.addLecturer(lecturerId);
    }

    @GetMapping("/lecturers/findbyid/{lecturerId}")
    public LecturerDto findLecturerById(@PathVariable String lecturerId) {
        return lecturersClient.findLecturerById(lecturerId);
    }

    @PostMapping("/lecturers/{lecturerId}/modules/{moduleCode}")
    public LecturerDto assignModuleToLecturer(@PathVariable String lecturerId, @PathVariable String moduleCode) {
        return lecturersClient.assignModule(lecturerId, moduleCode);
    }

    @DeleteMapping("/lecturers/{lecturerId}/modules/{moduleCode}")
    public LecturerDto removeModuleFromLecturer(@PathVariable String lecturerId, @PathVariable String moduleCode) {
        lecturersClient.removeModule(lecturerId, moduleCode);
        return lecturersClient.findLecturerById(lecturerId);
    }
}