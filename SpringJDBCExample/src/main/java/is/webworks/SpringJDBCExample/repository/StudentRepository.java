package is.webworks.SpringJDBCExample.repository;

import is.webworks.SpringJDBCExample.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student student) {
        System.out.println("Saved");
        String sql = "insert into student (rollno, name, marks) values (?,?,?)";
        int rows = jdbc.update(sql, student.getRollNo(), student.getName(), student.getMarks());
        System.out.println(rows);
    }

    public List<Student> findAll() {
        String sql = "select * from student";

//        RowMapper<Student> mapper = new RowMapper<Student>() {
//            @Override
//            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
//                Student student = new Student();
//                student.setRollNo(rs.getInt("rollno"));
//                student.setName(rs.getString("name"));
//                student.setMarks(rs.getInt("marks"));
//
//                return student;
//            }
//        };

        RowMapper<Student> mapper = (rs, rowNum) -> {
                Student student = new Student();
                student.setRollNo(rs.getInt("rollno"));
                student.setName(rs.getString("name"));
                student.setMarks(rs.getInt("marks"));

                return student;
        };

        return jdbc.query(sql, mapper);
    }
}
