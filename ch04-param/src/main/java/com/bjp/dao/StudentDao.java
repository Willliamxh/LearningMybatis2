package com.bjp.dao;

import com.bjp.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Willam_xh
 * @Date 2021-12-06 15:11
 */
public interface StudentDao {
    /**
     * 一个简单类型的参数：
     *   简单类型： mybatis把java的基本数据类型和String都叫简单类型。
     *  在mapper文件获取简单类型的一个参数的值，使用 #{任意字符}
     */
    public Student selectStudentById(Integer id);

    /**
     * 多个参数： 命名参数，在形参定义的前面加入 @Param("自定义参数名称")
     */
    List<Student> selectMultiParam(@Param("myname") String name,
                                   @Param("myage") Integer age);




}
