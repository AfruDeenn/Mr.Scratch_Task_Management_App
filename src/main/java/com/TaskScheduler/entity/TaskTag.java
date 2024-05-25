package com.TaskScheduler.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "task_tags") // Optional: Specify table name explicitly
public class TaskTag {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long taskTagId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "task_id", nullable = false)
	private Task task;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tag_id", nullable = false)
	private Tag tag;

	@Override
	public String toString() {
		return "TaskTag [taskTagId=" + taskTagId + ", task=" + task + ", tag=" + tag + "]";
	}

}