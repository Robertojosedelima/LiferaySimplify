package br.com.LiferaySimplify.ToDoList.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.LiferaySimplify.ToDoList.dto.TaskManagementDto;
import br.com.LiferaySimplify.ToDoList.model.TaskManagementModel;
import br.com.LiferaySimplify.ToDoList.repository.TaskManagementRepository;

@Service
public class TaskManagementService {
	@Autowired
	TaskManagementRepository taskManagementRepository;

	public ResponseEntity<String> add(TaskManagementDto taskManagementDto) {
		try {

			if (taskManagementDto.getAccomplished().equals(true)) {
				throw new IllegalArgumentException("It is not allowed to create with accomplished status.");
			}

			TaskManagementModel taskManagementModel = taskManagementRepository
					.save(taskManagementDto.toModel(taskManagementDto));
			taskManagementDto.setId(taskManagementModel.getId());
			return ResponseEntity.status(HttpStatus.CREATED).body("new task add sucessful!");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ErrorTask: " + e.getMessage());
		}
	}

	public ResponseEntity<String> update(TaskManagementDto taskManagementDto) throws IllegalAccessException {
		Optional<TaskManagementModel> taskManagementModel = taskManagementRepository
				.findById(taskManagementDto.getId());
		if (taskManagementModel.get().getAccomplished().equals(true)
				&& taskManagementDto.getAccomplished().equals(false)) {

			throw new IllegalAccessException("task already completed!");
		}

		taskManagementRepository.save(taskManagementDto.toModel(taskManagementDto));
		return ResponseEntity.status(HttpStatus.OK)
				.body("Update Task ID: " + taskManagementDto.getId() + " realizada com sucesso!");
	}

	public ResponseEntity<String> delete(TaskManagementDto taskManagementDto) {
		taskManagementRepository.deleteById(taskManagementDto.toModel(taskManagementDto).getId());
		return ResponseEntity.status(HttpStatus.OK)
				.body("Delete Task ID: " + taskManagementDto.getId() + " realizada com sucesso!");

	}

	public ResponseEntity<List<TaskManagementDto>> search() {
		// Obtém todos os modelos do repositório
		Iterable<TaskManagementModel> taskManagementModelsIterable = taskManagementRepository.findAll();

		// Converte a Iterable para uma lista
		List<TaskManagementModel> taskManagementModels = StreamSupport
				.stream(taskManagementModelsIterable.spliterator(), false).collect(Collectors.toList());

		// Converte a lista de modelos para a lista de DTOs usando o método toDto
		List<TaskManagementDto> taskManagementDtos = taskManagementModels.stream().map(TaskManagementModel::toDto)
				.collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).body(taskManagementDtos);
	}
}
