package com.course.pitest;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Student {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    public Student() {
         firstName = null;
         lastName = null;
         birthDate = null;
     }

    public Student(String firstName, String lastName, LocalDate birthDate)
            throws IllegalArgumentException {
        setFirstName(firstName);
        setLastName(lastName);
        setBirthDate(birthDate);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws IllegalArgumentException {
        setNameHelper(firstName, true);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws IllegalArgumentException {
        setNameHelper(lastName, false);
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) throws IllegalArgumentException {
        if (birthDate == null || birthDate.compareTo(LocalDate.now()) > 0) {
            throw new IllegalArgumentException("Given date is in the future");
        } else {
            this.birthDate = birthDate;
        }
    }

    public boolean isUnderAge() {
         return ChronoUnit.YEARS.between(birthDate, LocalDate.now()) >= 18;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            return this.firstName.equals(((Student) obj).getFirstName()) &&
                    this.lastName.equals(((Student) obj).getLastName()) &&
                    this.birthDate.equals(((Student) obj).getBirthDate());
            
        } else {
            return false;
        }
    }

    public Student copyOf() throws IllegalArgumentException {
        return new Student(firstName, lastName, birthDate);
    }

    private void setNameHelper(String name, boolean first) throws IllegalArgumentException{
        String exceptionMessage = "Argument firstName must have at least two characters";
        try {
            if (name.matches("[a-öA-Ö]{2,}")) {
                name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
                if (first) {
                    this.firstName = name;
                } else {
                    this.lastName = name;
                }
            } else {
                throw new IllegalArgumentException(exceptionMessage);
            }
        } catch (NullPointerException e) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    public String getMarks(double[] marks) {
        if (marks==null)
            return null;
        double totalMarks = 0;
        double average ;

        for (int i = 0; i<marks.length;i++)
        {
            totalMarks+=marks[i];

        }
        average = totalMarks/marks.length;
        return getGrade(average);
}

    public String getGrade(double average) {
        if (average >= 90) {
            return "A";
        } else if (average <= 89 && average >= 80) {
            return "B";
        } else if (average <= 79 && average >= 65) {
            return "C";
        } else if (average <= 64 && average >= 40) {
            return "D";
        } else {
            return "F";
        }
    }
}


