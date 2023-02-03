package com.course.pitest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SchoolTest {

    @BeforeAll
    public static void beforeSchoolTest(){
        System.out.println("Test has been started");
    }
    @AfterAll
    public static void afterSchoolTest(){
        System.out.println("Test has been finished");
    }


    @Test
    public void negativeAddGrantTest(){
        School school = new School();
        assertThrows(IllegalArgumentException.class, () -> {school.addGrant(-1);;});
    }
    @Test
    public void addGrantTest(){
        School school = new School();
        school.addGrant(0);
        assertEquals(0,school.getGrantMoney());
    }

    @Test
    public void schoolAddStudentTest(){
        School school = new School();
        assertEquals(0,school.getGrantMoney());
        school.addStudent(new Student());
        school.addStudent(new Student());
        assertEquals(20,school.getGrantMoney());
    }
    @Test
    public void studentAmountTest(){
        School school = new School();
        school.addStudent(new Student());
        school.addStudent(new Student());
        assertEquals(2,school.studentsAmount());
    }
    @Test
    public void addCourseTest(){
        School school = new School();
        Course course = new Course(10,"SENG");
        assertEquals(0,school.getGrantMoney());
        assertThrows(InsufficientFundsException.class, () -> {school.addCourse(course);});
    }
    @Test
    public void courseAmountTest(){
        School school = new School();
        school.addGrant(40);
        school.addCourse(new Course(50,"SENG"));
        school.addCourse(new Course(50,"CENG"));
        assertEquals(2,school.coursesAmount());
    }


}
