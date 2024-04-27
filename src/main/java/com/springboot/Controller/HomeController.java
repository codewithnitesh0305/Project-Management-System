package com.springboot.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.springboot.Entity.Project;
import com.springboot.Repository.ProjectRepository;
import com.springboot.Service.ProjectServiceImp;


import jakarta.servlet.http.HttpSession;



@Controller
public class HomeController {

	@Autowired
	private ProjectServiceImp projectServiceImp;
	
	@GetMapping("/")
	public String index(Model model) {
		List<Project> list = projectServiceImp.getAllProject();
		model.addAttribute("projectDetails",list);
		return "index";
	}
	
	@GetMapping("/edit/{id}")
	public String edit_employee(@PathVariable int id, Model model) {
		//System.out.println(id);
		Project project = projectServiceImp.getProjectById(id);
		model.addAttribute("projectDetails",project);
		return "employee_edit";
	}
	
	@GetMapping("/save")
	public String save_employee() {
		return "employee_save";
	}
	//Stored Project Details in the database
	@PostMapping("/saveProject")
	public String saveProject(@ModelAttribute Project project , HttpSession session) {
		
		if(project.getName().equals("") || project.getManager().equals("") || project.getDescription().equals("") || project.getStartDate().equals("") || project.getEndDate().equals("")) {
			session.setAttribute("message", "Please fill properly..");
		}else {
			Project p =projectServiceImp.saveProject(project);
			if(p != null) {
				session.setAttribute("message", "Data Save Successfully");
			}else {
				session.setAttribute("message", "Something went wrong...");
			}
		}
		return "redirect:/save";
	}
	//Update Project Details
	@PostMapping("/updateProject")
	public String updateProject(@ModelAttribute Project project , HttpSession session) {
		
		if(project.getName().equals("") || project.getManager().equals("") || project.getDescription().equals("") || project.getStartDate().equals("") || project.getEndDate().equals("")) {
			session.setAttribute("message", "Please fill properly..");
		}else {
			Project p =projectServiceImp.saveProject(project);
			if(p != null) {
				session.setAttribute("message", "Update Successfully");
			}else {
				session.setAttribute("message", "Something went wrong...");
			}
		}
		return "redirect:/";
	}
	
	@GetMapping("/deleteProject/{id}")
	public String deleteProject(@PathVariable int id , HttpSession session) {
		boolean f = projectServiceImp.deleteProject(id);
		if(f) {
			session.setAttribute("message", "Delete Successfully");
		}else {
			session.setAttribute("message", "Something went wrong....");
		}
		return "redirect:/";
	}
	
}
