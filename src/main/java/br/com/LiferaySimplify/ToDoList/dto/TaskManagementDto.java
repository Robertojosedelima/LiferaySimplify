package br.com.LiferaySimplify.ToDoList.dto;

import br.com.LiferaySimplify.ToDoList.Enums.PriorityEnum;
import br.com.LiferaySimplify.ToDoList.model.TaskManagementModel;
import lombok.Data;

@Data
public class TaskManagementDto {
	private Long id; 
	private String name;
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
