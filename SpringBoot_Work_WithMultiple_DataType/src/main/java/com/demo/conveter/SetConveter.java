package com.demo.conveter;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Convert
public class SetConveter implements AttributeConverter<Set<?>, String> {

	private final ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public String convertToDatabaseColumn(Set<?> attribute) {
		try {
			return mapper.writeValueAsString(attribute);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public Set<?> convertToEntityAttribute(String dbData) {
		try {
			return mapper.readValue(dbData, HashSet.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new HashSet<>();
		}
		
	}

}
