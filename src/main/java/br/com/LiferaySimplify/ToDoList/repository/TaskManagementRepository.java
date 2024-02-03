package br.com.LiferaySimplify.ToDoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.LiferaySimplify.ToDoList.model.TaskManagementModel;

public interface TaskManagementRepository extends JpaRepository<TaskManagementModel, Long>{

}
