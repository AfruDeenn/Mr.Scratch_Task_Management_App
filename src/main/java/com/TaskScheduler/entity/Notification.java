package com.TaskScheduler.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "notifications")
public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long notificationId;

	@ManyToOne(fetch = FetchType.LAZY) // User is the owning side
	@JoinColumn(name = "user_id", nullable = false)
	private Users user;

	@Column(nullable = false)
	private String message;

	@Column(nullable = false)
	private boolean isSent;

	@Column(nullable = false)
	private LocalDateTime createdAt;

	@Column(nullable = false)
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