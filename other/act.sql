/*
Navicat MySQL Data Transfer

Source Server         : lo
Source Server Version : 80025
Source Host           : 127.0.0.1:3306
Source Database       : act

Target Server Type    : MYSQL
Target Server Version : 80025
File Encoding         : 65001

Date: 2022-08-24 17:03:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `id` bigint NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `scheme_id` bigint DEFAULT NULL,
  `state` tinyint DEFAULT NULL,
  `start_time` int(10) unsigned zerofill DEFAULT NULL,
  `end_time` int(10) unsigned zerofill DEFAULT NULL,
  `context_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of activity
-- ----------------------------

-- ----------------------------
-- Table structure for context
-- ----------------------------
DROP TABLE IF EXISTS `context`;
CREATE TABLE `context` (
  `id` bigint NOT NULL,
  `context` varchar(3000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of context
-- ----------------------------

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` bigint NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `amount` int(10) unsigned zerofill DEFAULT NULL,
  `qty` int(10) unsigned zerofill DEFAULT NULL,
  `type` tinyint(3) unsigned zerofill DEFAULT NULL,
  `create_time` int(10) unsigned zerofill DEFAULT NULL,
  `modify_time` int(10) unsigned zerofill DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of goods
-- ----------------------------

-- ----------------------------
-- Table structure for scheme
-- ----------------------------
DROP TABLE IF EXISTS `scheme`;
CREATE TABLE `scheme` (
  `id` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of scheme
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `phone` char(11) DEFAULT NULL,
  `password` char(32) DEFAULT NULL,
  `is_admin` tinyint unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('8250702927607963648', 'alex', '13149322149', 'e10adc3949ba59abbe56e057f20f883e', '1');
