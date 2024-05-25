package com.TaskScheduler.entity;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.data.annotation.LastModifiedDate;

import com.TaskScheduler.enums.TaskStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long taskId;

	@Column(nullable = false)
	private String title;

	@Column(length = 1000) // Optional: Specify maximum length for description
	private String description;

	@Column(nullable = false)
	private LocalDateTime dueDate;

	@Enumerated(EnumType.STRING) // Optional: Define enum behavior for status
	@Column(nullable = false)
	private TaskStatus status;

	@ManyToOne(fetch = FetchType.LAZY) // User is the owning side
	@JoinColumn(name = "user_id", nullable = false)
	private Users user;

	@Column(nullable = false)
	private LocalDateTime createdAt;

	@Column(nullable = false)
	@LastModifiedDate
	private LocalDateTime updatedAt;

	@ManyToMany(cascade = CascadeType.PERSIST) // Persist tags when saving a task
	@JoinTable(name = "task_tag", joinColumns = @JoinColumn(name = "task_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
	private Set<Tag> tags; // Set to avoid duplicates

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", title=" + title + ", description=" + description + ", dueDate=" + dueDate
				+ ", status=" + status + ", user=" + user + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", tags=" + tags + "]";
	}

}