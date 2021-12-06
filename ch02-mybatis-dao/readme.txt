ch02 传统的dao的执行方式


1.pojo类
2.定义对应的mapper接口
3.封装好了对应sqlSession获取类
--------------------------
定义对应的mybatis.xml配置信息,放在resources中
使用Resources类去获取对应的配置信息
使用SqlSessionFactoryBuilder去get resource得到的配置信息，并且建立SqlSessionFactory
使用SqlSessionFactory构建SqlSession
----------------------------
4.实现接口对应的对应的impl类
----------------------------
   使用SqlSession去获取对应的mapper文件中的sql坐标， //【重要】指定要执行的sql语句的标识。sql映射文件中的namespace + '.' +标签的id值
   执行sqlSession，提交，关闭
----------------------------

