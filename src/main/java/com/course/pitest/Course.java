package com.course.pitest;
import java.util.ArrayList;
import java.util.List;

public class Course {
    private int MAX_STUDENTS;
    private List<Student> students;
    private String courseName;

    public List<Student> getStudents() {
        return students;
    }

    public Course(int MAX_STUDENTS, String courseName) throws IllegalArgumentException{
        setMAX_STUDENTS(MAX_STUDENTS);
        students = new ArrayList<>(MAX_STUDENTS);
        this.courseName = courseName;
    }

    public boolean addStudent(Student student) {
        //If capacity not full, add Person and return true if successful
        return students.size() < MAX_STUDENTS ? students.add(student) : false;
    }

    public void setMAX_STUDENTS(int MAX_STUDENTS) throws IllegalArgumentException {
        if (MAX_STUDENTS > 0) {
            this.MAX_STUDENTS = MAX_STUDENTS;
        } else {
            throw new IllegalArgumentException("Number of max students must be a positive integer");
        }
    }

    public int studentsInCourse() {
        return students.size();
    }

    public int getMAX_STUDENTS() {
        return MAX_STUDENTS;
    }

    public String getCourseName() {
        return courseName;
    }

    public List<Student> getStudentsCopy() {
        List<Student> newList = new ArrayList<>(students.size());

        for (Student student : students) {
            newList.add(student.copyOf());
        }

        return newList;
    }

    public Course copyOf() {
        Course courseCopy = new Course(MAX_STUDENTS, courseName);
        for (Student student : students) {
            courseCopy.addStudent(student.copyOf());
        }
        return courseCopy;
    }
}
