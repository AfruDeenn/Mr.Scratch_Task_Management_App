package com.TaskScheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TaskScheduler.dto.ScheduleDTO;

public interface ScheduleRepository extends JpaRepository<ScheduleDTO, Long> {

}
