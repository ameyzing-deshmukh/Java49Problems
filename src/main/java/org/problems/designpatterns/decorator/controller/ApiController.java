package org.problems.designpatterns.decorator.controller;

import org.problems.designpatterns.decorator.service.ApiService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {
    ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/fetch/{key}")
    public String fetchData(@PathVariable String key) {
        return apiService.fetchData(key);
    }

    @PostMapping("/save/{key}")
    public String saveData(@PathVariable String key, @RequestBody String value) {
        return apiService.saveData(key, value);
    }
}
