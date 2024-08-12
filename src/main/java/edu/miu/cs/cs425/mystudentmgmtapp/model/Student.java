package edu.miu.cs.cs425.mystudentmgmtapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class Student {
    @Id
    @GeneratedValue
    @Column(unique = true, nullable = false)
    private Long      studentId;
    @Column(nullable = false)
    private String    studentNumber;
    @Column(nullable = false)
    private String    firstName;
    @Column(nullable = false)
    private String    lastName;
    @Column(nullable = true)
    private String    middleName;
    @Column(nullable = false)
    private double    cgpa;
    @Column(nullable = false)
    private LocalDate dateOfEnrollment;

    @OneToOne(cascade={CascadeType.PERSIST})
    private Transcript transcript;

    @ManyToOne(cascade={CascadeType.PERSIST})
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    @ManyToMany(cascade={CascadeType.PERSIST})
//    private List<Course> courses = new ArrayList<>();
    private Set<Course> courses = new HashSet<>();
    public Student() {}

    public Student(
            String studentNumber,
            String firstName,
            String lastName,
            String middleName,
            double cgpa,
            LocalDate dateOfEnrollment
                  ) {
        this.studentNumber = studentNumber;
        this.firstName     = firstName;
        this.lastName      = lastName;
        this.middleName    = middleName;
        this.cgpa          = cgpa;
        this.dateOfEnrollment = dateOfEnrollment;
    }

    @Override
    public String toString() {
        return "Student{" +
               "studentId=" + studentId +
               ", studentNumber='" + studentNumber + '\'' +
               ", firstName='" + firstName + '\'' +
               ", classroom='" + classroom + '\'' +
               ", transcript=" + transcript +
               '}';
    }

}
