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

2.4.2 传统 Dao 开发方式的分析
在前面例子中自定义 Dao 接口实现类时发现一个问题： Dao 的实现类其实并没有干什么实质性的工
作，它仅仅就是通过 SqlSession 的相关 API 定位到映射文件 mapper 中相应 id 的 SQL 语句，真正对 DB 进
行操作的工作其实是由框架通过 mapper 中的 SQL 完成的。
所以， MyBatis 框架就抛开了 Dao 的实现类，直接定位到映射文件 mapper 中的相应 SQL 语句，对
DB 进行操作。这种对 Dao 的实现方式称为 Mapper 的动态代理方式。
Mapper 动态代理方式无需程序员实现 Dao 接口。接口是由 MyBatis 结合映射文件自动生成的动态代
理实现的