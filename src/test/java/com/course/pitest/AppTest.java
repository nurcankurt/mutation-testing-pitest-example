package com.course.pitest;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    @Test
    public void InvalidInputTest(){
        ByteArrayOutputStream outstream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outstream));
        String input = "xyz";
        App.handleInput(input);
        String actual = outstream.toString();
        String expected = "Invalid input!";
        assertEquals(expected,actual);

    }

    @Test
    public void ValidInputTest(){
        ByteArrayOutputStream outstream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outstream));
        String input = "help";
        App.handleInput(input);
        String actual = outstream.toString();
        String expected = "add crs      - Add a course for the school\n" +
                "add stud     - Add student to the school\n" +
                "add stud crs - Add a student to a course\n" +
                "help         - List all commands\n" +
                "list crs     - List courses\n" +
                "list studs   - List students\n" +
                "quit         - Quit the app\n";
        assertEquals(expected,actual);
    }
    @Test
    public void QuitTest(){
        ByteArrayOutputStream outstream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outstream));
        App.Commands.quit();
        String actual = outstream.toString();
        String expected = "Goodbye!";
        Assertions.assertEquals(expected,actual);
    }


}
