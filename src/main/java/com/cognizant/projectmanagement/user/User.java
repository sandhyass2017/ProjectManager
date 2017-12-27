package com.cognizant.projectmanagement.user;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cognizant.projectmanagement.project.Project;
import com.cognizant.projectmanagement.task.Tasks;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "User")
public class User {

	private interface Table {
		String User_ID = "User_ID";
		String FIRST_NAME = "FIRST_NAME";
		String LAST_NAME = "LAST_NAME";
		String Employee_ID = "Employee_ID";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = Table.User_ID)
	private Integer userId;

	@Column(name = Table.Employee_ID, unique = true)
	private Integer employeeId;

	@Column(name = Table.FIRST_NAME)
	private String firstName;

	@Column(name = Table.LAST_NAME)
	private String lastName;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "project_id", nullable = false)
	@JsonBackReference(value="Project")
	private Project projectId;

	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "task_id", nullable = false)
	@JsonBackReference(value="Tasks")
	private Tasks taskId;
	
	
	/*@OneToMany(
            mappedBy = "user",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY,
            orphanRemoval = true)
	@JsonBackReference
    //@JsonIgnore
    @JsonProperty(value="tasks")
    private Set<Tasks> taskId;*/

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Project getProjectId() {
		return projectId;
	}

	public void setProjectId(Project projectId) {
		this.projectId = projectId;
	}


	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public User(Integer userId, Integer employeeId, String firstName, String lastName, Project projectId,
			Tasks taskId) {
		super();
		this.userId = userId;
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.projectId = projectId;
		this.taskId = taskId;
	}
	public Tasks getTaskId() {
		return taskId;
	}

	public void setTaskId(Tasks taskId) {
		this.taskId = taskId;
	}

	public User() {
	}
	public User(Integer userId, Integer employeeId, String firstName, String lastName) {
		super();
		this.userId = userId;
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
