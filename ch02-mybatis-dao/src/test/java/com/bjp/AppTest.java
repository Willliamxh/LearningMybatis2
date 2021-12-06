package com.bjp;

import static org.junit.Assert.assertTrue;

import com.bjp.dao.StudentDaoImpl;
import com.bjp.domain.Student;
import org.junit.Test;

import java.util.List;
import java.util.function.Consumer;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void testSelectStudent(){
        StudentDaoImpl studentDao = new StudentDaoImpl();
        List<Student> studentList = studentDao.selectStudents();
        studentList.forEach(student -> System.out.println(student));
    }


    @Test
    public void testInsertStudent(){
        StudentDaoImpl studentDao = new StudentDaoImpl();
        Student student=new Student();
        student.setEmail("456@qq.com");
        student.setAge(22);
        student.setName("xuhan2");
        student.setId(7);
        int i = studentDao.insertStudent(student);
        System.out.println(i);

    }
}
