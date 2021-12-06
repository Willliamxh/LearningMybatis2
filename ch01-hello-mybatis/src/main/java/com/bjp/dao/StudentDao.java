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

    //插入方法
    //参数： student ,表示要插入到数据库的数据
    //返回值： int ， 表示执行insert操作后的 影响数据库的行数
    public int insertStudent(Student student);

}
