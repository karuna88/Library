package com.sample.library.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.library.api.LibraryMapper;
import com.sample.library.api.LibraryResponse;
import com.sample.library.domain.Library;
import com.sample.library.service.LibraryService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path="/api/library")
public class LibraryController {
	
	@Autowired
	private LibraryService libraryService;
	
	@Autowired
	private LibraryMapper libraryMapper;
	
	@ApiOperation(value = "Get the library details",
			notes="Sends Library details using id")
	@GetMapping(path="/{id}")
	public ResponseEntity<LibraryResponse> get(@PathVariable long id)
	{
		log.info("Received id: "+id+" from Request");
		Optional<Library> library = libraryService.get(id);
		if(library.isPresent())
		{
			LibraryResponse libraryResponse = LibraryResponse.builder()
									.library(libraryMapper.to(library.get()))
									.build();
			return ResponseEntity.ok(libraryResponse);
		}
		else
			 return ResponseEntity.notFound().build();
	}

}
