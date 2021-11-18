package com.engage.resource;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.engage.domain.Student;
//import com.engage.resource.Resource;
import com.engage.service.IService;

@CrossOrigin()
@RestController
@RequestMapping("/student")
public class StudentResource implements Resource<Student> {
	
	@Autowired
	private IService<Student> studentService;

	@Override
	public ResponseEntity<Collection<Student>> findAll() {
		return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Student> findById(Long id) {
		return new ResponseEntity<>(studentService.findById(id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Student> save(Student student) {
		return new ResponseEntity<>(studentService.saveOrUpdate(student), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Student> update(Student student) {
		return new ResponseEntity<>(studentService.saveOrUpdate(student), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> deleteById(Long id) {
		return new ResponseEntity<>(studentService.deleteById(id), HttpStatus.OK);
	}

	@GetMapping("/generate_sample")
	public ResponseEntity<String> generateSampleData(){

		return new ResponseEntity<>("Sample data generated successfully", HttpStatus.CREATED);
	}

}



//Requests
// {

// }