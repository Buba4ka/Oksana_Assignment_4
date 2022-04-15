package com.coderscampus;

import java.io.Serializable;

public class Student implements Comparable<Student>, Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String studentID;
    private String course;
    private String grade;

    public Student () {

    }

    public Student(String name, String studentID, String course, String grade) {
        this.name = name;
        this.studentID = studentID;
        this.course = course;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public int compareTo(Student that) {
        if (this.course.compareTo(that.course) == 0){
            return 0;
        }
        return -1;
    }


}
