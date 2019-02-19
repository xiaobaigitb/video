/*
SQLyog Ultimate v12.5.0 (64 bit)
MySQL - 5.5.49 : Database - ly_video
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ly_video` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ly_video`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(50) NOT NULL,
  `login_pwd` varchar(50) NOT NULL,
  `insert_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`id`,`login_name`,`login_pwd`,`insert_time`,`update_time`) values 
(1,'abc','96e79218965eb72c92a549dd5a330112',NULL,NULL);

/*Table structure for table `caller` */

DROP TABLE IF EXISTS `caller`;

CREATE TABLE `caller` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `visitor_name` varchar(64) DEFAULT NULL,
  `tel` varchar(64) DEFAULT NULL,
  `intent` varchar(64) DEFAULT NULL,
  `age` varchar(64) DEFAULT NULL,
  `sex` varchar(64) DEFAULT NULL,
  `class_time` varchar(64) DEFAULT NULL,
  `already_Time` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8;

/*Data for the table `caller` */

insert  into `caller`(`id`,`visitor_name`,`tel`,`intent`,`age`,`sex`,`class_time`,`already_Time`) values 
(19,'jack','123456','WEB前端','12','男','5个月','三天'),
(66,'黎明','1539762574','WEB前端','12','男','23天','一星期'),
(67,'天明','987654','WEB前端','45','女','6个月','23天'),
(69,'嗷嗷','1234567','WEB前端','23','女','23天','暂无学习');

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(50) DEFAULT NULL COMMENT '课程名称',
  `course_descr` varchar(255) DEFAULT NULL COMMENT '课程简介',
  `insert_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `subject_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `course` */

insert  into `course`(`id`,`course_name`,`course_descr`,`insert_time`,`update_time`,`subject_id`) values 
(6,'Web前端入门小项目','适合无编程基础但想学H5前端开发的同学入门学习，也适合UI、Java、PHP等其他学科学员预习或练习。本课程通过新闻页面、个人主页、个人简历、场景秀等多个项目案例由浅入深以项目实战的方式让同学们体验到前端开发乐趣。本课程突出实战，如果希望深入学习课程中涉及到的知识可报名学习智泷前端开发课程。',NULL,'2017-07-25 11:20:25',1),
(7,'Java编程与javaEE企业开发','Java是一种跨平台，适合于分布式计算环境的面向对象编程语言。想进一步学习Java进阶部分的同学可报名智泷前端开发课程。',NULL,'2017-07-25 11:20:24',2),
(8,'每天20分钟轻松入门React','适合有一定HTML+JS基础、想学习React的同学。本课程循序渐进、浅显易懂，非常适合React入门学习。想进一步学习和使用React进行开发的同学可以报名智泷前端开发课程。',NULL,'2017-07-25 11:20:21',3),
(9,'UI基础入门','适合无设计基础但想学UI设计的同学学习。本课程零基础入门，扎实的软件基础、高端的图形创意、资深产品经理的面对面授课尽在智游UI设计课程，希望成为全能设计师的你可报名智泷UI设计课程。',NULL,'2017-07-25 11:20:19',6),
(11,'Python编程零基础入门','适合无编程基础但想学Python的同学学习。本课程完全零基础入门，如果希望深入学习Python开发可报名学习智泷Python企业开发课程。',NULL,'2017-07-25 11:20:16',10),
(13,'轻松进击PHP基础','适合无编程基础但想学PHP开发的同学学习。本课程零基础入门，学习完本节课程相信同学们都轻松入门PHP开发，如果希望深入学习PHP开发可报名学习智泷PHP课程，资深”老司机”带你完成PHP大牛的进阶之路！',NULL,'2017-07-25 11:20:15',11);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `role_name` varchar(64) DEFAULT NULL COMMENT '权限名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`id`,`role_name`) values 
(1,'caller'),
(2,'user'),
(3,'super');

/*Table structure for table `speaker` */

DROP TABLE IF EXISTS `speaker`;

