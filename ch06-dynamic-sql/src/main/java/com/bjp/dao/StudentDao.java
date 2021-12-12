package com.bjp.dao;

import com.bjp.domain.Student;

import java.util.List;

/**
 * @Author Willam_xh
 * @Date 2021-12-06 15:11
 */
public interface StudentDao {
    //动态sql ，使用java对象作为参数
    List<Student> selectStudentIf(Student student);

    //where使用
    List<Student> selectStudentWhere(Student student);

    //foreach 用法 1
    List<Student> selectForeachOne(List<Integer> idlist);

    //foreach 用法 2
    List<Student> selectForeachTwo(List<Student> stulist);


    //使用PageHelper分页数据
    List<Student> selectAll();

}
