package com.nt.service;

import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.repository.IPersonRepo;

@Service("service")
public class PersonServiceImpl implements IPersonService {
	@Autowired
	private IPersonRepo repo;

	@Override
	public Set<String> getAllCountry() {
		Locale[] locale = Locale.getAvailableLocales();
		Set<String> cuntriesList= new TreeSet();
		for(Locale l1:locale) {
			cuntriesList.add(l1.getDisplayCountry());
		}
		return cuntriesList;
	}

	@Override
	public Set<String> getAllLanguages() {
		Locale[] locale = Locale.getAvailableLocales();
		Set<String> languageList= new TreeSet<>();
		for(Locale l1:locale) {
			languageList.add(l1.getDisplayLanguage());
		}
		return languageList;
	}
	@Override
	public Set<String> getAllHobbies() {
		return repo.getAllHobies();
	}

}
