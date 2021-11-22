package com.engage.resource;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.engage.domain.Event;
import com.engage.service.EventService;
//import com.engage.resource.Resource;

@CrossOrigin()
@RestController
@RequestMapping("/event")
public class EventResource {
	
	@Autowired
	private EventService eventService;

	@GetMapping
	public ResponseEntity<Collection<Event>> findAll() {
		return new ResponseEntity<>(eventService.findAll(), HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<Event> findById(@PathVariable Long id) {
		return new ResponseEntity<>(eventService.findById(id), HttpStatus.OK);
	}

	@GetMapping("student"+"{studentId}")
	public ResponseEntity<Collection<Event>> findByStudentId(@PathVariable Long studentId) {
		return new ResponseEntity<>(eventService.findByStudentId(studentId), HttpStatus.OK);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Event> save(@RequestBody Event event) {
		return new ResponseEntity<>(eventService.saveOrUpdate(event), HttpStatus.CREATED);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Event> update(@RequestBody Event event) {
		return new ResponseEntity<>(eventService.saveOrUpdate(event), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		return new ResponseEntity<>(eventService.deleteById(id), HttpStatus.OK);
	}

}


//Requests
// {

// }