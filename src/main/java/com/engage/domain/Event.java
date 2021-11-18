package com.engage.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Event")
public class Event {

    public Event() {
    }

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long eventId;
	
	// foreign key
    @NotNull
    @Column(name="eventInfoId", length=50, nullable=false, unique=false)
	private Long eventInfoId;

    // foreign key
    @NotNull
    @Column(name="studentId", length=50, nullable=false, unique=false)
	private Long studentId;
	
    @Column(name="modeOpted", length=50, nullable=true)
	private String modeOpted;

    @Column(name="attendence", length=50, nullable=true)
	private String attendence;
	

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
	
}
