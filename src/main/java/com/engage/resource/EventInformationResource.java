package com.engage.resource;

import java.sql.Date;
import java.sql.Time;
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

import com.engage.domain.EventInformation;
import com.engage.domain.helper_class.DummyEventInformation;
import com.engage.service.EventInformationService;
//import com.engage.resource.Resource;

@CrossOrigin()
@RestController
@RequestMapping("/eventInformation")
public class EventInformationResource  {
	
	@Autowired
	private EventInformationService eventInformationService;

	@GetMapping
	public ResponseEntity<Collection<EventInformation>> findAll() {
		return new ResponseEntity<>(eventInformationService.findAll(), HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<EventInformation> findById(@PathVariable Long id) {
		return new ResponseEntity<>(eventInformationService.findById(id), HttpStatus.OK);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EventInformation> save(@RequestBody DummyEventInformation dummyEventInformation) {
		EventInformation eventInformation = new EventInformation();
		eventInformation.setCourseCode(dummyEventInformation.getCourseCode());
		eventInformation.setEventType(dummyEventInformation.getEventType());
		eventInformation.setEventDate(Date.valueOf(dummyEventInformation.getEventDate()));
		eventInformation.setStartTime(Time.valueOf(dummyEventInformation.getStartTime()));
		eventInformation.setEndTime(Time.valueOf(dummyEventInformation.getEndTime()));
		eventInformation.setCapacity(dummyEventInformation.getCapacity());
		eventInformation.setOnlineClassLink(dummyEventInformation.getOnlineClassLink());
		return new ResponseEntity<>(eventInformationService.saveService(eventInformation), HttpStatus.CREATED);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EventInformation> update(@RequestBody EventInformation eventInformation) {
		return new ResponseEntity<>(eventInformationService.saveOrUpdate(eventInformation), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		return new ResponseEntity<>(eventInformationService.deleteById(id), HttpStatus.OK);
	}

	@GetMapping("/generate_sample")
	public void generateSampleData(){

	}
}

//Requests
// {

// }