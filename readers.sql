/*
 Navicat Premium Data Transfer

 Source Server         : MyDatabase
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : cardwr

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 25/01/2022 09:27:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for readers
-- ----------------------------
DROP TABLE IF EXISTS `readers`;
CREATE TABLE `readers`  (
  `number` int(10) NOT NULL,
  `icnumber` int(10) NULL DEFAULT NULL,
  `time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `rfidno` int(2) NULL DEFAULT NULL,
  `out` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`number`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of readers
-- ----------------------------
INSERT INTO `readers` VALUES (100001, 122011488, '2022-01-25 09:22:52', 1, 0);
INSERT INTO `readers` VALUES (100002, 129759584, '2022-01-25 09:22:56', 1, 0);
INSERT INTO `readers` VALUES (100003, 124692576, '2022-01-25 09:22:59', 1, 0);
INSERT INTO `readers` VALUES (100004, 127167328, '2022-01-25 09:24:29', 1, 0);
INSERT INTO `readers` VALUES (100005, 121312880, '2022-01-25 09:24:34', 1, 0);
INSERT INTO `readers` VALUES (100006, 55811027, '2022-01-25 09:24:48', 1, 0);
INSERT INTO `readers` VALUES (100007, 1177656656, '2022-01-25 09:24:53', 1, 0);
INSERT INTO `readers` VALUES (100008, 1176791376, '2022-01-25 09:24:58', 1, 0);

SET FOREIGN_KEY_CHECKS = 1;
