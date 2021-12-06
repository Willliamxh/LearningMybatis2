package com.bjp;

import com.bjp.domain.Student;
import com.bjp.utils.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author Willam_xh
 * @Date 2021-12-06 10:01
 */
public class MyAppTest2 {
    public static void main(String[] args) throws IOException {

        //5.【重要】获取sqlSession对象，从SqlSessionFactory中获得sqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //6.【重要】指定要执行的sql语句的标识。sql映射文件中的namespace + '.' +标签的id值
        String sqlId="com.bjp.dao.StudentDao"+"."+"selectStudents";
        //7.执行sql语句，通过sqlId找到语句
        List<Student> studentList = sqlSession.selectList(sqlId);
        //8.输出结果
        studentList.forEach(student -> System.out.println("查询的学生"+student));
        //9.关闭sqlSession对象
        sqlSession.close();

    }

    @Test
    public void myTestInsert() throws IOException {
        //5.【重要】获取sqlSession对象，从SqlSessionFactory中获得sqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //6.【重要】指定要执行的sql语句的标识。sql映射文件中的namespace + '.' +标签的id值
        String sqlId="com.bjp.dao.StudentDao"+"."+"insertStudent";
        //7.执行sql语句，通过sqlId找到语句
        Student student=new Student();
        student.setId(4);
        student.setName("关羽");
        student.setAge(22);
        student.setEmail("1234@qq.com");
        int insert = sqlSession.insert(sqlId, student);

        //mybatis默认不是自动提交事务的，所以在insert update 之后再提交事务
        sqlSession.commit();

        //8.输出结果
        System.out.println(insert);
        //9.关闭sqlSession对象
        sqlSession.close();
    }
}