CREATE TABLE `speaker` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `speaker_name` varchar(30) DEFAULT NULL,
  `speaker_job` varchar(30) DEFAULT NULL,
  `speaker_head_url` varchar(255) DEFAULT NULL,
  `speaker_descr` varchar(255) DEFAULT NULL,
  `insert_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `speaker` */

insert  into `speaker`(`id`,`speaker_name`,`speaker_job`,`speaker_head_url`,`speaker_descr`,`insert_time`,`update_time`) values 
(7,'赵桂丹','高级讲师','https://img3.doubanio.com/view/photo/m/public/p2547804944.webp','H5第1期学员，毕业后留校任助教职务。精通H5课程内容，先后参与过智游教育网站、移动网站、微网站、课时管理系统等多个项目的开发工作。','2019-02-12 18:40:21','2019-02-12 18:40:21'),
(8,'张强','高级讲师','https://img3.doubanio.com/view/photo/m/public/p2547804946.webp','高级工程师，曾供职于多家公司，参与过多个企业级项目研发。对H5、iOS客户端开发及混合开发有深入的研究，熟悉PHP等服务端技术，有着多年的开发经验和教学经验。','2019-02-12 18:40:21','2019-02-12 18:40:21'),
(9,'田原惠子','高级讲师','https://img3.doubanio.com/view/photo/m/public/p2547804943.webp','Aotodesk国际认证动画师，精通架构设计、效果图表达、APP特效等。多年产品经理经验。  代表作品：《手机博物馆》，《诺客商城》、《途铂旅行》。','2019-02-12 18:40:21','2019-02-12 18:40:21'),
(10,'邢志勇','高级讲师','https://img3.doubanio.com/view/photo/m/public/p2547804945.webp','5年应用及平台开发经验，主导并参与多款商业、非商业性质软件的研发工作，精通Web前端、Python服务端、iOS手机App研发、VR开发、Unity3D开发等技术。','2019-02-12 18:40:21','2019-02-12 18:40:21'),
(11,'宋玮','高级讲师','https://img1.doubanio.com/view/photo/m/public/p2547804948.webp','多年PHP开发经验，参与过多个WEB项目开发，带领团队开发过CRM系统、OA系统、项目管理系统、SEM平台。精通PHP及多款开发框架、MySQL集群、Linux服务器运维、H5前端开发。','2019-02-12 18:40:21','2019-02-12 18:40:21');

/*Table structure for table `subject` */

DROP TABLE IF EXISTS `subject`;

CREATE TABLE `subject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subject_name` varchar(255) DEFAULT NULL COMMENT '学科名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='学科表信息，只使用数据，不在页面中维护';

/*Data for the table `subject` */

insert  into `subject`(`id`,`subject_name`) values 
(1,'WEB前端'),
(2,'JAVA编程基础'),
(3,'React'),
(4,'IOS'),
(5,'大数据'),
(6,'UI'),
(7,'VR'),
(8,'U3D'),
(9,'人工智能'),
(10,'Python'),
(11,'PHP');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nick_name` varchar(50) DEFAULT NULL COMMENT '昵称',
  `sex` int(11) DEFAULT '0' COMMENT '性别，2女1男',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱，唯一，登录账号',
  `province` varchar(20) DEFAULT NULL COMMENT '省',
  `city` varchar(20) DEFAULT NULL COMMENT '城市',
  `head_url` varchar(255) DEFAULT NULL COMMENT '头像地址',
  `password` varchar(50) DEFAULT NULL COMMENT '登录密码',
  `insert_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `captcha` varchar(20) DEFAULT NULL COMMENT '验证码',
  `status` int(10) DEFAULT NULL COMMENT '用户的状态:0-刚注册，1修改之后',
  `subject_id` int(11) DEFAULT NULL COMMENT '课程id',
  `role_id` int(11) DEFAULT NULL COMMENT '所属权限id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='前台注册用户信息';

/*Data for the table `user` */

insert  into `user`(`id`,`nick_name`,`sex`,`birthday`,`email`,`province`,`city`,`head_url`,`password`,`insert_time`,`update_time`,`captcha`,`status`,`subject_id`,`role_id`) values 
(1,'spark',2,'2018-11-15','1597713462@qq.com','湖北','武汉','1549886032790_head.jpg','e10adc3949ba59abbe56e057f20f883e','2018-11-12 15:16:45','2019-01-10 11:09:40',NULL,1,9,3),
(6,'IT晓白',2,'2018-11-15','251145912@qq.com','上海','虹口区','1542205724752_head.jpg','141f5767b1f5493495506bdbf7812d2b','2018-11-12 16:59:35','2018-11-12 17:00:00',NULL,1,1,2),
(9,'关羽',1,'2019-02-12','1569845303@qq.com',NULL,'上海',NULL,'9bc495ea138134bd4d8913644c20b164','2019-02-14 19:50:54',NULL,NULL,1,1,2),
(10,'赵云',1,NULL,'1597713461@qq.com',NULL,'北京',NULL,'141f5767b1f5493495506bdbf7812d2b',NULL,NULL,NULL,1,5,2),
(12,'张飞',2,NULL,'1597713465@qq.com',NULL,'广州',NULL,'141f5767b1f5493495506bdbf7812d2b',NULL,NULL,NULL,1,3,2),
(14,'天驰',1,NULL,'1597713468@qq.com',NULL,'上海',NULL,'141f5767b1f5493495506bdbf7812d2b',NULL,NULL,NULL,1,9,2),
(17,'尚硅谷',2,'2019-02-16','1713462@qq.com','黑龙江','牡丹江',NULL,'141f5767b1f5493495506bdbf7812d2b','2019-02-15 22:15:40','2019-02-15 22:16:11',NULL,1,5,2);

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `role_id` int(11) DEFAULT NULL COMMENT '权限ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

/*Data for the table `user_role` */

insert  into `user_role`(`id`,`user_id`,`role_id`) values 
(1,1,3),
(2,6,2),
(3,8,2),
(10,9,3),
(11,10,2),
(12,12,2),
(20,14,2),
(21,15,2),
(22,6,2),
(23,16,2),
(24,17,2),
(25,17,2),
(26,17,2),
(27,17,2),
(28,17,2),
(29,17,2),
(30,17,2),
(31,17,2),
(32,9,2),
(33,6,2),
(34,6,2);

/*Table structure for table `video` */

DROP TABLE IF EXISTS `video`;

CREATE TABLE `video` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `video_title` varchar(255) DEFAULT NULL COMMENT '视频标题',
  `speaker_id` int(11) DEFAULT NULL COMMENT '主讲人id',
  `course_id` int(11) DEFAULT NULL COMMENT '所属课程id',
  `video_length` int(11) DEFAULT NULL,
  `video_image_url` varchar(255) DEFAULT NULL,
  `video_url` varchar(255) DEFAULT NULL,
  `video_descr` varchar(255) DEFAULT NULL,
  `insert_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `video_play_times` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

