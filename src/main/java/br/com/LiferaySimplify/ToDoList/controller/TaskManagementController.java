package br.com.LiferaySimplify.ToDoList.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.LiferaySimplify.ToDoList.dto.TaskManagementDto;
import br.com.LiferaySimplify.ToDoList.service.TaskManagementService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/task")
public class TaskManagementController {
	
	@Autowired
	TaskManagementService taskManagementService;
	
	@PostMapping
	public TaskManagementDto addTask(@RequestBody @Valid TaskManagementDto taskManagementDto) {

		return taskManagementService.add(taskManagementDto);

	}
	@PutMapping
	public TaskManagementDto updateTask(@RequestBody @Valid TaskManagementDto taskManagementDto) {

		return taskManagementService.update(taskManagementDto);

	}
	@DeleteMapping
	public String deleteTask(@RequestBody @Valid TaskManagementDto taskManagementDto) {

		return taskManagementService.delete(taskManagementDto);

	}
	@GetMapping
	public List<TaskManagementDto> searchTask() {

		return taskManagementService.search();

	}

}
