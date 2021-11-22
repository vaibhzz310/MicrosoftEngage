package com.engage.service;

import java.util.Collection;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engage.domain.Event;
import com.engage.repository.EventRepository;
// import com.engage.service.IService;

@Service
public class EventService implements IService<Event> {
	
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
	public Collection<Event> findAll() {
		return eventRepository.findAll();
	}

	@Override
	public Event findById(Long id) {
		return eventRepository.findById(id).get();
	}

	public Collection<Event> findByStudentId(Long studentId) {
		return eventRepository.findByStudentId(studentId);
	}

	@Override
	public Event saveOrUpdate(Event event) {
		return eventRepository.saveAndFlush(event);
	}

	@Override
	public String deleteById(Long id) {
		JSONObject jsonObject = new JSONObject();
		try {
			eventRepository.deleteById(id);
			jsonObject.put("message", "Event deleted successfully");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}

}
