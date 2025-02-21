package is.webworks.springbootrest.service;

import is.webworks.springbootrest.model.JobPost;
import is.webworks.springbootrest.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository repository;

    public void addJob(JobPost job){
        repository.save(job);
    }

    public List<JobPost> getAllJobs() {
        return repository.findAll();
    }

    public JobPost getJob(int postId) {
        return repository.findById(postId).orElse(new JobPost());
    }

    public void updateJob(JobPost jobPost) {
        repository.save(jobPost);
    }

    public void deleteJob(int postId) {
        repository.deleteById(postId);
    }

    public void loadData() {
        List<JobPost> jobs = new ArrayList<>(Arrays.asList(
                new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2, List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
                new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React",3, List.of("HTML", "CSS", "JavaScript", "React")),
                new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3, List.of("iOS Development", "Android Development", "Mobile App")),
                new JobPost(6, "DevOps Engineer", "Implement and manage continuous integration and delivery pipelines",  4, List.of("DevOps", "CI/CD", "Docker", "Kubernetes"))
        ));

        repository.saveAll(jobs);
    }

    public List<JobPost> searchByKeyword(String keyword) {
        return repository.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
    }
}
