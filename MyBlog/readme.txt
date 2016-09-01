

**********************************************************************
*************************开发须知***************************************
******注意：各个包里面，我都有实例，大家在开发中请按照我的格式来开发，并做好相应的注释**********
**********************************************************************

1、数据库脚本位置：
	该项目目录下的mysqlblog.sql,包括通用分页存储过程
	
2、src目录结构：
	我的域名为www.johnxiao.top,因此包名均已包名+项目名+对应模块来命名
	top.johnxiao.blog.core：项目核心包,存放DAO工厂类、数据库连接类
	top.johnxiao.blog.dao：DAO接口类，存放DAO接口类
	top.johnxiao.blog.dao.impl：DAO接口实现类
	top.johnxiao.blog.dto：存放DTO类
	top.johnxiao.blog.encrypt：自定义加密，解密类
	top.johnxiao.blog.filters：存放过滤器类
	top.johnxiao.blog.servlets：存放servlet类
	top.johnxiao.blog.util：存放其他工具类
	
3、dbInfo.properties：
	数据库连接信息配置文件，便于前期测试DAO类,在后期写servlet时记得把DButil类中的static注释掉，因为web.xml下对数据库连接做了配置
	
4、项目所需的jar包，我已经导入

5、web.xml的配置信息都做了注释，大家都看得懂
	注意：大家在开发时,自己写的和配置的一定做好标注，而且最好写在一起，和别人写的分开，便于后期集成

	