package is.webworks.student_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentRepository repository;

    @GetMapping("/students")
    public List<Student> getStudents(){
        return repository.findAll();
    }
}
