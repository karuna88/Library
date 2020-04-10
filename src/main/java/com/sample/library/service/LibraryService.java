package com.sample.library.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.library.domain.Library;
import com.sample.library.repository.LibraryRepository;

@Service
public class LibraryService {
	
	@Autowired
	LibraryRepository libraryRepository;
	
	public Optional<Library> get(long id)
	{
		return libraryRepository.findById(id);
	}

}
