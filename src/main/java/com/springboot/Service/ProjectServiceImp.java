package com.springboot.Service;

import java.util.List;

import org.aspectj.weaver.patterns.PerObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.springboot.Entity.Project;
import com.springboot.Repository.ProjectRepository;

import jakarta.servlet.http.HttpSession;
@Service
public class ProjectServiceImp implements ProjectService{

	@Autowired
	private ProjectRepository projectRepository;
	
	@Override
	public void removeSessionMessage() {
		// TODO Auto-generated method stub
		HttpSession session = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
		session.removeAttribute("message");
	}

	@Override
	public Project saveProject(Project project) {
		// TODO Auto-generated method stub
		Project p = projectRepository.save(project);
		return p;
	}

	@Override
	public List<Project> getAllProject() {
		// TODO Auto-generated method stub
		List<Project> list = projectRepository.findAll();
		return list;
	}

	@Override
	public Project getProjectById(int id) {
		// TODO Auto-generated method stub
		return projectRepository.findById(id).get();
	}

	@Override
	public boolean deleteProject(int id) {
		// TODO Auto-generated method stub
		Project project = projectRepository.findById(id).get();
		if(project != null) {
			 projectRepository.delete(project);
			 return true;
		}
		return false;
	}

}
