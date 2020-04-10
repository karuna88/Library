package com.sample.library.api;

import org.springframework.stereotype.Component;

@Component
public class LibraryDataGenerator {
	
	public static LibraryApi getLibraryData()
	{
		return LibraryApi.builder()
					.id(1L)
					.name("Libary1")
					.build();
	}
}
