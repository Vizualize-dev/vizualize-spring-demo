package dev.vizualize.springdemo.controller;

import dev.vizualize.annotations.RootOperation;
import dev.vizualize.springdemo.service.JsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/json")
public class JsonController {
    @Autowired
    private JsonService jsonService;

    @RootOperation(name="BeautifyJsonOperation")
    @PostMapping(value = "/beautify", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String beautifyJson(@RequestBody String json) {
        return jsonService.beautifyJsonActivity(json);
    }
}
