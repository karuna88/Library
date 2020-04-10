package com.sample.library.restclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sample.library.api.BookResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class RestTemplateController {
	
	@Value("${service-two.api.book.url}")
	private String serviceTwoUrl;
	
	private RestTemplate restTemplate;
	
	@Autowired
	public RestTemplateController(RestTemplate restTemplate)
	{
		this.restTemplate = restTemplate;
	}
	
	/*@GetMapping(path="/api/service-two/message")
	public ResponseEntity<String> getMessageFromService8081()
	{
		String message = this.restTemplate.getForObject(serviceTwoUrl, String.class);
		log.info("Message returned from service two is "+message);
		return new ResponseEntity<String>(message,HttpStatus.ACCEPTED);
		
	}*/
	
	@GetMapping(path="/api/call-service-two/{id}")
	public ResponseEntity<BookResponse> get(@PathVariable long id)
	{
		log.warn("Sending rest call to "+serviceTwoUrl);
		return this.restTemplate.getForEntity(serviceTwoUrl+"/"+id, BookResponse.class);
	}

}
