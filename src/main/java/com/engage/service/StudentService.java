package com.engage.service;

import java.util.Collection;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engage.domain.Student;
import com.engage.repository.StudentRepository;
// import com.engage.service.IService;

@Service
public class StudentService implements IService<Student> {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Collection<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student findById(Long id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public Student saveOrUpdate(Student student) {
		return studentRepository.saveAndFlush(student);
	}

	@Override
	public String deleteById(Long id) {
		JSONObject jsonObject = new JSONObject();
		try {
			studentRepository.deleteById(id);
			jsonObject.put("message", "Student deleted successfully");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}

}
