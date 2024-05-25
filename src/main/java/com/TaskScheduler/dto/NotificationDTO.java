package com.TaskScheduler.dto;

import java.time.LocalDateTime;

import org.springframework.data.annotation.LastModifiedDate;

import com.TaskScheduler.entity.TaskHistory;
import com.TaskScheduler.entity.Users;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class NotificationDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long notificationId;

	@ManyToOne(fetch = FetchType.LAZY) // User is the owning side
	@JoinColumn(name = "user_id", nullable = false)
	private Users user;
	@NotBlank(message = "Message cannot be blank")
	@Size(min = 2, max = 1000, message = "Description must be between 2 and 1000 characters")
	private String message;

	private boolean isSent;

	private LocalDateTime createdAt;

	@LastModifiedDate
	private LocalDateTime updatedAt;

	@OneToOne // One notification can have one related task history
	private TaskHistory taskHistory;

	@Override
	public String toString() {
		return "Notification [notificationId=" + notificationId + ", user=" + user + ", message=" + message
				+ ", isSent=" + isSent + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", taskHistory="
				+ taskHistory + "]";
	}
}
