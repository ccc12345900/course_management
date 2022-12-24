/*
 Navicat Premium Data Transfer

 Source Server         : zuo-localhost
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : xw

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 25/12/2022 00:30:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for classroom
-- ----------------------------
DROP TABLE IF EXISTS `classroom`;
CREATE TABLE `classroom`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classroom_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of classroom
-- ----------------------------
INSERT INTO `classroom` VALUES (1, '5306');
INSERT INTO `classroom` VALUES (2, '5307');
INSERT INTO `classroom` VALUES (3, '5308');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `course_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '课程号',
  `course_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程名称',
  `lesson_time` bigint(255) NOT NULL COMMENT '授课时间',
  `optional_number` int(11) NOT NULL COMMENT '可选人数',
  `classroom` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '教室',
  `optional_major` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '可选专业',
  `Mode_delivery` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '授课方式',
  `course_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程描述',
  PRIMARY KEY (`course_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (28, '数学', 1643644800000, 12, '5306', '计算机科学与技术', '线下', '测试');
INSERT INTO `course` VALUES (29, '科学', 1643644800000, 12, '5306', '软件工程', '线下', '测试');
INSERT INTO `course` VALUES (30, '科学', 1643644800000, 12, '5306', '计算机科学与技术', '线下', '测试');
INSERT INTO `course` VALUES (31, '语文', 1643644800000, 12, '5306', '物联网', '线下', '测试');
INSERT INTO `course` VALUES (32, '数学2022', 1643644800000, 12, '5307', '物联网', '线下', '测试');
INSERT INTO `course` VALUES (33, '数学2023', 1643644800000, 12, '5308', '物联网', '线下', '测试');
INSERT INTO `course` VALUES (34, '数学2023', 1643644800000, 12, '5308', '软件工程', '线下', '测试');
INSERT INTO `course` VALUES (35, '数学2023', 1643644800000, 12, '5308', '计算机科学与技术', '线下', '测试');

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `major_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of major
-- ----------------------------
INSERT INTO `major` VALUES (1, '物联网');
INSERT INTO `major` VALUES (2, '软件工程');
INSERT INTO `major` VALUES (3, '计算机科学与技术');

SET FOREIGN_KEY_CHECKS = 1;
