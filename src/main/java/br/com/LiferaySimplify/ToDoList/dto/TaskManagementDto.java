package br.com.LiferaySimplify.ToDoList.dto;

import br.com.LiferaySimplify.ToDoList.Enums.PriorityEnum;
import br.com.LiferaySimplify.ToDoList.model.TaskManagementModel;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TaskManagementDto {
	private Long id; 
	private String name;
	@Size(min = 10, message = "A descrição deve ter pelo menos 10 caracteres")
	private String description;
	private Boolean accomplished;
	private PriorityEnum priority;

	public TaskManagementModel toModel(TaskManagementDto taskManagementDto) {
		TaskManagementModel taskManagementModel = new TaskManagementModel();
		taskManagementModel.setId(this.id);
		taskManagementModel.setName(this.name);
		taskManagementModel.setDescription(this.description);
		taskManagementModel.setAccomplished(this.accomplished);
		taskManagementModel.setPriority(this.priority);
		return taskManagementModel;

	}

}
