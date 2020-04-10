package com.sample.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.library.domain.Library;

public interface LibraryRepository extends JpaRepository<Library,Long>{

}
