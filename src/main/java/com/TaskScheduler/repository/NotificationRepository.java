package com.TaskScheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TaskScheduler.dto.NotificationDTO;

public interface NotificationRepository extends JpaRepository<NotificationDTO, Long>{

}
