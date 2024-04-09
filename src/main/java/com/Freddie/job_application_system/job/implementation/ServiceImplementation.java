package com.Freddie.job_application_system.job.implementation;

import com.Freddie.job_application_system.job.Job;
import com.Freddie.job_application_system.job.Repository;
import com.Freddie.job_application_system.job.Services;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceImplementation implements Services {
    /*private final List<Job> jobs = new ArrayList<>();*/
       Repository repository;

    public ServiceImplementation(Repository repository) {
        this.repository = repository;
    }

    @Override
    public List<Job> findAll() {
        return repository.findAll();
    }
    @Override
    public void createJob(Job job) {
        repository.save(job);
    }
    @Override
    public Job getJobById(Long id) {
       return repository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
        try {
            repository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        Optional<Job> jobOptional = repository.findById(id);
        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setLocation(updatedJob.getLocation());
            repository.save(job);
            return true;
        }
        return false;
    }
}
