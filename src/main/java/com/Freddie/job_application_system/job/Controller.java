package com.Freddie.job_application_system.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class Controller {
   private final Services services;

    public Controller(Services services) {
        this.services = services;
    }

    @GetMapping
    public ResponseEntity <List<Job>> findAll() {
        return ResponseEntity.ok( services.findAll());
    }
    @PostMapping
    public ResponseEntity <String> createJob(@RequestBody Job job) {
        services.createJob(job);
        return new ResponseEntity<>("Job Created Successfully!", HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job = services.getJobById(id);
        if (job != null)
            return new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
        boolean deleted = services.deleteJobById(id);
        if (deleted)
            return new ResponseEntity<>("Deleted!", HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job updatedJob){
        boolean updated = services.updateJob(id, updatedJob);
        if(updated)
            return new ResponseEntity<>("Updated!", HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
