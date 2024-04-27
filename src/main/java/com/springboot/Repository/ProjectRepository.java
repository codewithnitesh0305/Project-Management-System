package com.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.Entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>{
	
}
