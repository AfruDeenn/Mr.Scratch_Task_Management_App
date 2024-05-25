package com.TaskScheduler.dto;

import java.time.LocalDateTime;

import org.springframework.data.annotation.LastModifiedDate;

import com.TaskScheduler.entity.Task;
import com.TaskScheduler.entity.Users;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CommentDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long commentId;

	@ManyToOne(fetch = FetchType.LAZY) // Task is the owning side
	@JoinColumn(name = "task_id", nullable = false)
	private Task task;

	@ManyToOne(fetch = FetchType.LAZY) // User is the owning side (optional)
	@JoinColumn(name = "user_id")
	private Users user;
	@NotBlank(message = "Message cannot be blank")
	@Size(min = 3, max = 80, message = "Description must be between 3 and 80 characters")
	private String content;

	private LocalDateTime createdAt;

	@LastModifiedDate
	private LocalDateTime updatedAt;

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", task=" + task + ", user=" + user + ", content=" + content
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

}
