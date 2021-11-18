package com.engage.service;

import java.util.Arrays;
import java.util.Collection;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engage.domain.EventInformation;
import com.engage.domain.Student;
import com.engage.domain.Event;
import com.engage.repository.EventInformationRepository;
import com.engage.repository.EventRepository;
// import com.engage.service.IService;
import com.engage.repository.StudentRepository;

@Service
public class EventInformationService implements IService<EventInformation> {
	
	@Autowired
	private EventInformationRepository eventInformationRepository;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private EventRepository eventRepository;

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
	public Collection<EventInformation> findAll() {
		return eventInformationRepository.findAll();
	}

	@Override
	public EventInformation findById(Long id) {
		return eventInformationRepository.findById(id).get();
	}

	@Override
	public EventInformation saveOrUpdate(EventInformation eventInformation) {
		return eventInformationRepository.saveAndFlush(eventInformation);
	}

	public EventInformation saveService(EventInformation eventInformation) {
		EventInformation retValue= eventInformationRepository.saveAndFlush(eventInformation);
		String courseCode=eventInformation.getCourseCode();
		Collection<Student> students=studentRepository.findAll();
		for(Student student : students){
			String[] coursesOpted=student.getCoursesOpted();
			if(Arrays.asList(coursesOpted).contains(courseCode)){
				Event event =new Event();
				event.setStudentId(student.getStudentId());
				event.setEventInfoId(retValue.getEventInfoId());
				event.setModeOpted(null);
				event.setAttendence(null);
				eventRepository.saveAndFlush(event);
			}
		}
		return retValue;
	}


	@Override
	public String deleteById(Long id) {
		JSONObject jsonObject = new JSONObject();
		try {
			eventInformationRepository.deleteById(id);
			jsonObject.put("message", "Event_Information deleted successfully");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}

}
