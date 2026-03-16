package com.part2.coursework.csc2063.mic3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AliveController {

    @GetMapping("/alive")
    public String alive() {
        return "mic3 (Lecturers) is alive";
    }
}
