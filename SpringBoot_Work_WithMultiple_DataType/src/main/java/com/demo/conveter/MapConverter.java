package com.demo.conveter;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Convert
public class MapConverter implements AttributeConverter<Map<?, ?>, String> {
	
	private final ObjectMapper mapper = new ObjectMapper();

	@Override
	public String convertToDatabaseColumn(Map<?, ?> attribute) {
		try {
			return mapper.writeValueAsString(attribute);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Map<?, ?> convertToEntityAttribute(String dbData) {
		try {
			return mapper.readValue(dbData, HashMap.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new HashMap<>();
		}
		
	}

}
