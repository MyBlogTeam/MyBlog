/*
Navicat MySQL Data Transfer

Source Server         : sql_xiaowei
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : myblog

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2016-09-04 11:42:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admininfo`
-- ----------------------------
DROP TABLE IF EXISTS `admininfo`;
CREATE TABLE `admininfo` (
  `adminId` int(11) NOT NULL AUTO_INCREMENT,
  `adminName` varchar(30) NOT NULL,
  `adminPwd` varchar(40) NOT NULL,
  `adminTel` varchar(11) DEFAULT NULL,
  `adminEmail` varchar(30) DEFAULT NULL,
  `adminPic` varchar(1000) DEFAULT NULL,
  `adminIsDel` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admininfo
-- ----------------------------
INSERT INTO `admininfo` VALUES ('1', 'zhangsan', 'zhangsan', '123456', '123456@qq.com', null, '0');
INSERT INTO `admininfo` VALUES ('2', 'zhangsan', 'zhangsan', '123456', '123456@qq.com', null, '1');
INSERT INTO `admininfo` VALUES ('3', 'zhangsan', 'zhangsan', '123456', '123456@qq.com', null, '0');
INSERT INTO `admininfo` VALUES ('4', 'zhangsan', 'zhangsan', '123456', '123456@qq.com', null, '0');
INSERT INTO `admininfo` VALUES ('5', 'zhangsan', 'zhangsan', '123456', '123456@qq.com', null, '0');
INSERT INTO `admininfo` VALUES ('6', 'zhangsan', 'zhangsan', '123456', '123456@qq.com', null, '0');
INSERT INTO `admininfo` VALUES ('7', 'zhangsan', 'zhangsan', '123456', '123456@qq.com', null, '0');
INSERT INTO `admininfo` VALUES ('8', 'zhangsan', 'zhangsan', '123456', '123456@qq.com', null, '0');

-- ----------------------------
-- Table structure for `albuminfo`
-- ----------------------------
DROP TABLE IF EXISTS `albuminfo`;
CREATE TABLE `albuminfo` (
  `albumId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `albumName` varchar(40) NOT NULL,
  `albumState` int(11) DEFAULT NULL,
  `albumPwd` varchar(40) DEFAULT NULL,
  `albumQuest` varchar(255) DEFAULT NULL,
  `albumAnswer` varchar(125) DEFAULT NULL,
  `albumPic` varchar(1000) DEFAULT NULL,
  `albumIsDel` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`albumId`),
  KEY `FK_User_Album` (`userId`),
  CONSTRAINT `FK_User_Album` FOREIGN KEY (`userId`) REFERENCES `userinfo` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of albuminfo
-- ----------------------------

-- ----------------------------
-- Table structure for `articleinfo`
-- ----------------------------
DROP TABLE IF EXISTS `articleinfo`;
CREATE TABLE `articleinfo` (
  `articleId` int(11) NOT NULL AUTO_INCREMENT,
  `articleTitle` varchar(100) DEFAULT NULL,
  `articleDate` datetime DEFAULT NULL,
  `articleContent` text,
  `articlePeople` int(11) DEFAULT NULL,
  `articleState` int(11) DEFAULT NULL,
  `articlePic` varchar(1000) DEFAULT NULL,
  `articleIsDel` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`articleId`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of articleinfo
-- ----------------------------
INSERT INTO `articleinfo` VALUES ('1', '54321', '2016-09-02 14:53:46', '12345,坐车回学校！0', '0', '0', null, '0');
INSERT INTO `articleinfo` VALUES ('2', '今日哥就要回学校了！1', '2016-09-02 14:53:47', '12345,坐车回学校！1', '0', '0', null, '0');
INSERT INTO `articleinfo` VALUES ('3', '今日哥就要回学校了！2', '2016-09-02 14:53:47', '12345,坐车回学校！2', '0', '0', null, '0');
INSERT INTO `articleinfo` VALUES ('4', '今日哥就要回学校了！3', '2016-09-02 14:53:47', '12345,坐车回学校！3', '0', '0', null, '0');
INSERT INTO `articleinfo` VALUES ('5', '今日哥就要回学校了！4', '2016-09-02 14:53:47', '12345,坐车回学校！4', '0', '0', null, '0');
INSERT INTO `articleinfo` VALUES ('6', '今日哥就要回学校了！5', '2016-09-02 14:53:47', '12345,坐车回学校！5', '0', '0', null, '0');
INSERT INTO `articleinfo` VALUES ('7', '今日哥就要回学校了！6', '2016-09-02 14:53:47', '12345,坐车回学校！6', '0', '0', null, '0');
INSERT INTO `articleinfo` VALUES ('8', '今日哥就要回学校了！7', '2016-09-02 14:53:47', '12345,坐车回学校！7', '0', '0', null, '0');
INSERT INTO `articleinfo` VALUES ('9', '今日哥就要回学校了！8', '2016-09-02 14:53:47', '12345,坐车回学校！8', '0', '0', null, '0');
INSERT INTO `articleinfo` VALUES ('10', '今日哥就要回学校了！9', '2016-09-02 14:53:47', '12345,坐车回学校！9', '0', '0', null, '0');
INSERT INTO `articleinfo` VALUES ('11', '今日哥就要回学校了！10', '2016-09-02 14:53:47', '12345,坐车回学校！10', '0', '0', null, '0');
INSERT INTO `articleinfo` VALUES ('12', '今日哥就要回学校了！11', '2016-09-02 14:53:47', '12345,坐车回学校！11', '0', '0', null, '0');
INSERT INTO `articleinfo` VALUES ('13', '今日哥就要回学校了！12', '2016-09-02 14:53:47', '12345,坐车回学校！12', '0', '0', null, '0');
INSERT INTO `articleinfo` VALUES ('14', '今日哥就要回学校了！13', '2016-09-02 14:53:47', '12345,坐车回学校！13', '0', '0', null, '0');
INSERT INTO `articleinfo` VALUES ('15', '今日哥就要回学校了！14', '2016-09-02 14:53:47', '12345,坐车回学校！14', '0', '0', null, '0');
INSERT INTO `articleinfo` VALUES ('16', '今日哥就要回学校了！15', '2016-09-02 14:53:47', '12345,坐车回学校！15', '0', '0', null, '0');
INSERT INTO `articleinfo` VALUES ('17', '今日哥就要回学校了！16', '2016-09-02 14:53:47', '12345,坐车回学校！16', '0', '0', null, '0');
INSERT INTO `articleinfo` VALUES ('18', '今日哥就要回学校了！17', '2016-09-02 14:53:47', '12345,坐车回学校！17', '0', '0', null, '0');
INSERT INTO `articleinfo` VALUES ('19', '今日哥就要回学校了！18', '2016-09-02 14:53:47', '12345,坐车回学校！18', '0', '0', null, '0');
INSERT INTO `articleinfo` VALUES ('20', '今日哥就要回学校了！19', '2016-09-02 14:53:47', '12345,坐车回学校！19', '0', '0', null, '0');
INSERT INTO `articleinfo` VALUES ('21', '今日哥就要回学校了！20', '2016-09-02 14:53:47', '12345,坐车回学校！20', '0', '0', null, '0');
INSERT INTO `articleinfo` VALUES ('22', '今日哥就要回学校了！21', '2016-09-02 14:53:47', '12345,坐车回学校！21', '0', '0', null, '0');
INSERT INTO `articleinfo` VALUES ('23', '今日哥就要回学校了！22', '2016-09-02 14:53:47', '12345,坐车回学校！22', '0', '0', null, '0');
INSERT INTO `articleinfo` VALUES ('24', '今日哥就要回学校了！23', '2016-09-02 14:53:47', '12345,坐车回学校！23', '0', '0', null, '0');
INSERT INTO `articleinfo` VALUES ('25', '今日哥就要回学校了！24', '2016-09-02 14:53:47', '12345,坐车回学校！24', '0', '0', null, '0');

-- ----------------------------
-- Table structure for `authsinfo`
-- ----------------------------
DROP TABLE IF EXISTS `authsinfo`;
CREATE TABLE `authsinfo` (
  `authsId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `authsType` varchar(40) DEFAULT NULL,
  `authsToken` varchar(100) DEFAULT NULL,
  `authsExpires` varchar(100) DEFAULT NULL,
  `authsIsDel` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`authsId`),
  KEY `FK_User_Auths` (`userId`),
  CONSTRAINT `FK_User_Auths` FOREIGN KEY (`userId`) REFERENCES `userinfo` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of authsinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `bloginfo`
-- ----------------------------
DROP TABLE IF EXISTS `bloginfo`;
CREATE TABLE `bloginfo` (
  `blogId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `blogName` varchar(50) DEFAULT NULL,
  `blogDesc` varchar(500) DEFAULT NULL,
  `blogDate` datetime DEFAULT NULL,
  `blogState` int(11) DEFAULT NULL,
  `blogMusic` varchar(1000) DEFAULT NULL,
  `blogPic` varchar(1000) DEFAULT NULL,
  `blogIsDel` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`blogId`),
  KEY `FK_User_Blog` (`userId`),
  CONSTRAINT `FK_User_Blog` FOREIGN KEY (`userId`) REFERENCES `userinfo` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bloginfo
-- ----------------------------

-- ----------------------------
-- Table structure for `clicklikeinfo`
-- ----------------------------
DROP TABLE IF EXISTS `clicklikeinfo`;
CREATE TABLE `clicklikeinfo` (
  `likeId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `likeType` int(11) DEFAULT NULL,
  `likedId` int(11) DEFAULT NULL,
  `likeDate` datetime DEFAULT NULL,
  `likeIsDel` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`likeId`),
  KEY `FK_User_Like` (`userId`),
  CONSTRAINT `FK_User_Like` FOREIGN KEY (`userId`) REFERENCES `userinfo` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clicklikeinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `collectinfo`
-- ----------------------------
DROP TABLE IF EXISTS `collectinfo`;
CREATE TABLE `collectinfo` (
  `collectId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `articleId` int(11) NOT NULL,
  `collectDate` datetime DEFAULT NULL,
  `collectIsDel` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`collectId`),
  KEY `FK_CollectInfo` (`userId`),
  KEY `FK_CollectInfo2` (`articleId`),
  CONSTRAINT `FK_CollectInfo` FOREIGN KEY (`userId`) REFERENCES `userinfo` (`userId`),
  CONSTRAINT `FK_CollectInfo2` FOREIGN KEY (`articleId`) REFERENCES `articleinfo` (`articleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collectinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `discussinfo`
-- ----------------------------
DROP TABLE IF EXISTS `discussinfo`;
CREATE TABLE `discussinfo` (
  `discussId` int(11) NOT NULL AUTO_INCREMENT,
  `articleId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `discussContent` varchar(255) DEFAULT NULL,
  `discussDate` datetime DEFAULT NULL,
  `discussIsDel` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`discussId`),
  KEY `FK_Article_Discuss` (`articleId`),
  KEY `FK_User_Discuss` (`userId`),
  CONSTRAINT `FK_Article_Discuss` FOREIGN KEY (`articleId`) REFERENCES `articleinfo` (`articleId`),
  CONSTRAINT `FK_User_Discuss` FOREIGN KEY (`userId`) REFERENCES `userinfo` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of discussinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `fileinfo`
-- ----------------------------
DROP TABLE IF EXISTS `fileinfo`;
CREATE TABLE `fileinfo` (
  `fileId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `fileName` varchar(100) DEFAULT NULL,
  `fileDesc` varchar(500) DEFAULT NULL,
  `fileDate` datetime DEFAULT NULL,
  `filePath` varchar(1000) DEFAULT NULL,
  `fileImg` varchar(1000) DEFAULT NULL,
  `fileIsDel` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`fileId`),
  KEY `FK_User_File` (`userId`),
  CONSTRAINT `FK_User_File` FOREIGN KEY (`userId`) REFERENCES `userinfo` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fileinfo
-- ----------------------------
INSERT INTO `fileinfo` VALUES ('1', '1', 'HBuilder', null, null, '1234561', 'zhangsan1', '0');

-- ----------------------------
-- Table structure for `labelinfo`
-- ----------------------------
DROP TABLE IF EXISTS `labelinfo`;
CREATE TABLE `labelinfo` (
  `labelId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `labelName` varchar(30) DEFAULT NULL,
  `lableIsDel` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`labelId`),
  KEY `FK_User_Label` (`userId`),
  CONSTRAINT `FK_User_Label` FOREIGN KEY (`userId`) REFERENCES `userinfo` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of labelinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `label_article`
-- ----------------------------
DROP TABLE IF EXISTS `label_article`;
CREATE TABLE `label_article` (
  `laId` int(11) NOT NULL AUTO_INCREMENT,
  `laIsDel` tinyint(1) DEFAULT NULL,
  `articleId` int(11) NOT NULL,
  `labelId` int(11) NOT NULL,
  PRIMARY KEY (`laId`),
  KEY `FK_Label_Article` (`articleId`),
  KEY `FK_Label_Article2` (`labelId`),
  CONSTRAINT `FK_Label_Article` FOREIGN KEY (`articleId`) REFERENCES `articleinfo` (`articleId`),
  CONSTRAINT `FK_Label_Article2` FOREIGN KEY (`labelId`) REFERENCES `labelinfo` (`labelId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of label_article
-- ----------------------------

-- ----------------------------
-- Table structure for `linkinfo`
-- ----------------------------
DROP TABLE IF EXISTS `linkinfo`;
CREATE TABLE `linkinfo` (
  `linkId` int(11) NOT NULL AUTO_INCREMENT,
  `adminId` int(11) DEFAULT NULL,
  `linkName` varchar(60) DEFAULT NULL,
  `linkUrl` varchar(1000) DEFAULT NULL,
  `linkLogo` varchar(1000) DEFAULT NULL,
  `showOrder` int(11) DEFAULT NULL,
  `linkIsDel` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`linkId`),
  KEY `FK_Admin_Link` (`adminId`),
  CONSTRAINT `FK_Admin_Link` FOREIGN KEY (`adminId`) REFERENCES `admininfo` (`adminId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of linkinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `messageinfo`
-- ----------------------------
DROP TABLE IF EXISTS `messageinfo`;
CREATE TABLE `messageinfo` (
  `messageId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `Use_userId` int(11) DEFAULT NULL,
  `messageContent` varchar(255) DEFAULT NULL,
  `messageDate` datetime DEFAULT NULL,
  `msgIsDel` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`messageId`),
  KEY `FK_Receiver` (`Use_userId`),
  KEY `FK_Sender` (`userId`),
  CONSTRAINT `FK_Receiver` FOREIGN KEY (`Use_userId`) REFERENCES `userinfo` (`userId`),
  CONSTRAINT `FK_Sender` FOREIGN KEY (`userId`) REFERENCES `userinfo` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of messageinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `noticeinfo`
-- ----------------------------
DROP TABLE IF EXISTS `noticeinfo`;
CREATE TABLE `noticeinfo` (
  `noticeId` int(11) NOT NULL AUTO_INCREMENT,
  `adminId` int(11) DEFAULT NULL,
  `noticeTopic` varchar(50) DEFAULT NULL,
  `noticeContent` text,
  `noticeDate` datetime DEFAULT NULL,
  `noticeIsDel` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`noticeId`),
  KEY `FK_Admin_Notice` (`adminId`),
  CONSTRAINT `FK_Admin_Notice` FOREIGN KEY (`adminId`) REFERENCES `admininfo` (`adminId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of noticeinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `photoinfo`
-- ----------------------------
DROP TABLE IF EXISTS `photoinfo`;
CREATE TABLE `photoinfo` (
  `photoId` int(11) NOT NULL AUTO_INCREMENT,
  `albumId` int(11) DEFAULT NULL,
  `photoName` varchar(100) DEFAULT NULL,
  `photoPath` varchar(1000) DEFAULT NULL,
  `photoDesc` varchar(300) DEFAULT NULL,
  `photoDate` datetime DEFAULT NULL,
  `photoIsDel` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`photoId`),
  KEY `FK_Photo_Album` (`albumId`),
  CONSTRAINT `FK_Photo_Album` FOREIGN KEY (`albumId`) REFERENCES `albuminfo` (`albumId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of photoinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `replyinfo`
-- ----------------------------
DROP TABLE IF EXISTS `replyinfo`;
CREATE TABLE `replyinfo` (
  `replyId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `discussId` int(11) DEFAULT NULL,
  `replyContent` varchar(255) DEFAULT NULL,
  `replyDate` datetime DEFAULT NULL,
  `replyIsDel` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`replyId`),
  KEY `FK_Discuss_Reply` (`discussId`),
  KEY `FK_User_Reply` (`userId`),
  CONSTRAINT `FK_Discuss_Reply` FOREIGN KEY (`discussId`) REFERENCES `discussinfo` (`discussId`),
  CONSTRAINT `FK_User_Reply` FOREIGN KEY (`userId`) REFERENCES `userinfo` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of replyinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `typeinfo`
-- ----------------------------
DROP TABLE IF EXISTS `typeinfo`;
CREATE TABLE `typeinfo` (
  `typeId` int(11) NOT NULL AUTO_INCREMENT,
  `adminId` int(11) DEFAULT NULL,
  `typeName` varchar(30) DEFAULT NULL,
  `typeDesc` varchar(100) DEFAULT NULL,
  `typeIsDel` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`typeId`),
  KEY `FK_Admin_Type` (`adminId`),
  CONSTRAINT `FK_Admin_Type` FOREIGN KEY (`adminId`) REFERENCES `admininfo` (`adminId`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of typeinfo
-- ----------------------------
INSERT INTO `typeinfo` VALUES ('1', '1', '教育', null, '0');
INSERT INTO `typeinfo` VALUES ('2', '1', '军事', null, '0');
INSERT INTO `typeinfo` VALUES ('3', '1', '科技', null, '0');
INSERT INTO `typeinfo` VALUES ('4', '1', '数码', null, '0');
INSERT INTO `typeinfo` VALUES ('5', '1', '科技', null, '0');
INSERT INTO `typeinfo` VALUES ('6', '1', '自然', null, '0');
INSERT INTO `typeinfo` VALUES ('7', '1', '动物', null, '0');
INSERT INTO `typeinfo` VALUES ('8', '1', '地理', null, '0');
INSERT INTO `typeinfo` VALUES ('9', '1', '生物', null, '0');
INSERT INTO `typeinfo` VALUES ('10', '1', '宇宙', null, '0');
INSERT INTO `typeinfo` VALUES ('11', '1', '人文', null, '0');
INSERT INTO `typeinfo` VALUES ('12', '1', '历史', null, '0');
INSERT INTO `typeinfo` VALUES ('13', '1', '学前教育', null, '0');
INSERT INTO `typeinfo` VALUES ('14', '1', '小学教育', null, '0');
INSERT INTO `typeinfo` VALUES ('15', '1', '初中教育', null, '0');
INSERT INTO `typeinfo` VALUES ('16', '1', '高中教育', null, '0');
INSERT INTO `typeinfo` VALUES ('17', '1', '大学教育', null, '0');
INSERT INTO `typeinfo` VALUES ('18', '1', '成人教育', null, '0');

-- ----------------------------
-- Table structure for `type_article`
-- ----------------------------
DROP TABLE IF EXISTS `type_article`;
CREATE TABLE `type_article` (
  `atId` int(11) NOT NULL AUTO_INCREMENT,
  `atIsDel` tinyint(1) DEFAULT NULL,
  `typeId` int(11) NOT NULL,
  `articleId` int(11) NOT NULL,
  PRIMARY KEY (`atId`),
  KEY `FK_Type_Article` (`typeId`),
  KEY `FK_Type_Article2` (`articleId`),
  CONSTRAINT `FK_Type_Article` FOREIGN KEY (`typeId`) REFERENCES `typeinfo` (`typeId`),
  CONSTRAINT `FK_Type_Article2` FOREIGN KEY (`articleId`) REFERENCES `articleinfo` (`articleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of type_article
-- ----------------------------

-- ----------------------------
-- Table structure for `type_record`
-- ----------------------------
DROP TABLE IF EXISTS `type_record`;
CREATE TABLE `type_record` (
  `trId` int(11) NOT NULL AUTO_INCREMENT,
  `typeId` int(11) DEFAULT NULL,
  `Typ_typeId` int(11) DEFAULT NULL,
  `trIsDel` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`trId`),
  KEY `FK_TypeRecord` (`typeId`),
  KEY `FK_TypeRecord2` (`Typ_typeId`),
  CONSTRAINT `FK_TypeRecord` FOREIGN KEY (`typeId`) REFERENCES `typeinfo` (`typeId`),
  CONSTRAINT `FK_TypeRecord2` FOREIGN KEY (`Typ_typeId`) REFERENCES `typeinfo` (`typeId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of type_record
-- ----------------------------
INSERT INTO `type_record` VALUES ('1', '13', '1', '1');
INSERT INTO `type_record` VALUES ('2', '14', '1', '0');
INSERT INTO `type_record` VALUES ('3', '15', '1', '0');
INSERT INTO `type_record` VALUES ('4', '16', '1', '0');
INSERT INTO `type_record` VALUES ('5', '17', '1', '0');

-- ----------------------------
-- Table structure for `userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(30) NOT NULL,
  `userPwd` varchar(40) NOT NULL,
  `userNickName` varchar(30) DEFAULT NULL,
  `userSex` char(2) DEFAULT NULL,
  `userBirthday` date DEFAULT NULL,
  `userAddress` varchar(50) DEFAULT NULL,
  `userTel` varchar(11) DEFAULT NULL,
  `userEmail` varchar(30) DEFAULT NULL,
  `userPic` varchar(1000) DEFAULT NULL,
  `userRank` int(11) DEFAULT NULL,
  `userState` int(11) DEFAULT NULL,
  `userIsDel` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('1', 'zhangsan', '123', 'zhangsan', '男', '1995-06-06', '湖北武汉', '12345678906', '12334@163.com', '', '1', '1', '0');

-- ----------------------------
-- Table structure for `user_notice`
-- ----------------------------
DROP TABLE IF EXISTS `user_notice`;
CREATE TABLE `user_notice` (
  `unId` int(11) NOT NULL AUTO_INCREMENT,
  `noticeId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `unIsDel` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`unId`),
  KEY `FK_User_Notice` (`noticeId`),
  KEY `FK_User_Notice2` (`userId`),
  CONSTRAINT `FK_User_Notice` FOREIGN KEY (`noticeId`) REFERENCES `noticeinfo` (`noticeId`),
  CONSTRAINT `FK_User_Notice2` FOREIGN KEY (`userId`) REFERENCES `userinfo` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_notice
-- ----------------------------

-- ----------------------------
-- Procedure structure for `getProcList`
-- ----------------------------
DROP PROCEDURE IF EXISTS `getProcList`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `getProcList`(  -- 创建新的分页存储过程
  IN _fields VARCHAR (2000), -- 显示的字段
  IN _tables TEXT, -- 表名
  IN _where VARCHAR (2000), --  where条件，可为空
  IN _orderby VARCHAR (200), -- 排序条件，可为空
  IN _pageindex INT, -- 开始页
  IN _pagesize INT, -- 每页大小
  OUT _totalcount INT, -- 总共行数
  OUT _pagecount INT --  总共页数
)
BEGIN
  SET @startrow = _pagesize * (_pageindex - 1) ;
  SET @pagesize = _pagesize ;
  SET @rowindex = 0 ;
  SET @strsql = CONCAT(
    ' select SQL_CALC_FOUND_ROWS ', 
    _fields,
    ' from ',
    _tables,
    CASE
      IFNULL(_where, '') 
      WHEN ''
      THEN ''
      ELSE CONCAT(' where ', _where) 
    END,
      CASE
      IFNULL(_orderby, '') 
      WHEN ''
      THEN ''
      ELSE CONCAT(' order by ', _orderby) 
    END,  
    ' limit ',
    @startRow,
    ',',
    @pageSize
  ) ;
  PREPARE strsql FROM @strsql ;
  EXECUTE strsql ;
  SET _totalcount = FOUND_ROWS() ;
  IF (_totalcount <= _pagesize) 
  THEN SET _pagecount = 1 ;
  ELSE IF (_totalcount % _pagesize > 0) 
  THEN SET _pagecount = _totalcount / _pageSize + 1 ;
  ELSE SET _pagecount = _totalcount / _pageSize ;
  END IF ;
  END IF ;
END
;;
DELIMITER ;
