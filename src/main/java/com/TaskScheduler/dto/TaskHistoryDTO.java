package com.TaskScheduler.dto;

import java.time.LocalDateTime;

import com.TaskScheduler.entity.Task;
import com.TaskScheduler.entity.Users;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TaskHistoryDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long historyId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "task_id", nullable = false)
	private Task task;

	@ManyToOne(fetch = FetchType.LAZY) // Optional: User might not be available for all changes
	@JoinColumn(name = "changed_by")
	private Users changedBy;

	@Column(nullable = false)
	@NotBlank(message = "Description cannot be blank")
	@Size(min = 3, max = 50, message = "Description must be between 3 and 80 characters")
	private String changeDescription;

	@Column(nullable = false)
	private LocalDateTime changedAt;

	@Override
	public String toString() {
		return "TaskHistory [historyId=" + historyId + ", task=" + task + ", changedBy=" + changedBy
				+ ", changeDescription=" + changeDescription + ", changedAt=" + changedAt + "]";
	}

}
