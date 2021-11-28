package com.engage.domain;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="EventInformation")
public class EventInformation {

    public EventInformation() {
    }

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long eventInfoId;
	
	// foreign key
    @NotNull
    @Column(name="courseCode", length=50, nullable=false, unique=false)
	private String courseCode;
	
	@NotNull
    @Column(name="eventType", length=50, nullable=false)
	private String eventType;
	
	@NotNull
    @Column(name="eventDate", length=50, nullable=false)
    @DateTimeFormat(pattern="dd/MM/yyyy")
	private Date eventDate;
	
	@NotNull
    @Column(name="startTime", length=50, nullable=false)
	private Time startTime;

    @NotNull
    @Column(name="endTime", length=50, nullable=false)
	private Time endTime;

	@NotNull
    @Column(name="capacity", length=50, nullable=false)
	private Integer capacity;
	
	@NotNull
    @Column(name="onlineClassLink", length=50, nullable=false)
	private String onlineClassLink;


    public Long getEventInfoId() {
        return this.eventInfoId;
    }

    public void setEventInfoId(Long eventInfoId) {
        this.eventInfoId = eventInfoId;
    }

    public String getCourseCode() {
        return this.courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getEventType() {
        return this.eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Date getEventDate() {
        return this.eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Time getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public Integer getCapacity() {
        return this.capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getOnlineClassLink() {
        return this.onlineClassLink;
    }

    public void setOnlineClassLink(String onlineClassLink) {
        this.onlineClassLink = onlineClassLink;
    }
	

}

// Sample JSON
// [
//   {
//     "eventInfoId": 24,
//     "courseCode": "Algorithms",
//     "eventType": "Lecture",
//     "eventDate": "2021-11-15",
//     "startTime": "12:00:00",
//     "endTime": "13:00:00",
//     "capacity": 50,
//     "onlineClassLink": "https://meet.google.com/uoe-cnxz-tft"
//   },
//   {
//     "eventInfoId": 20,
//     "courseCode": "Analog",
//     "eventType": "Tutorial",
//     "eventDate": "2021-11-16",
//     "startTime": "14:00:00",
//     "endTime": "15:00:00",
//     "capacity": 20,
//     "onlineClassLink": "https://meet.google.com/uoe-cnxz-tft"
//   },
//   {
//     "eventInfoId": 18,
//     "courseCode": "Analog",
//     "eventType": "Lecture",
//     "eventDate": "2021-11-16",
//     "startTime": "12:00:00",
//     "endTime": "13:00:00",
//     "capacity": 55,
//     "onlineClassLink": "https://meet.google.com/uoe-cnxz-tft"
//   },
//   {
//     "eventInfoId": 5,
//     "courseCode": "Algorithms",
//     "eventType": "Lecture",
//     "eventDate": "2021-11-17",
//     "startTime": "11:00:00",
//     "endTime": "12:00:00",
//     "capacity": 50,
//     "onlineClassLink": "https://meet.google.com/uoe-cnxz-tft"
//   },
//   {
//     "eventInfoId": 16,
//     "courseCode": "Sociology",
//     "eventType": "Lecture",
//     "eventDate": "2021-11-17",
//     "startTime": "16:00:00",
//     "endTime": "17:00:00",
//     "capacity": 30,
//     "onlineClassLink": "https://meet.google.com/uoe-cnxz-tft"
//   },
//   {
//     "eventInfoId": 12,
//     "courseCode": "Economics",
//     "eventType": "Lecture",
//     "eventDate": "2021-11-17",
//     "startTime": "15:00:00",
//     "endTime": "16:00:00",
//     "capacity": 25,
//     "onlineClassLink": "https://meet.google.com/uoe-cnxz-tft"
//   },
//   {
//     "eventInfoId": 56,
//     "courseCode": "Neural Networks",
//     "eventType": "Lecture",
//     "eventDate": "2021-11-22",
//     "startTime": "11:00:00",
//     "endTime": "12:00:00",
//     "capacity": 55,
//     "onlineClassLink": "https://meet.google.com/uoe-cnxz-tft"
//   },
//   {
//     "eventInfoId": 59,
//     "courseCode": "Wireless",
//     "eventType": "Lecture",
//     "eventDate": "2021-11-23",
//     "startTime": "09:00:00",
//     "endTime": "10:00:00",
//     "capacity": 51,
//     "onlineClassLink": "https://meet.google.com/uoe-cnxz-tft"
//   },
//   {
//     "eventInfoId": 49,
//     "courseCode": "Mathematics",
//     "eventType": "Lecture",
//     "eventDate": "2021-11-24",
//     "startTime": "15:00:00",
//     "endTime": "16:00:00",
//     "capacity": 30,
//     "onlineClassLink": "https://meet.google.com/uoe-cnxz-tft"
//   },
//   {
//     "eventInfoId": 28,
//     "courseCode": "Algorithms",
//     "eventType": "Lecture",
//     "eventDate": "2021-11-25",
//     "startTime": "12:00:00",
//     "endTime": "13:00:00",
//     "capacity": 50,
//     "onlineClassLink": "https://meet.google.com/uoe-cnxz-tft"
//   },
//   {
//     "eventInfoId": 70,
//     "courseCode": "Mathematics",
//     "eventType": "Lecture",
//     "eventDate": "2021-11-26",
//     "startTime": "11:00:00",
//     "endTime": "12:00:00",
//     "capacity": 20,
//     "onlineClassLink": "https://meet.google.com/uoe-cnxz-tft"
//   },
//   {
//     "eventInfoId": 53,
//     "courseCode": "English",
//     "eventType": "Lecture",
//     "eventDate": "2021-11-27",
//     "startTime": "16:00:00",
//     "endTime": "17:00:00",
//     "capacity": 30,
//     "onlineClassLink": "https://meet.google.com/uoe-cnxz-tft"
//   },
//   {
//     "eventInfoId": 62,
//     "courseCode": "Mathematics",
//     "eventType": "Lecture",
//     "eventDate": "2021-11-27",
//     "startTime": "11:00:00",
//     "endTime": "12:00:00",
//     "capacity": 30,
//     "onlineClassLink": "https://meet.google.com/uoe-cnxz-tft"
//   },
//   {
//     "eventInfoId": 43,
//     "courseCode": "Mathematics",
//     "eventType": "Lecture",
//     "eventDate": "2021-11-27",
//     "startTime": "08:00:00",
//     "endTime": "09:00:00",
//     "capacity": 35,
//     "onlineClassLink": "https://meet.google.com/uoe-cnxz-tft"
//   },
//   {
//     "eventInfoId": 66,
//     "courseCode": "Mathematics",
//     "eventType": "Lecture",
//     "eventDate": "2021-11-29",
//     "startTime": "10:00:00",
//     "endTime": "11:00:00",
//     "capacity": 45,
//     "onlineClassLink": "https://meet.google.com/uoe-cnxz-tft"
//   }
// ]