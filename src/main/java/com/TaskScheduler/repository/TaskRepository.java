package com.TaskScheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TaskScheduler.dto.TaskDTO;

public interface TaskRepository extends JpaRepository<TaskDTO, Long> {

}
