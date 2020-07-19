图书管理系统

## 项目简介:

该项目是个人完成的图书管理小项目。主要功能有：用户登录、图书查询、图书添加、图书修改、图书删除。

该项目主要应用了maven、spring boot、thymeleaf 、mybatis技术栈及mysql数据库进行开发。

## 项目路径说明：

src/main/java/com/example/book/BookApplication: spring boot主启动类

src/main/java/com/example/book/component:拦截器配置和swagger配置类

src/main/java/com/example/book/controller:控制层相关代码

src/main/java/com/example/book/dao：dao层相关代码

src/main/java/com/example/book/pojo：JavaBean相关代码

src/main/java/com/example/book/service：service层接口

src/main/java/com/example/book/service/impl：service层接口实现类

src/main/resources/application.yml:spring boot配置文件，主要有数据库相关配置及mybatis相关配置

src/main/resources/mapper：mybatis的mapper文件

src/main/resources/sql：sql文件，项目部署完成后，需在mysql数据库里执行该文件夹的sql文件，方可运行此项目

src/main/resources/templates：前端html文件


## 项目部署运行：
项目下载到本地后，根据本地mysql数据库配置修改application.yml的内容。执行src/main/resources/sql文件夹下的sql文件。运行BookApplication类即可启动本项目。

注意事项：本人使用的mysql是8.0版本。若是其他版本，需修改pom.xml的mysql驱动版本号和application.yml数据库驱动配置。



## 项目访问地址：

登录地址： http://localhost:8080/

登录账号：admin  登录密码：123456

swgger接口测试地址：http://localhost:8080/swagger-ui.html