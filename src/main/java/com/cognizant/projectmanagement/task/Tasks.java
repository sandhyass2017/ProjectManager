package com.cognizant.projectmanagement.task;

import java.util.Date;
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
import com.cognizant.projectmanagement.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
@Table(name = "Tasks")
public class Tasks {

	private interface Table {
		String Task_ID = "Task_ID";
		String Task = "Task";
		String Start_Date = "Start_Date";
		String End_Date = "End_Date";
		String Priority = "Priority";
		String Status = "Status";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = Table.Task_ID)
	private Integer taskId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "parent_id", nullable = false)
	@JsonBackReference(value="ParentTask")
	private ParentTask parentTask;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "project_id", nullable = false)
	@JsonBackReference(value="Project")
	private Project project;
	
	@Column(name = Table.Task)
	private String task;

	@Column(name = Table.Start_Date)
	private Date startDate;

	@Column(name = Table.End_Date)
	private Date endDate;

	@Column(name = Table.Priority)
	private String priority;

	@Column(name = Table.Status)
	private String status;

	public Tasks(Integer taskId, ParentTask parentId, String task, Date startDate, Date endDate, String priority,
			String status) {
		super();
		this.taskId = taskId;
		this.parentTask = parentId;
		this.task = task;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
		this.status = status;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public ParentTask getParentTask() {
		return parentTask;
	}

	public void setParentTask(ParentTask parentTask) {
		this.parentTask = parentTask;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Tasks() {

	}

	@OneToMany(
            mappedBy = "taskId",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY,
            orphanRemoval = true)
	@JsonBackReference
    //@JsonIgnore
    @JsonProperty(value="user")
    private Set<User> user;
	
	/*@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	@JsonBackReference(value="user")
	private User user;*/
}
