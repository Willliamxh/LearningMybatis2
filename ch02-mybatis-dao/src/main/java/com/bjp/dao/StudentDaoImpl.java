package com.bjp.dao;

import com.bjp.domain.Student;
import com.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.function.Consumer;

/**
 * @Author Willam_xh
 * @Date 2021-12-06 15:23
 */
public class StudentDaoImpl implements StudentDao{

    @Override
    public List<Student> selectStudents() {
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        String sqlId="com.bjp.dao.StudentDao.selectStudents";
        List<Student> studentList = sqlSession.selectList(sqlId);
        // studentList.forEach(student -> System.out.println(student));
        sqlSession.close();
        return studentList;
    }

    @Override
    public int insertStudent(Student student) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        String sqlId="com.bjp.dao.StudentDao.insertStudent";
        int insert = sqlSession.insert(sqlId,student);
        sqlSession.commit();
        sqlSession.close();

        return insert;
    }
}
