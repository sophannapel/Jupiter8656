/*
 Navicat MySQL Data Transfer

 Source Server         : MySql
 Source Server Type    : MySQL
 Source Server Version : 50622
 Source Host           : localhost
 Source Database       : mumscrum

 Target Server Type    : MySQL
 Target Server Version : 50622
 File Encoding         : utf-8

 Date: 09/14/2015 20:58:15 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `Employee`
-- ----------------------------
DROP TABLE IF EXISTS `Employee`;
CREATE TABLE `Employee` (
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `Employee`
-- ----------------------------
BEGIN;
INSERT INTO `Employee` VALUES ('1', 'sophanna', 'pel', 'a', 'a', '1', 'active', null);
COMMIT;

-- ----------------------------
--  Table structure for `product`
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `product`
-- ----------------------------
BEGIN;
INSERT INTO `product` VALUES ('1', 'scrum', '2015-09-13 22:32:13', '2015-09-15 22:32:16', 'agile approach', '1', '1'), ('2', 'rup', '2015-09-14 01:50:30', '2015-09-16 01:50:34', 'rup approach', '1', '1');
COMMIT;

-- ----------------------------
--  Table structure for `releaseBacklog`
-- ----------------------------
DROP TABLE IF EXISTS `releaseBacklog`;
CREATE TABLE `releaseBacklog` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) DEFAULT NULL,
  `type` varchar(25) DEFAULT NULL,
  `startDate` timestamp NULL DEFAULT NULL,
  `dueDate` timestamp NULL DEFAULT NULL,
  `descriptioon` text,
  `productId` int(15) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `PRODUCT_RELEASE` (`productId`),
  CONSTRAINT `PRODUCT_RELEASE` FOREIGN KEY (`productId`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `role`
-- ----------------------------
BEGIN;
INSERT INTO `role` VALUES ('1', 'Product owner'), ('2', 'Scrum master'), ('3', 'Developer'), ('4', 'Tester'), ('5', 'HR Admin');
COMMIT;

-- ----------------------------
--  Table structure for `sprint`
-- ----------------------------
DROP TABLE IF EXISTS `sprint`;
CREATE TABLE `sprint` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) DEFAULT NULL,
  `startDate` timestamp NULL DEFAULT NULL,
  `dueDate` timestamp NULL DEFAULT NULL,
  `releaseId` int(15) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `RELEASE_SPRINT` (`releaseId`),
  CONSTRAINT `RELEASE_SPRINT` FOREIGN KEY (`releaseId`) REFERENCES `releaseBacklog` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `status`
-- ----------------------------
DROP TABLE IF EXISTS `status`;
CREATE TABLE `status` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `status`
-- ----------------------------
BEGIN;
INSERT INTO `status` VALUES ('1', 'To Do', 'Initialial product status'), ('2', 'In Progress', 'Work in progress'), ('3', 'Closed', 'Work completed');
COMMIT;

-- ----------------------------
--  Table structure for `userstory`
-- ----------------------------
DROP TABLE IF EXISTS `userstory`;
CREATE TABLE `userstory` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) DEFAULT NULL,
  `priority` varchar(25) DEFAULT NULL,
  `startDate` timestamp NULL DEFAULT NULL,
  `dueDate` timestamp NULL DEFAULT NULL,
  `estimateDevEffort` int(15) DEFAULT NULL,
  `estimateTestEffort` int(15) DEFAULT NULL,
  `description` text,
  `productId` int(15) NOT NULL,
  `releaseId` int(15) NOT NULL,
  `sprintId` int(15) NOT NULL,
  `developerId` int(15) NOT NULL,
  `testId` int(15) NOT NULL,
  `ownerId` int(15) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `USERSTORY_EMP` (`developerId`),
  KEY `USERSTORY_TESTER` (`testId`),
  KEY `USERSTORY_OWNER` (`ownerId`),
  KEY `USERSTORY_PRODUCT` (`productId`),
  KEY `SPRINT_USERSTORY` (`sprintId`),
  CONSTRAINT `SPRINT_USERSTORY` FOREIGN KEY (`sprintId`) REFERENCES `sprint` (`id`),
  CONSTRAINT `USERSTORY_EMP` FOREIGN KEY (`developerId`) REFERENCES `employee` (`id`),
  CONSTRAINT `USERSTORY_OWNER` FOREIGN KEY (`ownerId`) REFERENCES `employee` (`id`),
  CONSTRAINT `USERSTORY_PRODUCT` FOREIGN KEY (`productId`) REFERENCES `product` (`id`),
  CONSTRAINT `USERSTORY_TESTER` FOREIGN KEY (`testId`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `worklog`
-- ----------------------------
DROP TABLE IF EXISTS `worklog`;
CREATE TABLE `worklog` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `actualEffort` int(15) DEFAULT NULL,
  `modifiedDate` timestamp NULL DEFAULT NULL,
  `userStoryId` int(15) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `USERSTORY_WORKLOG` (`userStoryId`),
  CONSTRAINT `USERSTORY_WORKLOG` FOREIGN KEY (`userStoryId`) REFERENCES `userstory` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
