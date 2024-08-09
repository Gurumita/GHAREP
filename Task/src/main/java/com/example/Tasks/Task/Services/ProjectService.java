package com.example.Tasks.Task.Services;

import com.example.Tasks.Task.DAO.ProjectRepository;
import com.example.Tasks.Task.Models.Projects;
import com.example.Tasks.Task.Models.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Projects createProject(Projects projects) {
        projectRepository.save(projects);
        return projects;

    }
    public Optional<Projects> getProjectsbyID(int id){
        return projectRepository.findById(id);
    }
    public Projects deleteProject(int id){
        Optional<Projects> tasks= getProjectsbyID(id);
        projectRepository.deleteById(id);
        return tasks.get();
    }
    public List<Projects> getallProjects(){
        return projectRepository.findAll();
    }

    public Projects updateProject(Projects projects){
        projectRepository.save(projects);
        return projects;
    }

}
