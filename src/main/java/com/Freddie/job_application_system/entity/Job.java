package com.Freddie.job_application_system.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
/*@Table(name = "job_application")*/
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private int minSalary;
    private int maxSalary;
    private String location;

    @ManyToOne
    private Company company;
    public Job() {
    }

    public Job(Long id, String title, String description, int minSalary, int maxSalary, String location) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.location = location;
    }

}
