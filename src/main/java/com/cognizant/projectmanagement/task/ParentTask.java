package com.cognizant.projectmanagement.task;

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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "ParentTask")
public class ParentTask {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Parent_ID")
    private int Id;
	
	@Column(name = "Parent_Task")
    private String parentTask;
	
	@OneToMany(
            mappedBy = "parentTask",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    @JsonManagedReference
    @JsonIgnore
    @JsonProperty(value="user")
    private Set<Tasks> task;
	
	public ParentTask() {
	}

	public ParentTask(int id, String parentTask,Set<Tasks> task) {
		super();
		Id = id;
		this.parentTask = parentTask;
		this.task=task;
	}

	public ParentTask(int id, String parentTask) {
		super();
		Id = id;
		this.parentTask = parentTask;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getParentTask() {
		return parentTask;
	}

	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}

	public Set<Tasks> getTask() {
		return task;
	}

	public void setTask(Set<Tasks> task) {
		this.task = task;
	}


	
	
}
