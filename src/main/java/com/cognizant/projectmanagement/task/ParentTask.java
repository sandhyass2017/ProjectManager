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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "ParentTask")
public class ParentTask {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parent_id")
    private Integer id;
	
	@Column(name = "parent_task")
    private String parentTask;
	
	@OneToMany(
            mappedBy = "parentTask",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY,
            orphanRemoval = true)
	@JsonBackReference
    @JsonIgnore
    private Set<Tasks> task;
	
	public ParentTask() {
	}

	public ParentTask(Integer id, String parentTask,Set<Tasks> task) {
		super();
		this.id=id;
		this.parentTask = parentTask;
		this.task=task;
	}

	public ParentTask(Integer id, String parentTask) {
		super();
		this.id=id;
		this.parentTask = parentTask;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id=id;
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
