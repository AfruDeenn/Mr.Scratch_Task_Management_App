package com.TaskScheduler.entity;

import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "task_history")
public class TaskHistory {

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
	private String changeDescription;

	@Column(nullable = false)
	private LocalDateTime changedAt;

	@Override
	public String toString() {
		return "TaskHistory [historyId=" + historyId + ", task=" + task + ", changedBy=" + changedBy
				+ ", changeDescription=" + changeDescription + ", changedAt=" + changedAt + "]";
	}

}