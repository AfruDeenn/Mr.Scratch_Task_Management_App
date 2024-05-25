package com.TaskScheduler.dto;

import java.time.LocalDateTime;

import org.springframework.data.annotation.LastModifiedDate;

import com.TaskScheduler.entity.Task;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class ScheduleDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long scheduleId;

	@ManyToOne(fetch = FetchType.LAZY) // Task is the owning side
	@JoinColumn(name = "task_id", nullable = false)
	private Task task;

	@Column(nullable = false)
	private LocalDateTime scheduledTime;

	@Column(nullable = false)
	private boolean isRecurring;

	@Column(length = 50) // Optional: Specify maximum length for recurrence pattern
	private String recurrencePattern; // Consider using a dedicated enum for common patterns

	@Column(nullable = false)
	private LocalDateTime createdAt;

	@Column(nullable = false)
	@LastModifiedDate
	private LocalDateTime updatedAt;

	@Override
	public String toString() {
		return "Schedule [scheduleId=" + scheduleId + ", task=" + task + ", scheduledTime=" + scheduledTime
				+ ", isRecurring=" + isRecurring + ", recurrencePattern=" + recurrencePattern + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}

}
