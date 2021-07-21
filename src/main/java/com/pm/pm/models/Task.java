package com.pm.pm.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Tasks")
public class Task {
    @Id
    private String taskID;
    private String taskName;
    private String startedDate;
    private String endDate;

    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;

}
