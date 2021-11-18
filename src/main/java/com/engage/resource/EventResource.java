package com.engage.resource;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.engage.domain.Event;
//import com.engage.resource.Resource;
import com.engage.service.IService;

@CrossOrigin()
@RestController
@RequestMapping("/event")
public class EventResource implements Resource<Event> {
	
	@Autowired
	private IService<Event> eventService;

	@Override
	public ResponseEntity<Collection<Event>> findAll() {
		return new ResponseEntity<>(eventService.findAll(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Event> findById(Long id) {
		return new ResponseEntity<>(eventService.findById(id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Event> save(Event event) {
		return new ResponseEntity<>(eventService.saveOrUpdate(event), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Event> update(Event event) {
		return new ResponseEntity<>(eventService.saveOrUpdate(event), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> deleteById(Long id) {
		return new ResponseEntity<>(eventService.deleteById(id), HttpStatus.OK);
	}

}


//Requests
// {

// }