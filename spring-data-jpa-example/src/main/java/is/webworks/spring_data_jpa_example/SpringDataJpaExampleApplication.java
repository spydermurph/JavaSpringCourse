package is.webworks.spring_data_jpa_example;

import is.webworks.spring_data_jpa_example.model.Student;
import is.webworks.spring_data_jpa_example.repository.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class SpringDataJpaExampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataJpaExampleApplication.class, args);

		StudentRepository repository = context.getBean(StudentRepository.class);

//		Student s1 = context.getBean(Student.class);
		Student s2 = context.getBean(Student.class);
//		Student s3 = context.getBean(Student.class);
//
//		s1.setRollNo(101);
//		s1.setName("Arnar");
//		s1.setMarks(57);
//
		s2.setRollNo(102);
		s2.setName("Anna");
		s2.setMarks(70);
//
//		s3.setRollNo(103);
//		s3.setName("Helgi");
//		s3.setMarks(60);
//
//		repository.save(s2);
//		repository.save(s3);

//		System.out.println(repository.findAll());

//		System.out.println(repository.findById(101));

//		Optional<Student> s = repository.findById(104);
//		System.out.println(s.orElse(new Student()));

//		System.out.println(repository.findByName("Arnar"));
//
//		System.out.println(repository.findByMarks(60));
//
//		System.out.println(repository.findByMarksGreaterThan(55));

//		// Update
		repository.save(s2);
//		repository.deleteById(102);
	}

}
