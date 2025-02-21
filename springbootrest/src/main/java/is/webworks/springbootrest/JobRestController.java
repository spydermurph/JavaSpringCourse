package is.webworks.springbootrest;

import is.webworks.springbootrest.model.JobPost;
import is.webworks.springbootrest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {
    @Autowired
    private JobService service;

    //@GetMapping(path = "jobPosts", produces = {"application/json"})
    @GetMapping("jobPosts")
    //@ResponseBody
    public List<JobPost> getAllJobs(){
        System.out.println("getAllJobs");
        return service.getAllJobs();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId){
        return service.getJob(postId);
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword){
        return service.searchByKeyword(keyword);
    }

    //@PostMapping(path = "jobPost", consumes = {"application/xml"})
    @PostMapping("jobPost")
    public JobPost addJob(@RequestBody JobPost jobPost) {
        service.addJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost) {
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable("postId") int postId){
        service.deleteJob(postId);
        return "post removed";
    }

    @GetMapping("load")
    public String loadData(){
        service.loadData();
        return "success";
    }
}
