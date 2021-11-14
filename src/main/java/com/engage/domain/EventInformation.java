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
    @Column(name="courseId", length=50, nullable=false, unique=false)
	private Long courseId;
	
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

    public Long getCourseId() {
        return this.courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
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
