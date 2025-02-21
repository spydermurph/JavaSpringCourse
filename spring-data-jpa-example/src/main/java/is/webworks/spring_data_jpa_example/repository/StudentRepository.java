package is.webworks.spring_data_jpa_example.repository;

import is.webworks.spring_data_jpa_example.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("select s from Student s where s.name = ?1") // má sleppa fyrir einföld query með sömu nöfn og column
    List<Student> findByName(String name);

    List<Student> findByMarks(int mark);

    List<Student> findByMarksGreaterThan(int mark);
}
