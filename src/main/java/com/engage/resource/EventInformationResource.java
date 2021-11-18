package com.engage.resource;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.engage.domain.EventInformation;
import com.engage.service.EventInformationService;
//import com.engage.resource.Resource;

@CrossOrigin()
@RestController
@RequestMapping("/eventInformation")
public class EventInformationResource implements Resource<EventInformation> {
	
	@Autowired
	private EventInformationService eventInformationService;

	@Override
	public ResponseEntity<Collection<EventInformation>> findAll() {
		return new ResponseEntity<>(eventInformationService.findAll(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<EventInformation> findById(Long id) {
		return new ResponseEntity<>(eventInformationService.findById(id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<EventInformation> save(EventInformation eventInformation) {
		return new ResponseEntity<>(eventInformationService.saveService(eventInformation), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<EventInformation> update(EventInformation eventInformation) {
		return new ResponseEntity<>(eventInformationService.saveOrUpdate(eventInformation), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> deleteById(Long id) {
		return new ResponseEntity<>(eventInformationService.deleteById(id), HttpStatus.OK);
	}

	@GetMapping("/generate_sample")
	public void generateSampleData(){

	}
}

//Requests
// {

// }