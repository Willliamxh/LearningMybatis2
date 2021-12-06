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
    public void testSelectStudent(){
        /**
         * 使用mybatis的动态代理机制， 使用SqlSession.getMapper(dao接口)
         * getMapper能获取dao接口对于的实现类对象。
         *
         * 我的理解是,getMapper可以通过反射机制来获取到"接口"的完整类名和方法
         * 然后之前的"sql"的xml文件中可以通过完整类名,加上方法定位到唯一的一个"sql"语句
         * 在案例中,如果我调用了selectStudents方法,就会定位到"select"查询语句,所以可以直接执行
         * 而对于查询语句最后返回的肯定是一个"List"集合,所以其实方法中写的内容是固定的
         */
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        //com.sun.proxy.$Proxy2
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        System.out.println(dao.getClass().getName());
        //调用dao的方法，执行数据库的操作
        List<Student> studentList = dao.selectStudents();
        studentList.forEach(student -> System.out.println(student));

    }


    @Test
    public void testInsertStudent(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        Student student=new Student();
        student.setEmail("456@qq.com");
        student.setAge(22);
        student.setName("xuhanGetMapper");
        student.setId(5);
        int i = dao.insertStudent(student);
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();

    }
}
