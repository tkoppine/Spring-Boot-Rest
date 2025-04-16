package org.codewithteja.restspringboot.service;


import org.codewithteja.restspringboot.model.JobPost;
import org.codewithteja.restspringboot.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepo repo;

    // To add job
    public void addJob(JobPost jobPost)
    {

        repo.save(jobPost);
    }

    // Retrieve all Job Posts
    public List<JobPost> getAllJobPosts()
    {

        return repo.findAll();
    }

    public JobPost getJob(int postId) {
        return repo.findById(postId).orElse(new JobPost());
    }

    public void updateJob(JobPost jobPost) {
        repo.save(jobPost);
    }

    public void deleteJob(int postId) {
        repo.deleteById(postId);
    }

    public void loadData() {
        List<JobPost> jobs = new ArrayList<>(Arrays.asList(
                new JobPost(1, "Software Engineer", "Develop and maintain web applications", 2, Arrays.asList("Java", "Spring Boot", "React")),
                new JobPost(2, "Data Engineer", "Build and optimize data pipelines", 3, Arrays.asList("Python", "Apache Spark", "Kafka")),
                new JobPost(3, "Backend Developer", "Design scalable backend systems", 4, Arrays.asList("Node.js", "Express", "MongoDB")),
                new JobPost(4, "Frontend Developer", "Create interactive UI components", 2, Arrays.asList("JavaScript", "React", "Tailwind CSS")),
                new JobPost(5, "DevOps Engineer", "Implement CI/CD pipelines", 5, Arrays.asList("Docker", "Kubernetes", "AWS"))
        ));
        repo.saveAll(jobs);
    }

    public List<JobPost> search(String postProfile, String postDesc) {
        System.out.println(postProfile);
        List<JobPost> lst = repo.findByPostProfileContainingOrPostDescContaining(postProfile, postDesc);
        System.out.println(lst);
        return lst;
    }
}
