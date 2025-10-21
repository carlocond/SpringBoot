package com.university.University.student;

import jakarta.persistence.*;

@Entity
@Table(name = "student_stats")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;


    private String firstName;
    private String lastName;
    private Integer age;
    private String course;
    private Double cfu;
    private Double exams;

    //Costruttore di default
    public Student() {
    }

    //Costruttore parametrizzato
    public Student(Long id, String firstName, String lastName, Integer age, String course, Double cfu, Double exams) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.course = course;
        this.cfu = cfu;
        this.exams = exams;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Double getCfu() {
        return cfu;
    }

    public void setCfu(Double cfu) {
        this.cfu = cfu;
    }

    public Double getExams() {
        return exams;
    }

    public void setExams(Double exams) {
        this.exams = exams;
    }
}
