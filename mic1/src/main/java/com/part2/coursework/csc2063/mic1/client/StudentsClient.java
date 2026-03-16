package com.part2.coursework.csc2063.mic1.client;

import com.part2.coursework.csc2063.mic1.controller.StudentDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StudentsClient {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${mic2.baseUrl}")
    private String baseUrl;

    public StudentDto addStudent(String id) {
        return restTemplate.getForObject(baseUrl + "/add/" + id, StudentDto.class);
    }

    public StudentDto findStudentById(String id) {
        return restTemplate.getForObject(baseUrl + "/findbyid/" + id, StudentDto.class);
    }

    public StudentDto enrolStudent(String id, String moduleCode) {
        return restTemplate.postForObject(baseUrl + "/" + id + "/enrol/" + moduleCode, null, StudentDto.class);
    }

    public StudentDto registerGrade(String id, String moduleCode, int value) {
        return restTemplate.postForObject(baseUrl + "/" + id + "/grade/" + moduleCode + "/" + value, null, StudentDto.class);
    }

    public void unenrolStudent(String id, String moduleCode) {
        restTemplate.delete(baseUrl + "/" + id + "/enrol/" + moduleCode);
    }

    public void unregisterGrade(String id, String moduleCode) {
        restTemplate.delete(baseUrl + "/" + id + "/grade/" + moduleCode);
    }
}