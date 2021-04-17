/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : simple_mall

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 17/04/2021 14:56:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_authority
-- ----------------------------
DROP TABLE IF EXISTS `sys_authority`;
CREATE TABLE `sys_authority`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求路径',
  `path` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '路由',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `component` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组件',
  `icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `parent_id` int(11) NULL DEFAULT NULL COMMENT '父菜单',
  `is_menu` tinyint(1) NULL DEFAULT NULL COMMENT '是否为菜单',
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '按钮类型',
  `func` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '方法',
  `creator` int(11) NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updator` int(11) NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `status` tinyint(1) NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_authority
-- ----------------------------
INSERT INTO `sys_authority` VALUES (1, '/', '/home', '所有', 'Home', NULL, 0, 1, NULL, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `sys_authority` VALUES (2, '/main', '/system', '系统管理', 'Main', '', 1, 1, NULL, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `sys_authority` VALUES (3, '/system/user', '/user', '用户管理', 'User', '', 2, 1, NULL, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `sys_authority` VALUES (4, '/system/role', '/role', '角色管理', 'Role', '', 2, 1, NULL, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `sys_authority` VALUES (5, '/system/authority', '/authority', '权限管理', 'Authority', '', 2, 1, NULL, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `sys_authority` VALUES (6, NULL, NULL, '查看', NULL, 'el-icon-view', 3, 0, 'primary', 'show', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_authority` VALUES (7, NULL, NULL, '添加', NULL, 'el-icon-plus', 3, 0, 'success', 'add', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_authority` VALUES (8, NULL, NULL, '修改', NULL, 'el-icon-edit', 3, 0, 'warning', 'edit', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_authority` VALUES (9, NULL, NULL, '删除', NULL, 'el-icon-delete', 3, 0, 'danger', 'del', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_authority` VALUES (10, NULL, NULL, '查看', NULL, 'el-icon-view', 4, 0, 'primary', 'show', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_authority` VALUES (11, NULL, NULL, '添加', NULL, 'el-icon-plus', 4, 0, 'success', 'add', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_authority` VALUES (12, NULL, NULL, '修改', NULL, 'el-icon-edit', 4, 0, 'warning', 'edit', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_authority` VALUES (13, NULL, NULL, '删除', NULL, 'el-icon-delete', 4, 0, 'danger', 'del', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_authority` VALUES (14, NULL, NULL, '查看', NULL, 'el-icon-view', 5, 0, 'primary', 'show', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_authority` VALUES (15, NULL, NULL, '添加', NULL, 'el-icon-plus', 5, 0, 'success', 'add', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_authority` VALUES (16, NULL, NULL, '修改', NULL, 'el-icon-edit', 5, 0, 'warning', 'edit', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_authority` VALUES (17, NULL, NULL, '删除', NULL, 'el-icon-delete', 5, 0, 'danger', 'del', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_authority` VALUES (18, '/system/dictionary', '/dictionary', '字典管理', 'Dictionary', NULL, 2, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_authority` VALUES (19, NULL, NULL, '查看', NULL, 'el-icon-view', 18, 0, 'primary', 'show', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_authority` VALUES (20, NULL, NULL, '添加', NULL, 'el-icon-plus', 18, 0, 'success', 'add', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_authority` VALUES (21, NULL, NULL, '修改', NULL, 'el-icon-edit', 18, 0, 'warning', 'edit', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_authority` VALUES (22, NULL, NULL, '删除', NULL, 'el-icon-delete', 18, 0, 'danger', 'del', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_authority` VALUES (23, '/main', '/generator', '开发工具', 'Main', NULL, 1, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_authority` VALUES (24, '/generator/tableinfo', '/tableInfo', '表信息', 'TableInfo', NULL, 23, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_authority` VALUES (25, NULL, NULL, '查看', NULL, 'el-icon-view', 24, 0, 'primary', 'show', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_authority` VALUES (26, NULL, NULL, '代码生成', NULL, 'el-icon-plus', 24, 0, 'success', 'generator', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_authority` VALUES (27, '/main', '/test', '测试页面', 'Main', NULL, 1, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_authority` VALUES (28, '/test/testInfo', '/testInfo', '测试表', 'TestInfo', NULL, 27, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `sys_dictionary`;
CREATE TABLE `sys_dictionary`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '代码',
  `seq` tinyint(4) NULL DEFAULT NULL COMMENT '排序',
  `parent_id` int(11) NULL DEFAULT NULL COMMENT '父ID',
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `creator` int(11) NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updator` int(11) NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `status` tinyint(1) NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dictionary
-- ----------------------------
INSERT INTO `sys_dictionary` VALUES (1, '所有', 'all', 1, 0, '所有', NULL, NULL, NULL, NULL, 1);
INSERT INTO `sys_dictionary` VALUES (2, 'Java路径', '', 1, 1, 'Java路径', NULL, NULL, NULL, NULL, 1);
INSERT INTO `sys_dictionary` VALUES (3, 'simple-mall-server', '/src/main/java/com/strr/mall', 1, 2, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `sys_dictionary` VALUES (4, NULL, '/test', 1, 3, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `sys_dictionary` VALUES (6, 'Vue路径', NULL, 2, 1, 'Vue路径', NULL, NULL, NULL, NULL, 1);
INSERT INTO `sys_dictionary` VALUES (7, 'simple-mall-web', '/src/views', 1, 6, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `sys_dictionary` VALUES (8, NULL, '/test/testInfo', 1, 7, NULL, NULL, NULL, NULL, NULL, 1);

-- ----------------------------
-- Table structure for sys_rel_role_authority
-- ----------------------------
DROP TABLE IF EXISTS `sys_rel_role_authority`;
CREATE TABLE `sys_rel_role_authority`  (
  `rid` int(11) NULL DEFAULT NULL COMMENT '角色id',
  `aid` int(11) NULL DEFAULT NULL COMMENT '权限id'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_rel_role_authority
-- ----------------------------
INSERT INTO `sys_rel_role_authority` VALUES (1, 2);
INSERT INTO `sys_rel_role_authority` VALUES (1, 3);
INSERT INTO `sys_rel_role_authority` VALUES (1, 4);
INSERT INTO `sys_rel_role_authority` VALUES (1, 5);
INSERT INTO `sys_rel_role_authority` VALUES (1, 2);
INSERT INTO `sys_rel_role_authority` VALUES (1, 3);
INSERT INTO `sys_rel_role_authority` VALUES (1, 6);
INSERT INTO `sys_rel_role_authority` VALUES (1, 7);
INSERT INTO `sys_rel_role_authority` VALUES (1, 8);
INSERT INTO `sys_rel_role_authority` VALUES (1, 9);
INSERT INTO `sys_rel_role_authority` VALUES (1, 4);
INSERT INTO `sys_rel_role_authority` VALUES (1, 10);
INSERT INTO `sys_rel_role_authority` VALUES (1, 11);
INSERT INTO `sys_rel_role_authority` VALUES (1, 12);
INSERT INTO `sys_rel_role_authority` VALUES (1, 13);
INSERT INTO `sys_rel_role_authority` VALUES (1, 5);
INSERT INTO `sys_rel_role_authority` VALUES (1, 14);
INSERT INTO `sys_rel_role_authority` VALUES (1, 15);
INSERT INTO `sys_rel_role_authority` VALUES (1, 16);
INSERT INTO `sys_rel_role_authority` VALUES (1, 17);
INSERT INTO `sys_rel_role_authority` VALUES (1, 18);
INSERT INTO `sys_rel_role_authority` VALUES (1, 19);
INSERT INTO `sys_rel_role_authority` VALUES (1, 20);
INSERT INTO `sys_rel_role_authority` VALUES (1, 21);
INSERT INTO `sys_rel_role_authority` VALUES (1, 22);
INSERT INTO `sys_rel_role_authority` VALUES (1, 23);
INSERT INTO `sys_rel_role_authority` VALUES (1, 24);
INSERT INTO `sys_rel_role_authority` VALUES (1, 25);
INSERT INTO `sys_rel_role_authority` VALUES (1, 26);

-- ----------------------------
-- Table structure for sys_rel_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_rel_user_role`;
CREATE TABLE `sys_rel_user_role`  (
  `uid` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `rid` int(11) NULL DEFAULT NULL COMMENT '角色id'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_rel_user_role
-- ----------------------------
INSERT INTO `sys_rel_user_role` VALUES (1, 1);
INSERT INTO `sys_rel_user_role` VALUES (0, 444);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `seq` tinyint(4) NULL DEFAULT NULL COMMENT '排序',
  `creator` int(11) NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updator` int(11) NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '管理员', NULL, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `sys_role` VALUES (2, '测试', NULL, NULL, NULL, NULL, NULL, NULL, 1);

-- ----------------------------
-- Table structure for sys_test
-- ----------------------------
DROP TABLE IF EXISTS `sys_test`;
CREATE TABLE `sys_test`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `gender` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_test
-- ----------------------------
INSERT INTO `sys_test` VALUES (1, '123', 1232, '123');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `nickname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `avatar` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `login_time` datetime(0) NULL DEFAULT NULL COMMENT '登录时间',
  `creator` int(11) NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updator` int(11) NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `status` tinyint(1) NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '$2a$10$HLpbo23NoKfxTKuv5UAaB.KMCNvXoCPXDXUKlnZUBQlmhrihU.b2S', '管理员', 'admin@example.com', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1);

SET FOREIGN_KEY_CHECKS = 1;
