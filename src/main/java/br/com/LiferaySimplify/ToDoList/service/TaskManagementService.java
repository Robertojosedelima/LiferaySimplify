package br.com.LiferaySimplify.ToDoList.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.LiferaySimplify.ToDoList.dto.TaskManagementDto;
import br.com.LiferaySimplify.ToDoList.model.TaskManagementModel;
import br.com.LiferaySimplify.ToDoList.repository.TaskManagementRepository;

@Service
public class TaskManagementService {
	@Autowired
	TaskManagementRepository taskManagementRepository;

	public TaskManagementDto add(TaskManagementDto taskManagementDto) {

		TaskManagementModel taskManagementModel = taskManagementRepository
				.save(taskManagementDto.toModel(taskManagementDto));
		taskManagementDto.setId(taskManagementModel.getId());
		return taskManagementDto;

	}

	public TaskManagementDto update(TaskManagementDto taskManagementDto) {

		taskManagementRepository.save(taskManagementDto.toModel(taskManagementDto));
		return taskManagementDto;
	}

	public String delete(TaskManagementDto taskManagementDto) {
		taskManagementRepository.deleteById(taskManagementDto.toModel(taskManagementDto).getId());
		return "Delete Task ID: "+ taskManagementDto.getId()+" realizada com sucesso!";
		

	}

	public List<TaskManagementDto> search() {
		// Obtém todos os modelos do repositório
		Iterable<TaskManagementModel> taskManagementModelsIterable = taskManagementRepository.findAll();

		// Converte a Iterable para uma lista
		List<TaskManagementModel> taskManagementModels = StreamSupport
				.stream(taskManagementModelsIterable.spliterator(), false).collect(Collectors.toList());

		// Converte a lista de modelos para a lista de DTOs usando o método toDto
		List<TaskManagementDto> taskManagementDtos = taskManagementModels.stream().map(TaskManagementModel::toDto)
				.collect(Collectors.toList());

		return taskManagementDtos;
	}
}
