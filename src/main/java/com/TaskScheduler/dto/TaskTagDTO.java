package com.TaskScheduler.dto;

import com.TaskScheduler.entity.Tag;
import com.TaskScheduler.entity.Task;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

public class TaskTagDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long taskTagId;

	@NotBlank(message = "Task cannot be blank")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "task_id", nullable = false)
	private Task task;

	@NotBlank(message = "Tag cannot be blank")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tag_id", nullable = false)
	private Tag tag;

	@Override
	public String toString() {
		return "TaskTag [taskTagId=" + taskTagId + ", task=" + task + ", tag=" + tag + "]";
	}

}
