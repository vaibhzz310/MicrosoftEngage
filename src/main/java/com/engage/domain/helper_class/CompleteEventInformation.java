package com.engage.domain.helper_class;

import java.sql.Date;
import java.sql.Time;

public class CompleteEventInformation {

    public CompleteEventInformation() {
    }

	private Long eventId;

	private Long eventInfoId;

	private Long studentId;
	
	private String modeOpted;

	private String attendence;

	private String courseCode;
	
	private String eventType;
	
	private Date eventDate;
	
	private Time startTime;

	private Time endTime;

	private Integer capacity;
	
	private String onlineClassLink;


    public Long getEventId() {
        return this.eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getEventInfoId() {
        return this.eventInfoId;
    }

    public void setEventInfoId(Long eventInfoId) {
        this.eventInfoId = eventInfoId;
    }

    public Long getStudentId() {
        return this.studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getModeOpted() {
        return this.modeOpted;
    }

    public void setModeOpted(String modeOpted) {
        this.modeOpted = modeOpted;
    }

    public String getAttendence() {
        return this.attendence;
    }

    public void setAttendence(String attendence) {
        this.attendence = attendence;
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
