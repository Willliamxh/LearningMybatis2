package com.bjp;

import static org.junit.Assert.assertTrue;

import com.bjp.dao.StudentDao;
import com.bjp.domain.MyStudent;
import com.bjp.domain.Student;
import com.bjp.vo.QueryParam;
import com.bjp.vo.ViewStudent;
import com.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @Test
    public void testSelectViewStudent(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao  =  sqlSession.getMapper(StudentDao.class);

        ViewStudent student = dao.selectStudentReturnViewStudent(2);

        System.out.println("1005 student="+student);
    }

    @Test
    public void testSelectCount(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao  =  sqlSession.getMapper(StudentDao.class);

        int counts  = dao.countStudent();
        System.out.println("学生数量="+counts);
    }


    //返回Map
    @Test
    public void testSelecMap(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao  =  sqlSession.getMapper(StudentDao.class);

        Map<Object,Object> map = dao.selectMapById(1);
        System.out.println("map=="+map);
    }

    //=======================================
    @Test
    public void testSelectAllStudents(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> students = dao.selectAllStudents();

        for(Student stu: students){
            System.out.println("学生="+stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectAllStudents2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<MyStudent> students = dao.selectMyStudent();

        for(MyStudent stu: students){
            System.out.println("学生="+stu);
        }
        sqlSession.close();
    }


    @Test
    public void testSelectDiffColProperty(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<MyStudent> students = dao.selectDiffColProperty();

        for(MyStudent stu: students){
            System.out.println("#######学生="+stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectLikeOne(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        //准备好like的内容
        String name = "%xu%";
        List<Student> students = dao.selectLikeOne(name);

        for(Student stu: students){
            System.out.println("#######学生="+stu);
        }
        sqlSession.close();
    }





}
