package com.demo;

import com.dao.StudentDao;
import com.model.Student;


public class App 
{
    public static void main( String[] args )
    {
        StudentDao sd = new StudentDao();
        
        Student s1 = sd.findStudentById(3);
        s1.setName("manojkumar");
        System.out.println(sd.updateStudent(s1));
    }
}
