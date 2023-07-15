package com.demo.conveter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Convert
public class ListConveter implements AttributeConverter<List<?>, String> {

	private final ObjectMapper mapper = new ObjectMapper();
	@Override
	public String convertToDatabaseColumn(List<?> attribute) {
		try {
			return mapper.writeValueAsString(attribute);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<?> convertToEntityAttribute(String dbData) {
		try {
			 return  mapper.readValue(dbData, ArrayList.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

}
