package com.engage.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Course")
public class Course {

    public Course() {
    }

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long courseId;
	
	@NotNull
    @Column(name="courseCode", length=50, nullable=false , unique=true)
	private String courseCode;

    @NotNull
    @Column(name="courseCoordinator", length=50, nullable=false)
	private String courseCoordinator;

    @NotNull
    @Column(name="department", length=50, nullable=false)
	private String department;


    public Long getCourseId() {
        return this.courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseCode() {
        return this.courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseCoordinator() {
        return this.courseCoordinator;
    }

    public void setCourseCoordinator(String courseCoordinator) {
        this.courseCoordinator = courseCoordinator;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

}