/*Data for the table `video` */

insert  into `video`(`id`,`video_title`,`speaker_id`,`course_id`,`video_length`,`video_image_url`,`video_url`,`video_descr`,`insert_time`,`update_time`,`video_play_times`) values 
(1,'前端开发环境搭建',7,6,562,'https://img1.doubanio.com/view/status/l/public/873c2d05f80259a.webp','https://pan.baidu.com/s/12wrbpW_ZiQSWtxZeCTZI7A','前端开发环境的搭建，包括前端常用开发工具介绍、VS Code下载安装，以及前端开发常用运行工具--浏览器的介绍、Firefox下载安装等内容。帮助大家准备好前端开发环境以便深入学习后续小项目',NULL,NULL,559),
(2,'HTML页面基本结构',9,6,596,'https://img1.doubanio.com/view/status/l/public/873c2d05f80259a.webp','https://pan.baidu.com/s/12wrbpW_ZiQSWtxZeCTZI7A','前端开发主要技术和在项目中的作用、HTML标签基本结构、HTML文档基本结构、字符编码问题及开发一个简单的页面。',NULL,'2019-02-12 18:50:59',377),
(3,'认识线性图标',9,9,1421,'https://img3.doubanio.com/view/status/l/public/8795b2c5632ab91.webp','http://vod.zhiyou100.com/gkk/ui/c1/01.mp4','初识UI，本节课主要讲解UI设计及产品经理课程中的第一小节：线性图标设计，包括：图标的定义、图标的用途分类、线性图标的设计原则，最后老师还给大家布置了一个有趣的作业，聪明机智的你来一起学习吧！',NULL,NULL,382),
(4,'新闻页面开发',7,6,1374,'https://img1.doubanio.com/view/status/l/public/873c2d05f80259a.webp','http://vod.zhiyou100.com/gkk/h5/c1/03.mp4',' 新闻页面的开发，包括前端开发中最常用的HTML标签：H1、P、DIV、SPAN、IMG、A等，还包括控制文字、图片、超链接等最常用的CSS样式。',NULL,'2019-02-12 18:50:59',357),
(5,'了解PHP',11,13,1268,'https://img3.doubanio.com/view/status/l/public/241c08b50419ca6.webp','http://vod.zhiyou100.com/gkk/php/c1/01.mp4','讲解了PHP的基本概述，帮助大家对PHP语言有一个大体的认知，包括：什么是PHP、PHP的优势、智游教育的PHP课程、Lamp与wamp的介绍、开发环境和开发工具的的配置、PHP基本语法。',NULL,NULL,343),
(6,'React快速体验-组件',8,8,907,'https://img3.doubanio.com/view/status/l/public/3cf9ae7e5924f54.webp','http://vod.zhiyou100.com/gkk/h5/c3/01.mp4','介绍了React的前生今世，让同学们了解库文件下载和整体的React项目结构及React库最简单的使用。',NULL,NULL,195),
(7,'个人主页项目开发-1',7,6,1692,'https://img1.doubanio.com/view/status/l/public/873c2d05f80259a.webp','http://vod.zhiyou100.com/gkk/h5/c1/05-1.mp4','个人主页项目的演示、页面结构分析、包括网页常见的构成：页头、LOGO、横幅、导航、主体、页脚等。在页头开发过程中使用了固定位置、定宽居中等常见的布局模式。',NULL,NULL,294),
(8,'React创建组件的方法',8,8,749,'https://img3.doubanio.com/view/status/l/public/3cf9ae7e5924f54.webp','http://vod.zhiyou100.com/gkk/h5/c3/02.mp4','详细介绍了最简单的React组件的创建、使用及组件之间的简单嵌套使用。',NULL,NULL,165),
(9,'ES6重写组件和生命周期',8,8,1195,'https://img3.doubanio.com/view/status/l/public/3cf9ae7e5924f54.webp','http://vod.zhiyou100.com/gkk/h5/c3/03.mp4','使用ES6语法重写React组件，更简洁的语法，更清晰的思路，同时介绍了React组件的生命周期。',NULL,NULL,188),
(10,'个人主页项目开发-2',7,6,1699,'https://img1.doubanio.com/view/status/l/public/873c2d05f80259a.webp','http://vod.zhiyou100.com/gkk/h5/c1/05-2.mp4','个人主页项目页面主体部分的开发，大量使用了定宽居中的技术，在我的同学部分还使用了相对定位、绝对定位等非常重要定位技术，还使用了圆形边框等CSS3新技术。',NULL,NULL,268),
(11,'使用JSX创建组件',8,8,1414,'https://img3.doubanio.com/view/status/l/public/3cf9ae7e5924f54.webp','http://vod.zhiyou100.com/gkk/h5/c3/04.mp4','使用JSX重写React单一组件、组合组件，了解React的组件化思想及JSX的使用。',NULL,NULL,263),
(12,'个人主页项目开发-3',7,6,409,'https://img1.doubanio.com/view/status/l/public/873c2d05f80259a.webp','http://vod.zhiyou100.com/gkk/h5/c1/05-3.mp4','个人主页的语义化重构。介绍了H5语义化的意义、将非语义化的DIV+CSS改造成语义化标签的具体实践过程。以及VS Code分割视图在开发中的应用。',NULL,'2019-02-12 18:50:59',240),
(13,'React虚拟DOM',8,8,1468,'https://img3.doubanio.com/view/status/l/public/3cf9ae7e5924f54.webp','http://vod.zhiyou100.com/gkk/h5/c3/05.mp4','React的快速响应魅力所在——虚拟DOM，本节课详细比较了普通DOM和虚拟DOM的区别。',NULL,NULL,250),
(14,'个人简历项目开发-1',7,6,2112,'https://img1.doubanio.com/view/status/l/public/873c2d05f80259a.webp','http://vod.zhiyou100.com/gkk/h5/c1/06-1.mp4','个人简历项目的开发。RGB颜色简介，字体简介及安装。本案例重度使用定位技术，使用了CSS3中新增的旋转图形变换技术。以及一些高级CSS选择器。',NULL,NULL,233),
(15,'个人简历项目开发-2',7,6,1997,'https://img1.doubanio.com/view/status/l/public/873c2d05f80259a.webp','http://vod.zhiyou100.com/gkk/h5/c1/06-2.mp4\"','个人简历项目开发的第二部分，包括字体的使用（注意：实际开发中会使用更高级的技术来使用字体）、背景图片的控制、内容溢出控制、绝对定位元素的层次控制、半透明的使用等。',NULL,NULL,208),
(16,'场景秀项目开发-1',7,6,1569,'https://img1.doubanio.com/view/status/l/public/873c2d05f80259a.webp','http://vod.zhiyou100.com/gkk/h5/c1/07-1.mp4','场景秀项目是一个手机页面、本部分介绍了响应式开发环境、viewport在响应式开发中的应用、vw/vh等响应式CSS单位的使用、CSS函数calc()在单位混合计算时的使用。',NULL,NULL,219),
(17,'场景秀项目开发-2',7,6,2179,'https://img1.doubanio.com/view/status/l/public/873c2d05f80259a.webp','http://vod.zhiyou100.com/gkk/h5/c1/07-2.mp4','场景秀动画部分的开发、本部分是场景秀开发的最出彩最重要的部分。包括关键帧动画的定义、平移动画、绽放动画等动画效果的实现方法。H5音频及JS控制音乐播放暂停。',NULL,NULL,223),
(18,'JAVA入门教程',7,7,320,'https://img1.doubanio.com/view/status/l/public/b786d9e25d4f21a.webp','http://vod.zhiyou100.com/gkk/h5/c2/01.mp4','Java是一门面向对象编程语言，不仅吸收了C++语言的各种优点，还摒弃了C++里难以理解的多继承、指针等概念，因此Java语言具有功能强大和简单易用两个特征。',NULL,'2019-02-12 18:50:59',211),
(19,'JAVA面向对象',7,7,1024,'https://img1.doubanio.com/view/status/l/public/b786d9e25d4f21a.webp','http://vod.zhiyou100.com/gkk/h5/c2/02.mp4','详细介绍java的面向过程思想，以及编程基础理论。',NULL,'2019-02-12 18:52:49',159),
(20,'响应式登录页面项目开发',7,6,2134,'https://img1.doubanio.com/view/status/l/public/873c2d05f80259a.webp','http://vod.zhiyou100.com/gkk/h5/c1/08.mp4','响应式页面开发与移动端适配，重点内容包括vw/vh单位、媒体查询的介绍及在移动端适配中的应用方法。表单及INPUT标签的基本使用和使用CSS控制表单样式的方法等。',NULL,NULL,244),
(21,'Java 高级教程之集合框架',7,7,385,'https://img1.doubanio.com/view/status/l/public/b786d9e25d4f21a.webp','http://vod.zhiyou100.com/gkk/h5/c2/03.mp4','在java中框架是非常有用的一个知识点，能够帮助编程者节省很多时间。',NULL,'2019-02-12 18:54:45',171),
(22,'Java 高级教程之SSM整合',7,7,355,'https://img1.doubanio.com/view/status/l/public/b786d9e25d4f21a.webp','http://vod.zhiyou100.com/gkk/h5/c2/04.mp4','详细讲解一下ssm框架的搭建以及项目的练习。SSM主要分为Spring、SpringMVC、mybatis。',NULL,'2019-02-12 18:56:12',221),
(23,'Python运行环境下载',10,11,350,'https://img1.doubanio.com/view/status/l/public/0a72278a8db2bd8.webp','http://vod.zhiyou100.com/gkk/python/c1/01.mp4','Python开发环境的搭建，Python的下载及安装，帮助大家准备好Python开发环境。',NULL,NULL,256),
(24,'Python运行环境安装',10,11,239,'https://img1.doubanio.com/view/status/l/public/0a72278a8db2bd8.webp','http://vod.zhiyou100.com/gkk/python/c1/02.mp4','Windows操作系统下面Python环境的安装及注意事项。',NULL,NULL,184),
(25,'IDLE的基本使用',10,11,1149,'https://img1.doubanio.com/view/status/l/public/0a72278a8db2bd8.webp','http://vod.zhiyou100.com/gkk/python/c1/03.mp4','Python自带编辑器IDLE的使用，初识Python的语法，简单语法的编写和运行。',NULL,NULL,195),
(26,'Sublime的基本使用',10,11,565,'https://img1.doubanio.com/view/status/l/public/0a72278a8db2bd8.webp','http://vod.zhiyou100.com/gkk/python/c1/04.mp4','Sublime的安装及基本使用，主要介绍了Sublime的智能提示功能，常用操作，例如新建文件、保存文件、字体设置、窗口背景颜色等。',NULL,NULL,166),
(27,'Print语句',10,11,805,'https://img1.doubanio.com/view/status/l/public/0a72278a8db2bd8.webp','http://vod.zhiyou100.com/gkk/python/c1/05.mp4','讲解Python中的语句概述，主要介绍了常用的Print语句，语法错误的解决，以及注释的写法。',NULL,NULL,192),
(28,'变量',10,11,332,'https://img1.doubanio.com/view/status/l/public/0a72278a8db2bd8.webp','http://vod.zhiyou100.com/gkk/python/c1/06.mp4','介绍了Python语法中的变量写法、使用以及变量命名中的注意事项。',NULL,NULL,270),
(29,'运算符',10,11,667,'https://img1.doubanio.com/view/status/l/public/0a72278a8db2bd8.webp','http://vod.zhiyou100.com/gkk/python/c1/07.mp4','讲解Python中运算符的基本使用，主要有算数运算符、比较运算符，介绍了三个双引号注释多行代码，',NULL,NULL,209),
(30,'If条件语句',10,11,1099,'https://img1.doubanio.com/view/status/l/public/0a72278a8db2bd8.webp','http://vod.zhiyou100.com/gkk/python/c1/08.mp4','讲解Python中的if条件语句，利用if语句进行简单的出租车价格计算。',NULL,NULL,194),
(31,'While循环',10,11,1024,'https://img1.doubanio.com/view/status/l/public/0a72278a8db2bd8.webp','http://vod.zhiyou100.com/gkk/python/c1/09.mp4','介绍Python编程中的while循环语句的基本形式，语句格式等。',NULL,NULL,185),
(32,'For循环',10,11,1085,'https://img1.doubanio.com/view/status/l/public/0a72278a8db2bd8.webp','http://vod.zhiyou100.com/gkk/python/c1/10.mp4','讲解Python中的for循环，简单介绍了for循环的简单使用及语句格式。',NULL,NULL,168);

/*Table structure for table `vip` */

DROP TABLE IF EXISTS `vip`;

CREATE TABLE `vip` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(64) DEFAULT NULL COMMENT '用户邮箱',
  `payment` varchar(64) DEFAULT NULL COMMENT '支付方式',
  `total_money` int(64) DEFAULT NULL COMMENT '订单金额',
  `status` int(11) DEFAULT NULL COMMENT '0:未修改权限，1：已修改',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `vip` */

insert  into `vip`(`id`,`email`,`payment`,`total_money`,`status`) values 
(1,'1597713462@qq.com','支付宝',1200,1),
(2,'251145912@qq.com','微信',2250,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
