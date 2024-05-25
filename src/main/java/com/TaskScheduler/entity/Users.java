package com.TaskScheduler.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@Column(unique = false, name = "firstname")
	private String firstName;
	@Column(unique = false, name = "lastname")
	private String lastName;
	@Column(unique = true)
	private String email;
	@Column(unique = true)
	private String phoneNumber;
	@Column(nullable = false)
	private String passwordHash;
	@Column(nullable = false)
	private LocalDateTime createdAt;
	@Column(nullable = false)
	@LastModifiedDate
	private LocalDateTime updatedAt;

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", lastName=" + lastName + ", firstName=" + firstName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", passwordHash=" + passwordHash + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}

}
