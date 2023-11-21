package com.dizitiveit.hrms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
@Entity
@Data
public class Project2 {
	@Id
	@GeneratedValue
	private Integer projectId;
	private String projectName;
}
