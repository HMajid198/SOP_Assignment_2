package com.part2.coursework.csc2063.mic3.lecturers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.part2.coursework.csc2063.mic3.lecturers.Lecturer;
import com.part2.coursework.csc2063.mic3.lecturers.Lecturers;

public class LecturersTest {

    @Test
    void findLecturerById_returnsCorrectLecturerOrNull() {
        Lecturers lecturers = new Lecturers();

        Lecturer l1 = new Lecturer("L001");
        Lecturer l2 = new Lecturer("L002");

        lecturers.getLecturers().add(l1);
        lecturers.getLecturers().add(l2);

        assertSame(l2, lecturers.findLecturerById("L002"));
        assertNull(lecturers.findLecturerById("L999"));
        assertNull(lecturers.findLecturerById(null));
    }

    @Test
    void setLecturers_replacesList_and_handlesNull() {
        Lecturers lecturers = new Lecturers();

        assertNotNull(lecturers.getLecturers());
        assertEquals(0, lecturers.getLecturers().size());

        lecturers.setLecturers(null);
        assertNotNull(lecturers.getLecturers());
        assertEquals(0, lecturers.getLecturers().size());
    }
}
