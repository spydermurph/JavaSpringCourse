package is.webworks.SpringJDBCExample;

import is.webworks.SpringJDBCExample.model.Student;
import is.webworks.SpringJDBCExample.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcExampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcExampleApplication.class, args);

		Student student = context.getBean(Student.class);

		student.setRollNo(104);
		student.setName("Arnar");
		student.setMarks(90);

		StudentService service = context.getBean(StudentService.class);

		service.addStudent(student);

		List<Student> students = service.getStudents();
		System.out.println(students);
	}

}
