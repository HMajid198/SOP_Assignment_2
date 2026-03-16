package com.part2.coursework.csc2063.mic2.students;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StudentTest {

    @Test
    void enrolModuleCode_addsModuleCodeWithNoGradeYet() {
        Student student = new Student("S001");

        student.enrolModuleCode(ModuleCode.CSC2063);

        assertTrue(student.getModules().containsKey(ModuleCode.CSC2063));
        assertEquals(-1, student.getModules().get(ModuleCode.CSC2063));
    }

    @Test
    void registerGrade_updatesGrade_onlyIfEnrolled() {
        Student student = new Student("S001");

        // Not enrolled => should not add key
        student.registerGrade(ModuleCode.CSC2063, 85);
        assertFalse(student.getModules().containsKey(ModuleCode.CSC2063));

        // Enrol then register
        student.enrolModuleCode(ModuleCode.CSC2063);
        student.registerGrade(ModuleCode.CSC2063, 85);

        assertEquals(85, student.getModules().get(ModuleCode.CSC2063));
    }

    @Test
    void unregisterGrade_resetsToNoGradeYet_ifEnrolled() {
        Student student = new Student("S001");

        student.enrolModuleCode(ModuleCode.CSC2063);
        student.registerGrade(ModuleCode.CSC2063, 92);

        student.unregisterGrade(ModuleCode.CSC2063);

        assertEquals(-1, student.getModules().get(ModuleCode.CSC2063));
    }

    @Test
    void unenrolModuleCode_removesModuleCode() {
        Student student = new Student("S001");

        student.enrolModuleCode(ModuleCode.CSC2063);
        student.unenrolModuleCode(ModuleCode.CSC2063);

        assertFalse(student.getModules().containsKey(ModuleCode.CSC2063));
    }
}
