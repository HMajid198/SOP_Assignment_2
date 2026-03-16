package com.part2.coursework.csc2063.mic3.lecturers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.part2.coursework.csc2063.mic3.lecturers.Lecturer;
import com.part2.coursework.csc2063.mic3.lecturers.ModuleCode;

public class LecturerTest {

    @Test
    void lecturer_assignModule_and_removeModule_work() {
        Lecturer lecturer = new Lecturer("L001");

        assertTrue(lecturer.getModuleCodes().isEmpty());

        lecturer.assignModuleCode(ModuleCode.CSC2063);
        assertTrue(lecturer.getModuleCodes().contains(ModuleCode.CSC2063));

        // assigning again should not duplicate
        lecturer.assignModuleCode(ModuleCode.CSC2063);
        assertEquals(1, lecturer.getModuleCodes().size());

        lecturer.removeModuleCode(ModuleCode.CSC2063);
        assertFalse(lecturer.getModuleCodes().contains(ModuleCode.CSC2063));
        assertEquals(0, lecturer.getModuleCodes().size());
    }

    @Test
    void setId_and_getId_work() {
        Lecturer lecturer = new Lecturer();
        lecturer.setId("L777");
        assertEquals("L777", lecturer.getId());
    }
}
