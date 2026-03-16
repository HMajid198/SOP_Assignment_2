package com.part2.coursework.csc2063.mic3.lecturers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LecturersRestController {

    private final Lecturers lecturers = new Lecturers();

    @GetMapping("/add/{id}")
    public Lecturer addLecturer(@PathVariable String id) {
        Lecturer existing = lecturers.findLecturerById(id);
        if (existing != null) {
            return existing;
        }

        Lecturer lecturer = new Lecturer(id);
        lecturers.addLecturer(lecturer);
        return lecturer;
    }

    @GetMapping("/findbyid/{id}")
    public Lecturer findLecturerById(@PathVariable String id) {
        return lecturers.findLecturerById(id);
    }

    @PostMapping("/{id}/modules/{moduleCode}")
    public Lecturer assignModule(@PathVariable String id, @PathVariable String moduleCode) {
        Lecturer lecturer = lecturers.findLecturerById(id);
        if (lecturer == null) return null;

        lecturer.assignModuleCode(ModuleCode.valueOf(moduleCode));
        return lecturer;
    }

    @DeleteMapping("/{id}/modules/{moduleCode}")
    public Lecturer removeModule(@PathVariable String id, @PathVariable String moduleCode) {
        Lecturer lecturer = lecturers.findLecturerById(id);
        if (lecturer == null) return null;

        lecturer.removeModuleCode(ModuleCode.valueOf(moduleCode));
        return lecturer;
    }
}