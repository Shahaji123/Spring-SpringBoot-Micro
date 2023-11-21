package com.dizitiveit.hrms.service;

import java.util.List;

import com.dizitiveit.hrms.model.Project;

public interface IProject {
	public String createProject(Project project);
	public String getById(int projectId);
	public List<Project> getAllProject();
	
	public String updateEmp(Project project,int projectId );
}
