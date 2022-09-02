/*
Navicat MySQL Data Transfer

Source Server         : lo
Source Server Version : 80025
Source Host           : 127.0.0.1:3306
Source Database       : act

Target Server Type    : MYSQL
Target Server Version : 80025
File Encoding         : 65001

Date: 2022-09-02 14:50:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `id` bigint NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `state` tinyint DEFAULT NULL,
  `start_time` int(10) unsigned zerofill DEFAULT NULL,
  `end_time` int(10) unsigned zerofill DEFAULT NULL,
  `context_id` bigint DEFAULT NULL,
  `scene_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `cover` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `rel_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES ('8253910095828738048', 'alex的测试活动8253910095828738048', '1', '1661696711', '1664294400', '1035', '1016', 'http://127.0.0.1:3001/uploads/MOfN8C2I5QckpEsnRXEw3wEk.png');

-- ----------------------------
-- Table structure for context
-- ----------------------------
DROP TABLE IF EXISTS `context`;
CREATE TABLE `context` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `context` varchar(3000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1036 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of context
-- ----------------------------
INSERT INTO `context` VALUES ('1035', '{\"themeColor\":\"#1393FF\",\"buttonColor\":\"#FFA203\"}');

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `item_id` bigint NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `total` int DEFAULT NULL,
  `qty` int DEFAULT NULL,
  `type` tinyint DEFAULT NULL,
  `create_time` int unsigned DEFAULT NULL,
  `modify_time` int unsigned DEFAULT NULL,
  `rel_id` bigint DEFAULT NULL,
  `rel_type` tinyint unsigned DEFAULT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES ('8253910095828738050', '测试商品', '100', '0', '1', '1661696711', '1661696711', '8253910095828738049', '1');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `order_id` bigint NOT NULL,
  `rel_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `create_time` int unsigned DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of order
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
  UNIQUE KEY `scene` (`scene`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1017 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of scene
-- ----------------------------
INSERT INTO `scene` VALUES ('0000001016', '756d5aa6157009e4f164bd5d04a0ab82', '{\"activity_id\":\"8253910095828738048\"}');

-- ----------------------------
-- Table structure for scheme
-- ----------------------------
DROP TABLE IF EXISTS `scheme`;
CREATE TABLE `scheme` (
  `scheme_id` bigint NOT NULL,
  `type` tinyint unsigned DEFAULT NULL,
  `rel_id` bigint DEFAULT NULL,
  `rel_type` tinyint unsigned DEFAULT NULL,
  PRIMARY KEY (`scheme_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of scheme
-- ----------------------------
INSERT INTO `scheme` VALUES ('8253910095828738049', '1', '8253910095828738048', '1');

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
