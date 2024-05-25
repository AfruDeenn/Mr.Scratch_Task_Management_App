package com.TaskScheduler.dto;

import java.time.LocalDateTime;

import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UsersDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@NotBlank(message = "First name cannot be blank")
	@Size(min = 3, max = 50, message = "First name must be between 3 and 50 characters")
	private String firstName;
	@NotBlank(message = "Last name cannot be blank")
	@Size(min = 3, max = 50, message = "Last name must be between 3 and 50 characters")
	private String lastName;
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@([a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$", message = "Invalid email address")
	@Email(message = "Invalid email address")
	private String email;
	@NotBlank(message = "Password cannot be blank")
	@Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
	private String passwordHash;
	@NotBlank(message = "Phone number cannot be blank")
	@Pattern(regexp = "\\+\\d{12}", message = "Contact number must start with '+' and have 12 digits")
	private String phoneNumber;
	@Column(nullable = false)
	@NotBlank(message = "Date cannot be blank")
	private LocalDateTime createdAt;
	@NotBlank(message = "Date cannot be blank")
	@LastModifiedDate
	private LocalDateTime updatedAt;

	@Override
	public String toString() {
		return "UsersDTO [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", passwordHash=" + passwordHash + ", phoneNumber=" + phoneNumber + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}

}
