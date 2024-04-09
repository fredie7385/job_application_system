package com.Freddie.job_application_system.job;

import java.util.List;

public interface Services {

    List<Job> findAll();
    void createJob(Job job);
    Job getJobById(Long id);
    boolean deleteJobById(Long id);
    boolean updateJob(Long id, Job updatedJob);
}
