/*
 Navicat Premium Data Transfer

 Source Server         : mariadb
 Source Server Type    : MySQL
 Source Server Version : 50560
 Source Host           : localhost:3306
 Source Schema         : takeout

 Target Server Type    : MySQL
 Target Server Version : 50560
 File Encoding         : 65001

 Date: 15/03/2019 01:56:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address`  (
  `address_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '地址主键',
  `address_value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '送餐地址',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户外键',
  `address_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '送餐电话',
  `address_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人名字',
  PRIMARY KEY (`address_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `address_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES (1, '司徒', 2, '13', NULL);
INSERT INTO `address` VALUES (2, '司徒3', 2, '21', NULL);
INSERT INTO `address` VALUES (4, 'string', 2, 'string', NULL);
INSERT INTO `address` VALUES (5, 'string', 2, 'string', NULL);

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin_pass` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', '123');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `goods_id` int(255) NOT NULL AUTO_INCREMENT COMMENT '商品主键',
  `type_id` int(11) NOT NULL COMMENT '商品类型',
  `goods_stock` int(255) NOT NULL COMMENT '商品库存',
  `goods_price` decimal(10, 2) NOT NULL COMMENT '商品价格',
  `goods_releaseTime` date NOT NULL COMMENT '商品发布时间',
  `goods_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名',
  `goods_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品描述',
  `restaurant_id` int(11) NULL DEFAULT NULL COMMENT '商家外键',
  `goods_status` int(11) NOT NULL,
  PRIMARY KEY (`goods_id`) USING BTREE,
  INDEX `type_id`(`type_id`) USING BTREE,
  INDEX `restaurant_id`(`restaurant_id`) USING BTREE,
  CONSTRAINT `goods_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `type` (`type_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `goods_ibfk_2` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurant` (`restaurant_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, 1, 100, 34.55, '2018-11-11', 'mi', 'miaoshu', 1, 0);
INSERT INTO `goods` VALUES (2, 1, 100, 10.00, '2019-03-06', '名字', '描述信息', 1, 0);

-- ----------------------------
-- Table structure for orderdetails
-- ----------------------------
DROP TABLE IF EXISTS `orderdetails`;
CREATE TABLE `orderdetails`  (
  `details_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单详情主键',
  `order_id` int(11) NOT NULL COMMENT '订单外键',
  `goods_id` int(11) NOT NULL COMMENT '商品外键',
  `details_stock` int(11) NOT NULL COMMENT '数量',
  PRIMARY KEY (`details_id`) USING BTREE,
  INDEX `order_id`(`order_id`) USING BTREE,
  INDEX `goods_id`(`goods_id`) USING BTREE,
  CONSTRAINT `orderdetails_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `orderdetails_ibfk_2` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of orderdetails
-- ----------------------------
INSERT INTO `orderdetails` VALUES (17, 11, 1, 1);
INSERT INTO `orderdetails` VALUES (18, 11, 1, 1);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单的主健',
  `user_id` int(11) NOT NULL COMMENT '用户的外键',
  `createTime` datetime NOT NULL COMMENT '下订单的时间',
  `restaurant_id` int(11) NOT NULL COMMENT '商家的外键',
  `order_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述信息',
  `order_total` decimal(10, 2) NULL DEFAULT NULL COMMENT '订单总金额',
  `order_status` int(11) NOT NULL COMMENT '订单状态',
  `address_id` int(11) NOT NULL COMMENT '收货地址外键',
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `restaurant_id`(`restaurant_id`) USING BTREE,
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurant` (`restaurant_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (11, 2, '2019-03-15 00:56:13', 1, NULL, NULL, 500, 1);

-- ----------------------------
-- Table structure for paymentdetails
-- ----------------------------
DROP TABLE IF EXISTS `paymentdetails`;
CREATE TABLE `paymentdetails`  (
  `payment_details_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '支付详情表',
  `user_id` int(11) NOT NULL COMMENT '会员表的外键',
  `order_money` decimal(10, 2) NULL DEFAULT NULL COMMENT '会员本次消费的金额',
  `status` int(11) NOT NULL COMMENT '状态',
  `order_id` int(11) NOT NULL COMMENT '订单表的外键',
  PRIMARY KEY (`payment_details_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `order_id`(`order_id`) USING BTREE,
  CONSTRAINT `paymentdetails_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `paymentdetails_ibfk_3` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for preferential
-- ----------------------------
DROP TABLE IF EXISTS `preferential`;
CREATE TABLE `preferential`  (
  `preferential_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '优惠表的主键',
  `preferential_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '优惠描述信息',
  `goods_id` int(11) NOT NULL COMMENT '商品表的外键',
  `ratio` float(10, 2) NULL DEFAULT NULL COMMENT '比率',
  `overdue` datetime NOT NULL COMMENT '活动的创建时间',
  `status` int(11) NULL DEFAULT NULL COMMENT '该活动的有效状态',
  PRIMARY KEY (`preferential_id`) USING BTREE,
  INDEX `goods_id`(`goods_id`) USING BTREE,
  CONSTRAINT `preferential_ibfk_1` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for restaurant
-- ----------------------------
DROP TABLE IF EXISTS `restaurant`;
CREATE TABLE `restaurant`  (
  `restaurant_id` int(11) NOT NULL AUTO_INCREMENT,
  `restaurant_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '餐厅编号',
  `restaurant_pass` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '餐厅密码',
  `restaurant_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '餐厅地点',
  `restaurant_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '餐厅类型',
  `restaurant_status` int(255) NULL DEFAULT NULL,
  `restaurant_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商家名字',
  `restaurant_balance` decimal(10, 2) NULL DEFAULT NULL COMMENT '商家的余额',
  PRIMARY KEY (`restaurant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of restaurant
-- ----------------------------
INSERT INTO `restaurant` VALUES (1, '17DGMFW', '123123', '正中食堂2', '吃的', NULL, '正忠食堂', NULL);
INSERT INTO `restaurant` VALUES (2, 'C4KH0ZC', '222222', '正中食堂2', '吃的', NULL, '桃阳食堂', NULL);

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type`  (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES (1, 'ss');
INSERT INTO `type` VALUES (2, '食品');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户主键',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `user_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  `user_pass` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `user_level` int(255) UNSIGNED NULL DEFAULT 1 COMMENT '用户级别',
  `user_status` int(255) UNSIGNED NULL DEFAULT 0 COMMENT '用户状态',
  `balance` decimal(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `user_email`(`user_email`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (2, 'aabb', '260098993@qq.com', '12345678', NULL, 1, 930.90);
INSERT INTO `user` VALUES (3, 'string', 'string', 'string', 0, 0, 0.00);
INSERT INTO `user` VALUES (6, '长沙彭于晏', '396009006@qq.com', '123456', 1, 1, 0.00);

SET FOREIGN_KEY_CHECKS = 1;