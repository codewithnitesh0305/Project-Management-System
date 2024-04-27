package com.springboot.Service;

import java.util.List;

import com.springboot.Entity.Project;

public interface ProjectService {

	public Project saveProject(Project project);
	public List<Project> getAllProject();
	public Project getProjectById(int id);
	public boolean deleteProject(int id);
	public void removeSessionMessage();
}
