cho1-hello-mybatis:第一个入门的mybatis例子
实现步骤:
1．新建的student表
2．加入maven的mybatis坐标,mysql驱动的坐标
3．创建实体类,student--保存表中的一行数据的
4．创建持久层的dao接口，定义操作数据库的方法
5．创建一个mybatis使用的配置文件叫做sql映射文件:写sql语句的。一般一个表一个sql映射文件。这个文件是xml文件。

6．创建mybatis的主配置文件:一个项目就一个主配置文件。主配置文件提供了数据库的连接信息和sql映射文件的位置信息

7.创建使用mybatis类，
通过mybatis访问数据库

总结一下ch01的mybatis整个步骤：
1.pojo类
2.定义对应的mapper接口（但是在ch01中接口并没有被使用）
3.定义对应的mybatis.xml配置信息,放在resources中
4.使用Resources类去获取对应的配置信息
5.使用SqlSessionFactoryBuilder去get resource得到的配置信息，并且建立SqlSessionFactory
6.使用SqlSessionFactory构建SqlSession
7.使用SqlSession去获取对应的mapper文件中的sql坐标， //6.【重要】指定要执行的sql语句的标识。sql映射文件中的namespace + '.' +标签的id值
8.执行 提交 关闭

