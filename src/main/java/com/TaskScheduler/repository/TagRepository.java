package com.TaskScheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TaskScheduler.dto.TagDTO;

public interface TagRepository extends JpaRepository<TagDTO,Long>{

}
