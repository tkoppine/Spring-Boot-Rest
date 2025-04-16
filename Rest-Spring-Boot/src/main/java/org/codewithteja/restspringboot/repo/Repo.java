package org.codewithteja.restspringboot.repo;

import org.codewithteja.restspringboot.model.JobPost;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Repo {
    // get all the Job Posts
    List<JobPost> jobPosts = new ArrayList<>(Arrays.asList(
            new JobPost(1, "Software Engineer", "Develop and maintain web applications", 2, Arrays.asList("Java", "Spring Boot", "React")),
            new JobPost(2, "Data Engineer", "Build and optimize data pipelines", 3, Arrays.asList("Python", "Apache Spark", "Kafka")),
            new JobPost(3, "Backend Developer", "Design scalable backend systems", 4, Arrays.asList("Node.js", "Express", "MongoDB")),
            new JobPost(4, "Frontend Developer", "Create interactive UI components", 2, Arrays.asList("JavaScript", "React", "Tailwind CSS")),
            new JobPost(5, "DevOps Engineer", "Implement CI/CD pipelines", 5, Arrays.asList("Docker", "Kubernetes", "AWS"))
    ));
    public List<JobPost> getAllJobPosts()
    {
        return jobPosts;
    }

    // add the Job Post
    public void addJob(JobPost jobPost)
    {
        jobPosts.add(jobPost);
//        System.out.println(jobPosts);
    }

    public JobPost getJob(int postId) {
        for(JobPost job : jobPosts){
            if (job.getPostId() == postId){
                return job;
            }
        }
        return null;
    }

    public void updateJob(JobPost jobPost) {
        for (JobPost job : jobPosts) {
            if (job.getPostId() == jobPost.getPostId()){
                job.setPostId(jobPost.getPostId());
                job.setPostDesc(jobPost.getPostDesc());
                job.setPostProfile(jobPost.getPostProfile());
                job.setPostTechStack(jobPost.getPostTechStack());
                job.setReqExperience(jobPost.getReqExperience());
            }
        }
    }

    public void deleteJob(int postId) {
        for(JobPost job : jobPosts){
            if (job.getPostId() == postId){
                jobPosts.remove(job);
            }
        }
    }
}
