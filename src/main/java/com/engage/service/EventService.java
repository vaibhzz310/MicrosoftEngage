package com.engage.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engage.domain.Event;
import com.engage.domain.EventInformation;
import com.engage.domain.helper_class.CompleteEventInformation;
import com.engage.repository.EventRepository;
//import com.engage.service.EventInformationService;
// import com.engage.service.IService;

@Service
public class EventService implements IService<Event> {
	
	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private EventInformationService eventInformationService;

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

	public Collection<CompleteEventInformation> findByStudentIdAndWeek(Long studentId,String dateSunday) {
		Date weekStart=Date.valueOf(LocalDate.parse(dateSunday).minusDays(1).toString());
		Date weekEnd=Date.valueOf(LocalDate.parse(dateSunday).plusDays(7).toString());
		Collection<Event> events = eventRepository.findByStudentId(studentId);
		Collection<CompleteEventInformation> completeEvents = new ArrayList<CompleteEventInformation>();
		for(Event event:events){
			EventInformation eventInformation = eventInformationService.findById(event.getEventInfoId());
			if(eventInformation==null)
				continue;
			Date eventDate=eventInformation.getEventDate();
			if(eventDate.after(weekStart) && eventDate.before(weekEnd)){
				CompleteEventInformation completeEvent =new CompleteEventInformation();
				completeEvent.setEventId(event.getEventId());
				completeEvent.setEventInfoId(event.getEventInfoId());
				completeEvent.setStudentId(event.getStudentId());
				completeEvent.setModeOpted(event.getModeOpted());
				completeEvent.setAttendence(event.getAttendence());
				completeEvent.setCourseCode(eventInformation.getCourseCode());
				completeEvent.setEventType(eventInformation.getEventType());
				completeEvent.setEventDate(eventInformation.getEventDate());
				completeEvent.setStartTime(eventInformation.getStartTime());
				completeEvent.setEndTime(eventInformation.getEndTime());
				completeEvent.setCapacity(eventInformation.getCapacity());
				completeEvent.setOnlineClassLink(eventInformation.getOnlineClassLink());
				completeEvents.add(completeEvent);
			}
		}
		return completeEvents;
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
