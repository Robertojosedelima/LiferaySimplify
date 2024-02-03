package br.com.LiferaySimplify.ToDoList.model;

import java.io.Serializable;

import br.com.LiferaySimplify.ToDoList.Enums.PriorityEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Table(name = "TB_TASK", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
@Data
public class TaskManagementModel implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // auto generate id
	private String name;
	private String description;
	private Boolean accomplished;
	private PriorityEnum priority;

}
