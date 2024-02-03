package br.com.LiferaySimplify.ToDoList.dto;

import br.com.LiferaySimplify.ToDoList.Enums.PriorityEnum;
import lombok.Data;

@Data
public class TaskManagementDto {
	private String name;
	private String description;
	private Boolean accomplished;
	private PriorityEnum priority;

}
