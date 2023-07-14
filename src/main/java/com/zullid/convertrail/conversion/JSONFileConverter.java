package com.zullid.convertrail.conversion;

import java.util.ArrayList;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONFileConverter {
    public String convert(ArrayList<Map<String, Object>> dataMap) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(dataMap);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
