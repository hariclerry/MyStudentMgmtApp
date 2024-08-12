package edu.miu.cs.cs425.mystudentmgmtapp;

import edu.miu.cs.cs425.mystudentmgmtapp.model.Classroom;
import edu.miu.cs.cs425.mystudentmgmtapp.model.Course;
import edu.miu.cs.cs425.mystudentmgmtapp.model.Student;
import edu.miu.cs.cs425.mystudentmgmtapp.model.Transcript;
import edu.miu.cs.cs425.mystudentmgmtapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Set;

@SpringBootApplication
public class MyStudentMgmtAppApplication implements CommandLineRunner {
    @Autowired
    private StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(MyStudentMgmtAppApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        // Create a Student object and save it to the database
        Transcript transcript = new Transcript("BS Computer Science");
        Classroom classroom = new Classroom("McLaughlin building", "M105");
        // Create and save Courses
        Course course1 = new Course("CS401", "Modern Prog Practices");
        Course course2 = new Course("CS402", "Algorithm Design");

        Student student = new Student("1001", "Anna",  "Lynn", " ", 3.45, LocalDate.of(1951, 11, 18));

        student.setTranscript(transcript);
        student.setClassroom(classroom);

        student.setCourses(Set.of(course1, course2));
        saveStudent(student);
    }

    public void saveStudent(Student student) {
        student = studentRepository.save(student);
        System.out.println("Saved Student: " + student);
    }

}
