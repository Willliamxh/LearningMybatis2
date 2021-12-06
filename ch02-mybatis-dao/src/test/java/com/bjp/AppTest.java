package com.bjp;

import static org.junit.Assert.assertTrue;

import com.bjp.dao.StudentDao;
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
        StudentDao studentDao = new StudentDaoImpl();
        /**
         * List<Student> studentList  = dao.selectStudents(); 调用
         * 1.dao对象，类型是StudentDao，全限定名称是：com.bjpowernode.dao.StudentDao
         *   全限定名称 和 mapper.xml中的namespace 是一样的。
         *
         * 2.方法名称， selectStudents，
         *  这个方法就是 mapper文件中的 id值 selectStudents
         *  方法名称结合上面的全限定名称，就能知道具体的sql语句的id
         *  //我们猜想，根据对应的select/insert 标签 可以判断是调用sqlSession的具体方法是select/insert
         *
         * 3.通过dao中方法的返回值也可以确定MyBatis要调用的SqlSession的方法
         *    如果返回值是List ，调用的是SqlSession.selectList()方法。
         *    如果返回值 int ，或是非List的， 看mapper文件中的 标签是<insert>，<update> 就会调用
         *    SqlSession的insert， update等方法
         *
         *  -》》》所以有了 mybatis的动态代理，自动帮你生成实现类，不用我们自己去写实现类了
         *  mybatis的动态代理： mybatis根据 dao的方法调用，获取执行sql语句的信息。
         *     mybatis根据你的dao接口，创建出一个dao接口的实现类， 并创建这个类的对象。
         *     完成SqlSession调用方法， 访问数据库。
         *
         */
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
