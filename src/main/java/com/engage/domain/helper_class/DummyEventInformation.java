package com.engage.domain.helper_class;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;


public class DummyEventInformation {

    public DummyEventInformation() {
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
	private String eventDate;
	
	@NotNull
    @Column(name="startTime", length=50, nullable=false)
	private String startTime;

    @NotNull
    @Column(name="endTime", length=50, nullable=false)
	private String endTime;

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

    public String getEventDate() {
        return this.eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public void setEndTime(String endTime) {
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

