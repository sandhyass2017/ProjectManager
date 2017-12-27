package com.cognizant.projectmanagement.project;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cognizant.projectmanagement.task.Tasks;
import com.cognizant.projectmanagement.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Project")
public class Project {

	private interface Table {
		String ID = "ID";
		String Project = "Project";
		String Start_Date = "Start_Date";
		String End_Date = "End_Date";
		String Priority = "Priority";
	}

	public Project(Integer id, String project, Date startDate, Date endDate, String priority, Set<User> user,
			Set<Tasks> task) {
		super();
		this.id = id;
		this.project = project;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
		this.user = user;
		this.task = task;
	}

	public Project() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = Table.ID)
	private Integer id;

	@Column(name = Table.Project)
	private String project;

	@Column(name = Table.Start_Date)
	@JsonFormat(pattern = "YYYY-MM-dd")
	private Date startDate;

	@Column(name = Table.End_Date)
	@JsonFormat(pattern = "YYYY-MM-dd")
	private Date endDate;

	@Column(name = Table.Priority)
	private String priority;

	public Project(Integer projectId, String project, Date startDate, Date endDate, String priority) {
		super();
		this.id = projectId;
		this.project = project;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer projectId) {
		this.id = projectId;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
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

	@OneToMany(mappedBy = "projectId", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, orphanRemoval = true)
	@JsonBackReference
	@JsonIgnore
	private Set<User> user;

	@OneToMany(mappedBy = "project", cascade = { CascadeType.MERGE,
			CascadeType.PERSIST }, fetch = FetchType.LAZY, orphanRemoval = true)
	@JsonManagedReference
	@JsonIgnore
	private Set<Tasks> task;
}
