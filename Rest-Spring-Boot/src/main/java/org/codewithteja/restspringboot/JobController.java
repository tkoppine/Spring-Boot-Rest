package org.codewithteja.restspringboot;

import org.codewithteja.restspringboot.model.JobPost;
import org.codewithteja.restspringboot.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping(path = "jobPosts", produces = "application/json")
//    @ResponseBody
    public List<JobPost> getAllJobPosts()
    {
        return jobService.getAllJobPosts();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost job(@PathVariable("postId") int postId)
    {
        return jobService.getJob(postId);
    }

    @PostMapping(path = "jobPost", consumes = "application/xml")
    public void addJob(@RequestBody JobPost jobPost)
    {
        jobService.addJob(jobPost);
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        jobService.updateJob(jobPost);
        return jobService.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable("postId") int postId){
        jobService.deleteJob(postId);
        return "deleted";
    }

    @GetMapping("load")
    public String loadData()
    {
        jobService.loadData();
        return "loaded";
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword){
        System.out.println(keyword);
        return jobService.search(keyword, keyword);
    }
}
