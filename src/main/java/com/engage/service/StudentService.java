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

//	private Long bookId = 100L;
//	private Map<Long, Book> bookMap = new HashMap<Long, Book>();
//
//	{
//		Book book = new Book();
//		book.setId(bookId);
//		book.setTitle("Spring Microservices in Action");
//		book.setAuthor("John Carnell");
//		book.setCoverPhotoURL(
//				"https://images-na.ssl-images-amazon.com/images/I/417zLTa1uqL._SX397_BO1,204,203,200_.jpg");
//		book.setIsbnNumber(1617293989L);
//		book.setPrice(2776.00);
//		book.setLanguage("English");
//		bookMap.put(book.getId(), book);
//	}

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
