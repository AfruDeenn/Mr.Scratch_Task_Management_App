package com.TaskScheduler.dto;

import com.TaskScheduler.entity.Users;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRoleDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userRoleId;

	@NotBlank(message = "Last name cannot be blank")
	@Size(min = 3, max = 50, message = "User role name must be between 3 and 50 characters")
	private String userRoleName;

	@ManyToOne(fetch = FetchType.LAZY) // User is the owning side
	@JoinColumn(name = "user_id", nullable = false)
	private Users user;

	@Override
	public String toString() {
		return "UserRole [userRoleId=" + userRoleId + ", userRoleName=" + userRoleName + ", user=" + user + "]";
	}

}
