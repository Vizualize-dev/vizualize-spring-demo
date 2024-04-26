package dev.vizualize.springdemo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import dev.vizualize.annotations.Activity;
import org.springframework.stereotype.Service;

@Service
public class JsonService {
    private final ObjectMapper objectMapper;

    public JsonService() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    @Activity(name="BeautifyJsonActivity")
    public String beautifyJsonActivity(String json) {
        // First validate JSON
        if (!isValidJson(json)) {
            return "Invalid JSON: Please check your input and try again.";
        }

        // If valid, beautify it
        try {
            Object jsonObject = objectMapper.readValue(json, Object.class);
            return objectMapper.writeValueAsString(jsonObject);
        } catch (JsonProcessingException e) {
            // This should not happen as we have already validated the JSON
            return "Unexpected error in processing JSON: " + e.getMessage();
        }
    }

    @Activity
    public boolean isValidJson(String json) {
        try {
            new ObjectMapper().readTree(json);
            return true;
        } catch (JsonProcessingException e) {
            return false;
        }
    }
}
