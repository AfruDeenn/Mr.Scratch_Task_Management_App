package com.TaskScheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TaskScheduler.dto.UsersDTO;

public interface UsersRepository extends JpaRepository<UsersDTO, Integer> {

}
