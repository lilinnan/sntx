/*
 Navicat Premium Data Transfer

 Source Server         : 47.100.63.203
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : 47.100.63.203:3306
 Source Schema         : sntx

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 15/02/2021 21:52:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for avatar
-- ----------------------------
DROP TABLE IF EXISTS `avatar`;
CREATE TABLE `avatar`
(
    `id`   int(11)                                                NOT NULL AUTO_INCREMENT,
    `uid`  varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `data` text CHARACTER SET utf8 COLLATE utf8_general_ci        NULL,
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `uid` (`uid`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 53239
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback`
(
    `id`       int(11)                                                NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `contact`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `feedback` longtext CHARACTER SET utf8 COLLATE utf8_general_ci    NOT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 30
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;
