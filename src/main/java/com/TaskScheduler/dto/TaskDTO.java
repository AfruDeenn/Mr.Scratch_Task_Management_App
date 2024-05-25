package com.TaskScheduler.dto;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.data.annotation.LastModifiedDate;

import com.TaskScheduler.entity.Tag;
import com.TaskScheduler.entity.Users;
import com.TaskScheduler.enums.TaskStatus;

import jakarta.persistence.CascadeType;
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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TaskDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long taskId;
	@NotBlank(message = "Title cannot be blank")
	@Size(min = 3, max = 50, message = "Title must be between 3 and 50 characters")
	private String title;
	@NotBlank(message = "Description cannot be blank")
	@Size(min = 3, max = 80, message = "Description must be between 3 and 80 characters")
	private String description;

	private LocalDateTime dueDate;

	@Enumerated(EnumType.STRING) // Optional: Define enum behavior for status
	private TaskStatus status;

	@ManyToOne(fetch = FetchType.LAZY) // User is the owning side
	@JoinColumn(name = "user_id", nullable = false)
	private Users user;

	private LocalDateTime createdAt;

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
