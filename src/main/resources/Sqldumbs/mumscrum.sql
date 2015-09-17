/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : mumscrum

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2015-09-17 06:57:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(25) DEFAULT NULL,
  `username` varchar(25) DEFAULT NULL,
  `password` varchar(25) DEFAULT NULL,
  `roleId` int(15) DEFAULT NULL,
  `status` varchar(25) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ROLE_EMP` (`roleId`),
  CONSTRAINT `ROLE_EMP` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', 'sophanna', 'pel', 'a', 'a', '1', 'active', null);
INSERT INTO `employee` VALUES ('2', 'kuroun', 'seung', 'b', 'b', '3', 'active', null);

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) DEFAULT NULL,
  `startDate` timestamp NULL DEFAULT NULL,
  `dueDate` timestamp NULL DEFAULT NULL,
  `description` text,
  `statusId` int(15) DEFAULT NULL,
  `employeeId` int(15) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `PRODUCT_EMP` (`employeeId`),
  KEY `STATUS_EMP` (`statusId`),
  CONSTRAINT `PRODUCT_EMP` FOREIGN KEY (`employeeId`) REFERENCES `employee` (`id`),
  CONSTRAINT `STATUS_EMP` FOREIGN KEY (`statusId`) REFERENCES `status` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', 'scrum', '2015-09-13 22:32:13', '2015-09-15 22:32:16', 'agile approach', '1', '1');
INSERT INTO `product` VALUES ('2', 'rup', '2015-09-14 01:50:30', '2015-09-16 01:50:34', 'rup approach', '1', '1');
INSERT INTO `product` VALUES ('4', 'test1', '2015-09-13 22:32:13', '2015-09-15 22:32:13', '', '1', '1');
INSERT INTO `product` VALUES ('7', 'test2', '2015-09-15 22:32:16', '2015-09-15 22:32:13', 'fdsfsdfsd', '1', '1');
INSERT INTO `product` VALUES ('9', 'test3', '2015-09-15 22:32:16', '2015-09-17 22:32:16', '', '1', '1');
INSERT INTO `product` VALUES ('10', 'test4', '2015-09-13 22:32:13', '2015-09-17 22:32:16', '', '1', '1');
INSERT INTO `product` VALUES ('11', 'test5', '2015-09-15 22:32:16', '2015-09-17 22:32:16', '', '1', '1');
INSERT INTO `product` VALUES ('12', 'test6', '2015-09-15 22:32:16', '2015-09-15 22:32:16', '', '1', '1');
INSERT INTO `product` VALUES ('13', 'test7', '2015-09-15 22:32:16', '2015-09-13 22:32:13', '', '1', '1');

-- ----------------------------
-- Table structure for releasebacklog
-- ----------------------------
DROP TABLE IF EXISTS `releasebacklog`;
CREATE TABLE `releasebacklog` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) DEFAULT NULL,
  `type` varchar(25) DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  `dueDate` date DEFAULT NULL,
  `description` text,
  `productId` int(15) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `PRODUCT_RELEASE` (`productId`),
  CONSTRAINT `PRODUCT_RELEASE` FOREIGN KEY (`productId`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of releasebacklog
-- ----------------------------
INSERT INTO `releasebacklog` VALUES ('1', 'Release1', null, '2015-09-01', '2015-10-09', null, '1');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'Product owner');
INSERT INTO `role` VALUES ('2', 'Scrum master');
INSERT INTO `role` VALUES ('3', 'Developer');
INSERT INTO `role` VALUES ('4', 'Tester');
INSERT INTO `role` VALUES ('5', 'HR Admin');

-- ----------------------------
-- Table structure for sprint
-- ----------------------------
DROP TABLE IF EXISTS `sprint`;
CREATE TABLE `sprint` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  `dueDate` date DEFAULT NULL,
  `releaseId` int(15) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `RELEASE_SPRINT` (`releaseId`),
  CONSTRAINT `RELEASE_SPRINT` FOREIGN KEY (`releaseId`) REFERENCES `releasebacklog` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sprint
-- ----------------------------
INSERT INTO `sprint` VALUES ('1', 'Sprint1', '2015-09-17', '2015-09-30', '1');

-- ----------------------------
-- Table structure for status
-- ----------------------------
DROP TABLE IF EXISTS `status`;
CREATE TABLE `status` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of status
-- ----------------------------
INSERT INTO `status` VALUES ('1', 'To Do', 'Initialial product status');
INSERT INTO `status` VALUES ('2', 'In Progress', 'Work in progress');
INSERT INTO `status` VALUES ('3', 'Closed', 'Work completed');

-- ----------------------------
-- Table structure for userstory
-- ----------------------------
DROP TABLE IF EXISTS `userstory`;
CREATE TABLE `userstory` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) DEFAULT NULL,
  `priority` varchar(25) DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  `dueDate` date DEFAULT NULL,
  `estimateDevEffort` int(15) DEFAULT NULL,
  `estimateTestEffort` int(15) DEFAULT NULL,
  `description` text,
  `productId` int(15) NOT NULL,
  `releaseId` int(15) DEFAULT NULL,
  `sprintId` int(15) DEFAULT NULL,
  `developerId` int(15) DEFAULT NULL,
  `testId` int(15) DEFAULT NULL,
  `ownerId` int(15) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `USERSTORY_EMP` (`developerId`),
  KEY `USERSTORY_TESTER` (`testId`),
  KEY `USERSTORY_OWNER` (`ownerId`),
  KEY `USERSTORY_PRODUCT` (`productId`),
  KEY `SPRINT_USERSTORY` (`sprintId`),
  KEY `releaseId` (`releaseId`),
  CONSTRAINT `SPRINT_USERSTORY` FOREIGN KEY (`sprintId`) REFERENCES `sprint` (`id`),
  CONSTRAINT `USERSTORY_EMP` FOREIGN KEY (`developerId`) REFERENCES `employee` (`id`),
  CONSTRAINT `USERSTORY_OWNER` FOREIGN KEY (`ownerId`) REFERENCES `employee` (`id`),
  CONSTRAINT `USERSTORY_PRODUCT` FOREIGN KEY (`productId`) REFERENCES `product` (`id`),
  CONSTRAINT `USERSTORY_TESTER` FOREIGN KEY (`testId`) REFERENCES `employee` (`id`),
  CONSTRAINT `userstory_ibfk_1` FOREIGN KEY (`releaseId`) REFERENCES `releasebacklog` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userstory
-- ----------------------------
INSERT INTO `userstory` VALUES ('1', 'User Authentication', '1', '2015-09-17', '2015-09-24', null, '20', null, '1', '1', '1', '2', null, '1');

-- ----------------------------
-- Table structure for worklog
-- ----------------------------
DROP TABLE IF EXISTS `worklog`;
CREATE TABLE `worklog` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `actualEffort` int(15) DEFAULT NULL,
  `modifiedDate` date DEFAULT NULL,
  `userStoryId` int(15) NOT NULL,
  `effortType` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `USERSTORY_WORKLOG` (`userStoryId`),
  CONSTRAINT `USERSTORY_WORKLOG` FOREIGN KEY (`userStoryId`) REFERENCES `userstory` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of worklog
-- ----------------------------
