package com.engage.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.engage.domain.EventInformation;
import com.engage.domain.Student;
import com.engage.domain.Event;
import com.engage.repository.EventInformationRepository;
import com.engage.repository.EventRepository;
// import com.engage.service.IService;
import com.engage.repository.StudentRepository;
//import com.engage.service.Utilities;

@Service
public class EventInformationService implements IService<EventInformation> {
	
	@Autowired
	private EventInformationRepository eventInformationRepository;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private EventRepository eventRepository;

	Utilities utilities=new Utilities();

	@Override
	public Collection<EventInformation> findAll() {
		return eventInformationRepository.findAll(Sort.by("eventDate"));
	}

	@Override
	public EventInformation findById(Long id) {
		Optional<EventInformation> result = eventInformationRepository.findById(id);
		if(result.isPresent())
			return result.get();
		else
			return null;
	}

	@Override
	public EventInformation saveOrUpdate(EventInformation eventInformation) {
		return eventInformationRepository.saveAndFlush(eventInformation);
	}

	public EventInformation saveService(EventInformation eventInformation) throws AddressException, MessagingException, IOException {
		
		//generate class link
		String onlineClassLink=utilities.generateMeetLink();
		eventInformation.setOnlineClassLink(onlineClassLink);

		//send mail to the teacher with mail link
		//sendmail(onlineClassLink,"");

		EventInformation retValue= eventInformationRepository.saveAndFlush(eventInformation);
		String courseCode=eventInformation.getCourseCode();
		Collection<Student> students=studentRepository.findAll();
		for(Student student : students){
			String[] coursesOpted=student.getCoursesOpted();
			if(Arrays.asList(coursesOpted).contains(courseCode)){

				//sending email to all students
				//utilities.sendmail(onlineClassLink,student.getEmailId(),student.getName(),retValue.getEventDate().toString(),retValue.getStartTime().toString(),retValue.getEndTime().toString(),retValue.getCourseCode());

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
	public String deleteById(Long eventInfoId) {
		JSONObject jsonObject = new JSONObject();
		try {

			//Deleted linked events from Event table which have eventInfoId as same as that of eventInformation to be deleted.
			Collection<Event> events=eventRepository.findByEventInfoId(eventInfoId);
			for(Event event:events){
				eventRepository.deleteById(event.getEventId());
			}

			eventInformationRepository.deleteById(eventInfoId);
			jsonObject.put("message", "Event_Information deleted successfully");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	} 

}
