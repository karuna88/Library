package com.sample.library.api;

import org.springframework.stereotype.Component;

import com.sample.library.domain.Library;

@Component
public class LibraryMapper {
	
	public Library from(LibraryRequest libraryRequest)
	{
		return Library.builder()
						.name(libraryRequest.getName())
						.build();
	}
	
	public LibraryApi to(Library library)
	{
		return LibraryApi.builder()
						.id(library.getId())
						.name(library.getName())
						.build();
	}

}
