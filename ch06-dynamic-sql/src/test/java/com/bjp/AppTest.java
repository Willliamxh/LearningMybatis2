package com.bjp;

import static org.junit.Assert.assertTrue;

import com.bjp.dao.StudentDao;
import com.bjp.domain.MyStudent;
import com.bjp.domain.Student;
import com.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
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

    @Test
    public void testSelectStudentWhere(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao  =  sqlSession.getMapper(StudentDao.class);

        Student student  = new Student();
        // student.setName("李四");
        // student.setAge(18);
        List<Student> students = dao.selectStudentWhere(student);
        for(Student stu:students){
            System.out.println("where==="+stu);
        }
    }

    @Test
    public void testfor(){
        List<Integer> list = new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);

        //String sql="select * from student where id in (1001,1002,1003)";
        String sql="select * from student where id in";

        StringBuilder builder  = new StringBuilder("");
        int init=0;
        int len = list.size();

        //添加开始的 (
        builder.append("(");
        for(Integer i:list){
            builder.append(i).append(",");

        }
        builder.deleteCharAt(builder.length()-1);
        //循环结尾
        builder.append(")");
        sql = sql  + builder.toString();
        System.out.println("sql=="+sql);


    }

    @Test
    public void testSelectForEach(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao  =  sqlSession.getMapper(StudentDao.class);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        List<Student> students = dao.selectForeachOne(list);
        for(Student stu:students){
            System.out.println("foreach--one ==="+stu);
        }
    }

    @Test
    public void testSelectForTwo(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao  =  sqlSession.getMapper(StudentDao.class);

        List<Student> stuList  = new ArrayList<>();
        Student s1 = new Student();
        s1.setId(1);
        s1.setName("xuhan");
        stuList.add(s1);

        s1 = new Student();
        s1.setId(2);;
        s1.setName("yizhe");
        stuList.add(s1);

        List<Student> students = dao.selectForeachTwo(stuList);
        for(Student stu:students){
            System.out.println("foreach--two ==="+stu);
        }
    }






}
