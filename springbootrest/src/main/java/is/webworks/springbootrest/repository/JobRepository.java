package is.webworks.springbootrest.repository;

import is.webworks.springbootrest.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<JobPost, Integer> {

    List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile, String postDesc);
}
//    List<JobPost> jobs = new ArrayList<>(Arrays.asList(
//            new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2, List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
//            new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React",3, List.of("HTML", "CSS", "JavaScript", "React")),
//            new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3, List.of("iOS Development", "Android Development", "Mobile App")),
//            new JobPost(6, "DevOps Engineer", "Implement and manage continuous integration and delivery pipelines",  4, List.of("DevOps", "CI/CD", "Docker", "Kubernetes"))
//    ));
//
//    public List<JobPost> getAllJobs(){
//        return jobs;
//    }
//
//    public void addJob(JobPost job){
//        jobs.add(job);
//    }
//
//    public JobPost getJob(int postId) {
//        for(JobPost job : jobs){
//            if(job.getPostId() == postId){
//                return job;
//            }
//        }
//        return null;
//    }
//
//    public void updateJob(JobPost jobPost) {
//        for(JobPost job : jobs){
//            if(job.getPostId() == jobPost.getPostId()){
//                job.setPostProfile(jobPost.getPostProfile());
//                job.setPostDesc(jobPost.getPostDesc());
//                job.setReqExperience(jobPost.getReqExperience());
//                job.setPostTechStack(jobPost.getPostTechStack());
//            }
//        }
//    }
//
//    public void deleteJob(int postId) {
//        jobs.removeIf(job -> job.getPostId() == postId);
//    }

