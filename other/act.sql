/*
Navicat MySQL Data Transfer

Source Server         : lo
Source Server Version : 80025
Source Host           : 127.0.0.1:3306
Source Database       : act

Target Server Type    : MYSQL
Target Server Version : 80025
File Encoding         : 65001

Date: 2022-08-25 18:26:18
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
  `scene_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `type` tinyint(3) unsigned zerofill DEFAULT NULL,
  `rel_id` bigint DEFAULT NULL,
  `cover` varchar(512) DEFAULT NULL,
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
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` bigint NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `total` int(10) unsigned zerofill DEFAULT NULL,
  `qty` int(10) unsigned zerofill DEFAULT NULL,
  `type` tinyint(3) unsigned zerofill DEFAULT NULL,
  `create_time` int(10) unsigned zerofill DEFAULT NULL,
  `modify_time` int(10) unsigned zerofill DEFAULT NULL,
  `rel_id` bigint DEFAULT NULL,
  `rel_type` tinyint(3) unsigned zerofill DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `rel_id` (`rel_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of item
-- ----------------------------

-- ----------------------------
-- Table structure for scene
-- ----------------------------
DROP TABLE IF EXISTS `scene`;
CREATE TABLE `scene` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `scene` char(32) DEFAULT NULL,
  `param` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `scene` (`param`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of scene
-- ----------------------------

-- ----------------------------
-- Table structure for scheme
-- ----------------------------
DROP TABLE IF EXISTS `scheme`;
CREATE TABLE `scheme` (
  `id` bigint NOT NULL,
  `type` tinyint(3) unsigned zerofill DEFAULT NULL,
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
