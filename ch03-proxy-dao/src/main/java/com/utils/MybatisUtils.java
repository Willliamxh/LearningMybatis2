package com.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author Willam_xh
 * @Date 2021-12-06 14:42
 */
public class MybatisUtils {

    private static SqlSessionFactory factory=null;

    static{
        String config="mybatis.xml";//序号和你项目中的文件一样
        try {
            InputStream in = Resources.getResourceAsStream(config);
            //创建sqlSessionFactory对象，使用sqlSessionFactorybuild
            factory=new SqlSessionFactoryBuilder().build(in);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取sqlSession的方法
    public static SqlSession getSqlSession(){
        SqlSession sqlSession=null;
        if(factory!=null){
            sqlSession=factory.openSession();//非自动提交事务
        }
        return sqlSession;
    }
}
