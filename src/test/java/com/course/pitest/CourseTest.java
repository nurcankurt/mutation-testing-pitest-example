package com.course.pitest;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {
    @Test
    public void ConstructorTest(){
        Course course = new Course(10,"SENG");
        assertEquals("SENG",course.getCourseName());
        assertEquals(10,course.getMAX_STUDENTS());
    }

    @Test
    public void AddStudent(){
        Course course = new Course(1,"SENG");
        LocalDate dt = LocalDate.parse("2001-01-01");
        assertTrue(course.addStudent(new Student("Nurcan","Kurt",dt)));
    }

    @Test
    public void NotAddStudent(){
        Course course = new Course(1,"SENG");
        course.addStudent(new Student("Sema","Altinisik",LocalDate.parse("2001-01-01")));
        assertFalse(course.addStudent(new Student("Nurcan","Kurt",LocalDate.parse("2001-01-01"))));
    }

    @Test
    public void SetMaxTest(){
        Course course = new Course(10,"SENG");
        course.setMAX_STUDENTS(15);
        assertThat(15,is(course.getMAX_STUDENTS()));

    }
    @Test
    public void SetMaxTestZero(){
        Course course = new Course(10,"SENG");
        assertThrows(IllegalArgumentException.class, () -> { course.setMAX_STUDENTS(0);;});

    }

    @Test
    public void studentsInCourseTest(){
        Course course = new Course(4,"SENG303");
        course.addStudent(new Student("Sema","Altinisik",LocalDate.parse("2001-01-01")));
        course.addStudent(new Student("Nurcan","Kurt",LocalDate.parse("2001-01-01")));
        course.addStudent(new Student("sena","demir",LocalDate.parse("2000-02-02")));
        assertThat(3,is(course.studentsInCourse()));
    }

    @Test
    public void SetMaxIllegalExceptionTest(){
        Course course = new Course(10,"SENG");
        assertThrows(IllegalArgumentException.class, () -> {course.setMAX_STUDENTS(-20);});

    }
    @Test
    public void StudentCopyTest(){
        Course course = new Course(2,"SENG303");
        course.addStudent(new Student("can","berk",LocalDate.parse("2000-01-01")));
        course.addStudent(new Student("sena","demir",LocalDate.parse("2000-02-02")));
        List<Student> copyList = course.getStudentsCopy();
        assertThat(copyList,hasItems(
                new Student("can","berk",LocalDate.parse("2000-01-01")),
                new Student("sena","demir",LocalDate.parse("2000-02-02"))
                ));
    }
    @Test
    public void CourseCopyTest(){
        Course course = new Course(3,"SENG303");
        course.addStudent(new Student("can","berk",LocalDate.parse("2000-01-01")));
        course.addStudent(new Student("sena","demir",LocalDate.parse("2000-02-02")));
        Course copied = course.copyOf();
        assertEquals("SENG303",copied.getCourseName());
        assertEquals(3,copied.getMAX_STUDENTS());
        assertThat(copied.getStudents(),hasItems(
                new Student("can","berk",LocalDate.parse("2000-01-01")),
                new Student("sena","demir",LocalDate.parse("2000-02-02"))
        ));
    }




}
