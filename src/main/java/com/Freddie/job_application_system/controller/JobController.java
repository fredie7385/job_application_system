package com.Freddie.job_application_system.controller;

import com.Freddie.job_application_system.entity.Job;
import com.Freddie.job_application_system.service.JobServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
   private final JobServices jobServices;

    public JobController(JobServices jobServices) {
        this.jobServices = jobServices;
    }

    @GetMapping
    public ResponseEntity <List<Job>> findAll() {
        return ResponseEntity.ok( jobServices.findAll());
    }
    @PostMapping
    public ResponseEntity <String> createJob(@RequestBody Job job) {
        jobServices.createJob(job);
        return new ResponseEntity<>("Job Created Successfully!", HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job = jobServices.getJobById(id);
        if (job != null)
            return new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
        boolean deleted = jobServices.deleteJobById(id);
        if (deleted)
            return new ResponseEntity<>("Deleted!", HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job updatedJob){
        boolean updated = jobServices.updateJob(id, updatedJob);
        if(updated)
            return new ResponseEntity<>("Updated!", HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
