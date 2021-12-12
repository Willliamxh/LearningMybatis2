package com.bjp;

import static org.junit.Assert.assertTrue;

import com.bjp.dao.StudentDao;
import com.bjp.domain.MyStudent;
import com.bjp.domain.Student;
import com.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void testSelectStudentIf(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao  =  sqlSession.getMapper(StudentDao.class);

        Student student  = new Student();
       student.setName("xuhan");
       student.setAge(18);

        // student.setName("dd");
        // student.setAge(13);
        List<Student> students = dao.selectStudentIf(student);
        for(Student stu:students){
            System.out.println("if==="+stu);
        }


    }





}
