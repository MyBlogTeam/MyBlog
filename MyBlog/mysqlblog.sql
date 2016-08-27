/*
Navicat MySQL Data Transfer

Source Server         : sql_xiaowei
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : myblog

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2016-08-27 08:44:20
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
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admininfo
-- ----------------------------
INSERT INTO `admininfo` VALUES ('1', 'admin', 'admin', '123', '123@qq.com', null, '0');
INSERT INTO `admininfo` VALUES ('2', 'zs', 'zs', '123', null, null, '0');
INSERT INTO `admininfo` VALUES ('3', 'lisi', 'lisi', null, null, null, '0');
INSERT INTO `admininfo` VALUES ('4', 'as1', 'as', null, null, null, '0');
INSERT INTO `admininfo` VALUES ('5', 'as2', 'as', null, null, null, '0');
INSERT INTO `admininfo` VALUES ('6', 'as3', 'as', null, null, null, '0');
INSERT INTO `admininfo` VALUES ('7', 'as4', 'as', null, null, null, '0');
INSERT INTO `admininfo` VALUES ('8', 'as5', 'as', null, null, null, '0');
INSERT INTO `admininfo` VALUES ('9', 'as6', 'as', null, null, null, '0');
INSERT INTO `admininfo` VALUES ('10', 'as7', 'as', null, null, null, '0');
INSERT INTO `admininfo` VALUES ('11', 'as8', 'as', null, null, null, '0');
INSERT INTO `admininfo` VALUES ('12', 'as9', 'as', null, null, null, '0');
INSERT INTO `admininfo` VALUES ('13', 'as10', 'as', null, null, null, '0');
INSERT INTO `admininfo` VALUES ('14', 'as11', 'as', null, null, null, '0');
INSERT INTO `admininfo` VALUES ('15', 'as12', 'as', null, null, null, '0');
INSERT INTO `admininfo` VALUES ('16', 'as13', 'as', null, null, null, '0');
INSERT INTO `admininfo` VALUES ('17', 'as14', 'as', null, null, null, '0');
INSERT INTO `admininfo` VALUES ('18', 'as15', 'as', null, null, null, '0');
INSERT INTO `admininfo` VALUES ('19', 'as16', 'as', null, null, null, '0');
INSERT INTO `admininfo` VALUES ('20', 'as17', 'as', null, null, null, '0');
INSERT INTO `admininfo` VALUES ('21', 'as18', 'as', null, null, null, '0');
INSERT INTO `admininfo` VALUES ('22', 'as19', 'as', null, null, null, '0');
INSERT INTO `admininfo` VALUES ('23', 'as20', 'as', null, null, null, '0');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of articleinfo
-- ----------------------------

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
  KEY `FK_User_Blog2` (`userId`),
  CONSTRAINT `FK_User_Blog2` FOREIGN KEY (`userId`) REFERENCES `userinfo` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bloginfo
-- ----------------------------

-- ----------------------------
-- Table structure for `clicklikeinfo`
-- ----------------------------
DROP TABLE IF EXISTS `clicklikeinfo`;
CREATE TABLE `clicklikeinfo` (
  `likeId` int(11) NOT NULL,
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
  `Dis_discussId` int(11) DEFAULT NULL,
  `articleId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `discussContent` varchar(255) DEFAULT NULL,
  `discussDate` datetime DEFAULT NULL,
  `discussIsDel` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`discussId`),
  KEY `FK_Article_Discuss` (`articleId`),
  KEY `FK_Discuss_Discuss` (`Dis_discussId`),
  KEY `FK_User_Discuss` (`userId`),
  CONSTRAINT `FK_Article_Discuss` FOREIGN KEY (`articleId`) REFERENCES `articleinfo` (`articleId`),
  CONSTRAINT `FK_Discuss_Discuss` FOREIGN KEY (`Dis_discussId`) REFERENCES `discussinfo` (`discussId`),
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fileinfo
-- ----------------------------

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
-- Table structure for `typeinfo`
-- ----------------------------
DROP TABLE IF EXISTS `typeinfo`;
CREATE TABLE `typeinfo` (
  `typeId` int(11) NOT NULL AUTO_INCREMENT,
  `Typ_typeId` int(11) DEFAULT NULL,
  `adminId` int(11) DEFAULT NULL,
  `typeName` varchar(30) DEFAULT NULL,
  `typeDesc` varchar(100) DEFAULT NULL,
  `typeIsDel` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`typeId`),
  KEY `FK_Admin_Type` (`adminId`),
  KEY `FK_Type_Type` (`Typ_typeId`),
  CONSTRAINT `FK_Admin_Type` FOREIGN KEY (`adminId`) REFERENCES `admininfo` (`adminId`),
  CONSTRAINT `FK_Type_Type` FOREIGN KEY (`Typ_typeId`) REFERENCES `typeinfo` (`typeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of typeinfo
-- ----------------------------

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
-- Table structure for `userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `blogId` int(11) DEFAULT NULL,
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
  PRIMARY KEY (`userId`),
  KEY `FK_User_Blog` (`blogId`),
  CONSTRAINT `FK_User_Blog` FOREIGN KEY (`blogId`) REFERENCES `bloginfo` (`blogId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------

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
