package org.example;
import java.util.Scanner;
import java.util.logging.*;
class Student{
    String name;
    String grade;
    double gpa;
    Logger log=Logger.getLogger("com.api.jar");
    Student(String name,String grade,double gpa)
    {
        this.name=name;
        this.grade=grade;
        this.gpa=gpa;
    }
    public void updateGpa(double upga)
    {
        gpa=upga;

    }
    public void display()
    {
        log.info("Student Name:"+this.name+"\n");
        log.info("Student Grade:"+this.grade+"\n");
        log.info("Student GPA:"+this.gpa+"\n");

    }

}
