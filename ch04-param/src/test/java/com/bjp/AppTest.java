package com.bjp;

import static org.junit.Assert.assertTrue;

import com.bjp.dao.StudentDao;
import com.bjp.domain.Student;
import com.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.function.Consumer;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void testSelectStudentById(){

        SqlSession sqlSession= MybatisUtils.getSqlSession();
        //com.sun.proxy.$Proxy2
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        System.out.println(dao.getClass().getName());
        //调用dao的方法，执行数据库的操作
        Student student1 = dao.selectStudentById(2);
        System.out.println(student1);
    }

    @Test
    public void testSelectParam(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        //com.sun.proxy.$Proxy2
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        List<Student> studentList = dao.selectMultiParam("xuhan", 22);
        studentList.forEach(student -> System.out.println(student));
    }



}
