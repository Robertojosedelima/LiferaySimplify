package br.com.LiferaySimplify.ToDoList.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Table(name = "TB_TASK", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
@Data
public class TaskManagementModel {

}
