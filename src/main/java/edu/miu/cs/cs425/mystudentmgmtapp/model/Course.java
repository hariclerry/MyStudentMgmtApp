package edu.miu.cs.cs425.mystudentmgmtapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity
public class Course {
    @Id
    @GeneratedValue
    private Long courseId;
    private String courseCode;
    private String courseName;

    @ManyToMany(mappedBy = "courses")
//    private List<Student> students = new ArrayList<>();

    private Set<Student> students = new HashSet<>();
    public Course( String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    public Course() {

    }
}
