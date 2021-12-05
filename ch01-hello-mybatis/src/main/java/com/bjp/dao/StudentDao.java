package com.bjp.dao;

import com.bjp.domain.Student;

import java.util.List;

/**
 * @Author Willam_xh
 * @Date 2021-12-05 15:44
 */
public interface StudentDao {
    //查询student表的所有的数据
    public List<Student> selectStudents();

}
