package com.bjp.dao;

import com.bjp.domain.Student;
import com.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Author Willam_xh
 * @Date 2021-12-06 15:23
 */
public class StudentDaoImpl implements StudentDao{

    @Override
    public List<Student> selectStudents() {
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();


        return null;
    }

    @Override
    public int insertStudent(Student student) {
        return 0;
    }
}
