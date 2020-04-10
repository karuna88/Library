package com.sample.library.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sample.library.domain.Library;
import com.sample.library.service.LibraryService;

@RunWith(SpringJUnit4ClassRunner.class)
public class LibraryControllerTest {
	
	
	@Mock
	private LibraryService libraryService;
	
	@Test
	public void testGet()
	{
		Optional<Library> library = Optional.of(Library.builder()
															.id(1L)
															.name("Library One")
															.build());
		
		when(libraryService.get(1L)).thenReturn(library);
		
		Optional<Library> libraryObj = libraryService.get(1L);
		assertThat(libraryObj.get().getId(),is(1L));
				
	}
	
	
	

}
