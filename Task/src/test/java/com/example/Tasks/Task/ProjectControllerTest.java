package com.example.Tasks.Task;

import com.example.Tasks.Task.Controllers.ProjectController;
import com.example.Tasks.Task.Models.Projects;
import com.example.Tasks.Task.Services.ProjectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ProjectControllerTest {

    @Mock
    private ProjectService projectService;

    @InjectMocks
    private ProjectController projectController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateProject() {
        Projects project = new Projects();
        project.setProject_name("New Project");

        when(projectService.createProject(any(Projects.class))).thenReturn(project);

        ResponseEntity<Projects> response = projectController.createProject(project);

        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("New Project", response.getBody().getProject_name());

        verify(projectService, times(1)).createProject(project);
    }

    @Test
    public void testUpdateProject() {
        Projects project = new Projects();
        project.setProject_name("Updated Project");

        when(projectService.updateProject(any(Projects.class))).thenReturn(project);

        ResponseEntity<Projects> response = projectController.updateProject(project);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Updated Project", response.getBody().getProject_name());

        verify(projectService, times(1)).updateProject(project);
    }

    @Test
    public void testDeleteProject() {
        Projects project = new Projects();
        project.setProject_name("Project to Delete");

        when(projectService.deleteProject(anyInt())).thenReturn(project);

        ResponseEntity<Projects> response = projectController.deleteProject(1);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Project to Delete", response.getBody().getProject_name());

        verify(projectService, times(1)).deleteProject(1);
    }

    @Test
    public void testGetAllProjects() {
        List<Projects> projectsList = new ArrayList<>();
        Projects project1 = new Projects();
        project1.setProject_name("Project 1");
        Projects project2 = new Projects();
        project2.setProject_name("Project 2");
        projectsList.add(project1);
        projectsList.add(project2);

        when(projectService.getallProjects()).thenReturn(projectsList);

        ResponseEntity<List<Projects>> response = projectController.getallProjects();

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
        assertEquals("Project 1", response.getBody().get(0).getProject_name());
        assertEquals("Project 2", response.getBody().get(1).getProject_name());

        verify(projectService, times(1)).getallProjects();
    }
}

