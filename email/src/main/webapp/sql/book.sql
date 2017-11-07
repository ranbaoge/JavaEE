/*
Navicat MySQL Data Transfer

Source Server         : ensong
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : book

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-11-06 17:49:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_accepter
-- ----------------------------
DROP TABLE IF EXISTS `t_accepter`;
CREATE TABLE `t_accepter` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `email` varchar(40) DEFAULT NULL,
  `eid` int(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk2` (`eid`),
  CONSTRAINT `fk2` FOREIGN KEY (`eid`) REFERENCES `t_email` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_accepter
-- ----------------------------
INSERT INTO `t_accepter` VALUES ('1', '3096365299@qq.com', '1');
INSERT INTO `t_accepter` VALUES ('2', '3096365299@qq.com', '2');
INSERT INTO `t_accepter` VALUES ('3', 'hdy937309420@sina.com', '3');

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book` (
  `bid` int(6) NOT NULL AUTO_INCREMENT,
  `bname` varchar(60) NOT NULL,
  `bauthor` varchar(20) DEFAULT NULL,
  `bpublisher` varchar(100) DEFAULT NULL,
  `bpublishDate` datetime DEFAULT NULL,
  `bcid` int(6) DEFAULT NULL,
  PRIMARY KEY (`bid`),
  UNIQUE KEY `bname` (`bname`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO `t_book` VALUES ('1', 'Java并发编程实践', 'hello', '中国工业出版社', '2015-02-10 00:00:00', '1');
INSERT INTO `t_book` VALUES ('2', 'Myql从删库到跑路', 'Leon', '机械出版社', '2014-05-13 00:00:00', '1');
INSERT INTO `t_book` VALUES ('3', '西游记', '吴承恩', '中国文学出版社', '2014-05-05 00:00:00', '2');
INSERT INTO `t_book` VALUES ('5', 'Steam', 'G胖', 'V社', '2010-01-04 00:00:00', '1');
INSERT INTO `t_book` VALUES ('6', '钢铁是怎样炼成的', '???', '文学出版社', '2017-11-08 00:00:00', '2');
INSERT INTO `t_book` VALUES ('8', '国名人妖校爹', '邱志和', '志和出版社', '2017-11-06 00:00:00', '2');
INSERT INTO `t_book` VALUES ('9', '哈姆雷特', '威廉·莎士比亚', '英国出版社', '2017-02-06 00:00:00', '2');
INSERT INTO `t_book` VALUES ('11', '杨锦浩与狗不得不说的故事', '邱志和', '绿帽社', '2017-11-13 00:00:00', '1');
INSERT INTO `t_book` VALUES ('14', '阿花（和）的少女情怀', '罗贯中', '中国日报', '2017-11-16 00:00:00', '2');
INSERT INTO `t_book` VALUES ('15', '林炯校之3D肉蒲团', '杨景浩', '深圳人民日报', '2017-11-06 00:00:00', '2');
INSERT INTO `t_book` VALUES ('16', '', '', '', null, '1');
INSERT INTO `t_book` VALUES ('18', '志和卖淫记', '林炯校', '罗哥出版社', '2017-11-17 00:00:00', '2');
INSERT INTO `t_book` VALUES ('26', '立体构成', 'Korin', '中国工业出版社', '2015-02-17 00:00:00', '3');
INSERT INTO `t_book` VALUES ('27', '完美世界', '辰东', '文学作品出版社', '2017-11-10 00:00:00', '2');
INSERT INTO `t_book` VALUES ('28', '流畅的Pyhton', 'Leon', '中国工业出版社', '2016-02-19 00:00:00', '1');
INSERT INTO `t_book` VALUES ('29', '第一行代码', '郭霖', '人民邮电', '2016-06-08 00:00:00', '1');
INSERT INTO `t_book` VALUES ('37', '杨锦浩与狗', '阿花', '绿帽社', '2017-11-02 00:00:00', '1');
INSERT INTO `t_book` VALUES ('40', 'Linux基础', 'Leon', '中国工业出版社', '2017-11-06 00:00:00', '1');
INSERT INTO `t_book` VALUES ('41', 'C++', 'Leon', '机械出版社', '2017-11-08 00:00:00', '1');
INSERT INTO `t_book` VALUES ('42', 'Python爬虫', 'Leon', '中国文学出版社', '2017-11-01 00:00:00', '1');
INSERT INTO `t_book` VALUES ('43', 'Java面试宝典', 'Leon', '中国工业出版社', '2017-10-31 00:00:00', '1');
INSERT INTO `t_book` VALUES ('44', '三国演义', 'Leon', '中国工业出版社', '2017-11-01 00:00:00', '2');
INSERT INTO `t_book` VALUES ('45', 'C', 'Leon', '中国工业出版社', '2017-11-06 00:00:00', '1');
INSERT INTO `t_book` VALUES ('48', '杨锦浩与狗的故事', '阿花', '绿帽社', '2017-11-01 00:00:00', null);
INSERT INTO `t_book` VALUES ('49', 'Nginx', 'Leon', '中国工业出版社', '2017-11-01 00:00:00', '1');
INSERT INTO `t_book` VALUES ('50', 'Redis', 'Leon', '中国工业出版社', '2017-11-01 00:00:00', '1');
INSERT INTO `t_book` VALUES ('51', 'Zooper', 'Leon', '中国工业出版社', '2017-11-02 00:00:00', '1');
INSERT INTO `t_book` VALUES ('52', '杨锦浩与狗不得不说的故事啊', '邱志和', '绿帽社', '2017-11-09 00:00:00', '4');
INSERT INTO `t_book` VALUES ('53', '杨锦浩与狗不得不说的故事2', '邱志和', '绿帽社', '2017-11-01 00:00:00', '2');
INSERT INTO `t_book` VALUES ('54', '杨锦浩与狗不得不说的故事3', '邱志和', '绿帽社', '2017-11-03 00:00:00', '2');
INSERT INTO `t_book` VALUES ('55', '杨锦浩与狗不得不说的故事4', '邱志和', '绿帽社', '2017-11-04 00:00:00', '2');
INSERT INTO `t_book` VALUES ('56', '杨锦浩与狗不得不说的故事5', '邱志和', '绿帽社', '2017-11-04 00:00:00', '2');
INSERT INTO `t_book` VALUES ('57', '杨锦浩与狗不得不说的故事6', '邱志和', '绿帽社', '2017-11-04 00:00:00', '4');

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category` (
  `cid` int(6) NOT NULL AUTO_INCREMENT,
  `cname` varchar(40) NOT NULL,
  PRIMARY KEY (`cid`),
  UNIQUE KEY `cname` (`cname`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO `t_category` VALUES ('2', '文学');
INSERT INTO `t_category` VALUES ('4', '法律');
INSERT INTO `t_category` VALUES ('3', '艺术');
INSERT INTO `t_category` VALUES ('1', '计算机');
INSERT INTO `t_category` VALUES ('5', '金融');

-- ----------------------------
-- Table structure for t_email
-- ----------------------------
DROP TABLE IF EXISTS `t_email`;
CREATE TABLE `t_email` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `content` varchar(8000) DEFAULT NULL,
  `subject` varchar(300) DEFAULT NULL,
  `filePath` varchar(300) DEFAULT NULL,
  `fileName` varchar(400) DEFAULT NULL,
  `uid` int(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk1` (`uid`),
  CONSTRAINT `fk1` FOREIGN KEY (`uid`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_email
-- ----------------------------
INSERT INTO `t_email` VALUES ('1', '34334', 'we', 'D:\\Java\\Tomcat\\apache-tomcat-8.0.45-windows-x64\\apache-tomcat-8.0.45\\webapps\\SpringEmail\\upload\\Lighthouse.jpg', 'Lighthouse.jpg', '1');
INSERT INTO `t_email` VALUES ('2', '今天学习了Spring整合Email发送邮件', 'IDEA发布邮件', 'D:\\Java\\Tomcat\\apache-tomcat-8.0.45-windows-x64\\apache-tomcat-8.0.45\\webapps\\SpringEmail\\upload\\ComPerformance-master.zip', 'ComPerformance-master.zip', '1');
INSERT INTO `t_email` VALUES ('3', '今天天气真好', '2017-11-05', 'D:\\Java\\Tomcat\\apache-tomcat-8.0.45-windows-x64\\apache-tomcat-8.0.45\\webapps\\SpringEmail\\upload\\ComPerformance-master.zip', 'ComPerformance-master.zip', '1');
INSERT INTO `t_email` VALUES ('4', '今天天气真好', '2017-11-05', 'D:\\Java\\Tomcat\\apache-tomcat-8.0.45-windows-x64\\apache-tomcat-8.0.45\\webapps\\SpringEmail\\upload\\c3p0-0.9.1.2.jar', 'c3p0-0.9.1.2.jar', '1');
INSERT INTO `t_email` VALUES ('5', '今天天气真好', '2017-11-05', 'D:\\Java\\Tomcat\\apache-tomcat-8.0.45-windows-x64\\apache-tomcat-8.0.45\\webapps\\SpringEmail\\upload\\c3p0-0.9.1.2.pom', 'c3p0-0.9.1.2.pom', '1');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `email` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'Leonhardt', 'zmxnnszmiftqbbgi', '937309420@qq.com');
INSERT INTO `t_user` VALUES ('2', 'admin', 'MTIzNDU2', '4234324@qq.com');

-- ----------------------------
-- View structure for v_book
-- ----------------------------
DROP VIEW IF EXISTS `v_book`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_book` AS select `t_book`.`bname` AS `bname`,`t_book`.`bauthor` AS `bauthor` from `t_book` ;
