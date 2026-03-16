package com.part2.coursework.csc2063.mic1.client;

import com.part2.coursework.csc2063.mic1.controller.LecturerDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class LecturersClient {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${mic3.baseUrl}")
    private String baseUrl;

    public LecturerDto addLecturer(String id) {
        return restTemplate.getForObject(baseUrl + "/add/" + id, LecturerDto.class);
    }

    public LecturerDto findLecturerById(String id) {
        return restTemplate.getForObject(baseUrl + "/findbyid/" + id, LecturerDto.class);
    }

    public LecturerDto assignModule(String id, String moduleCode) {
        return restTemplate.postForObject(baseUrl + "/" + id + "/modules/" + moduleCode, null, LecturerDto.class);
    }

    public void removeModule(String id, String moduleCode) {
        restTemplate.delete(baseUrl + "/" + id + "/modules/" + moduleCode);
    }
}