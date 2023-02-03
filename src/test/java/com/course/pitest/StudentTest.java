package com.course.pitest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    @Test
    public void setBirthDateTest(){
        assertThrows(IllegalArgumentException.class, () -> {new Student("Nurcan","Kurt", LocalDate.parse("2025-01-01"));});
    }
    /*@Test
     public void isUnder18Test(){
         Person person = new Person("Sema","Altinisik", LocalDate.parse("2010-01-01"));
         assertFalse(person.isUnderAge());
     }
    @Test
    public void isAbove18Test(){
        Person person = new Person("Sema","Altinisik", LocalDate.parse("2004-01-01"));
        assertTrue(person.isUnderAge());
    }*/
    @ParameterizedTest
    @CsvSource(value = {
            "Sema,Altinisik,2006-01-01",
            "Nurcan,Kurt,2016-02-29",
            "Zeynep,Yilmaz,2018-02-03"
    })
    public void isUnder18Test(String name,String surname,String date){
        assertFalse(new Student(name,surname,LocalDate.parse(date)).isUnderAge());
    }
    @ParameterizedTest
    @CsvSource(value = {
            "Sema,Altinisik,2004-01-01",
            "Nurcan,Kurt,2001-01-01",
            "Zeynep,Yilmaz,1999-02-03"
    })
    public void isAbove18Test(String name,String surname,String date){
        assertTrue(new Student(name,surname,LocalDate.parse(date)).isUnderAge());
    }
    @Test
    public void setNameTest(){
        Student person = new Student();

        assertThrows(IllegalArgumentException.class, () -> { person.setFirstName("a");});
    }

    @Test
    public void testGetMarks(){
        Student student = new Student();
        double [] marks = {90,90,90};
        assertEquals("A",student.getMarks(marks));
    }

    @Test
    public void testGetGradeA(){
        Student student = new Student();
        assertEquals("A",student.getGrade(90));
    }
    @Test
    public void testGetGrade_B_UpperValue(){
        Student student = new Student();
        assertEquals("B",student.getGrade(89));
    }

    @Test
    public void testGetGrade_B_LowerValue(){
        Student student = new Student();
        assertEquals("B",student.getGrade(80));
    }
    @ParameterizedTest
    @ValueSource(doubles = {65,79})
    public void testGetGradeC(double average){
        Student student = new Student();
        assertEquals("C",student.getGrade(average));
    }

    @ParameterizedTest
    @ValueSource(doubles = {64,40})
    public void testGetGradeD(double average){
        Student student = new Student();
        assertEquals("D",student.getGrade(average));
    }

    @Test
    public void testGetGradeF(){
        Student student = new Student();
        assertEquals("F",student.getGrade(39));
    }






}
