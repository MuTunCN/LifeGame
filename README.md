# LifeGame
## 项目简介
前端  AmazeUI+JSP 后端 Servlet+JDBC 数据库 MySQL 
一个 JavaWeb 的练手项目，模拟一个人一生经历的事情
## 安装部署
Eclipse编写，用Eclipse导入
使用`lifebase_life.sql`创建数据库和导入其中数据
改变`sqlConfig.properties`中的数据库信息
## 项目功能
![开始界面](http://ww1.sinaimg.cn/large/91e80714gy1g0l7ll8hf0j212y0g1jrq.jpg)
![游戏界面](http://ww1.sinaimg.cn/large/91e80714gy1g0l7n0xf8uj21h90apgmx.jpg)
![编辑界面](http://ww1.sinaimg.cn/large/91e80714gy1g0l7nemkn6j21go0nm0wu.jpg)
## 项目实现
**如何获取需要展示的数据**
1. 获取所有数据
2. 将数据按年龄分成不同的数组
3. 再逐个年龄数组中随机抽取词条放入结果数组直到抽到事件属性为`die`状态
4. 将结果数组转发到前端
**如何处理数据操作**
前端传入的参数`action`中记录了要进行什么操作,将每个操作公共部分提取,用`switch`对`action`进行选择,减少重复代码
**JDBC方面**
- 使用线程池`ThreadLocal`来管理连接
- 使用抽象类`BaseDaoImpl`继承线程池并把JDBC共有部分实现
- 使用事务来代替自动提交
- 将数据库连接信息读取自外部文档而不是写死在代码中，便于修改

# 编程时候的碎碎念
完成基本的框架搭建 完成数据库 和 简单的部分 

-----Mon May 02 22:35:43 CST 2016-----



完成curd的实现 测试dao时出现org.hibernate.engine.jdbc.env.spi.JdbcEnvironment 错误 找了快4小时没找到错误 在其他的herbernate 代码发现可运行 于是开始一个个的配对 发现都对的 在用那的代替我这的还是有问题 绝望了

-----Wed May 04 00:17:37 CST 2016-----

终于！完成增删改查，不过是不使用hebernate，用jdbc实现，明明可以一个下午完成的事情，做了俩天。我的天！

-----Wed May 04 16:22:54 CST 2016-----

大致完成了以前教的东西，一直在纠结是复制粘贴还是自己写，先有的想法是复制粘贴以写新的为主，后面觉得对，开始实施。后面再想网页端要怎么做，先想去拿模板，后面觉得还是直接用简单的，如果后面想的可以用css来装饰。现在要确定一个中心思想：以完成功能为主其他都是虚的。

-----Wed May 04 22:44:48 CST 2016-----

curd收收尾
完成了servlet获取jsp中单选框 再传到jsp中
完成mainServlet

-----Sat May 07 23:55:23 CST 2016-----

页面完成 遍历 称号颜色不同 

原因是不知道怎么在jsp中获取是否点击

-----Sun May 08 23:01:33 CST 2016-----

全部功能基本完成 在写入几个数据后 再启动发现jstl 和 jsp都不起作用了 另一个edit。jsp的工作正常 太奇怪！

-----Tue May 10 23:43:33 CST 2016-----

找到问题所在了 是setattribute设置在if语句里 所以没获取到 
又修复一些逻辑错误 正常走一遍没问题了

-----Wed May 11 09:35:09 CST 2016-----

编辑和主界面的css和功能全部完成

-----Sat May 14 20:56:01 CST 2016-----

最后还剩一个结论界面

-----Sun May 15 23:00:28 CST 2016-----

补充点数据 完成了
总结 基础薄弱都是在一边查一些写一边改想法 真的是摸着石头过河 

-----Fri May 20 13:40:46 CST 2016-----

交卷了

-----Fri Jun 03 09:48:02 CST 2016-----
