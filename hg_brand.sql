/*
Navicat MySQL Data Transfer

Source Server         : cms
Source Server Version : 50557
Source Host           : localhost:3306
Source Database       : 1710d

Target Server Type    : MYSQL
Target Server Version : 50557
File Encoding         : 65001

Date: 2020-04-17 09:38:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hg_brand
-- ----------------------------
DROP TABLE IF EXISTS `hg_brand`;
CREATE TABLE `hg_brand` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '品牌名称',
  `first_char` varchar(1) DEFAULT NULL COMMENT '品牌首字母',
  `deleted_flag` tinyint(1) DEFAULT '0' COMMENT '删除标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hg_brand
-- ----------------------------
INSERT INTO `hg_brand` VALUES ('1', '新百伦', 'x', '0');
INSERT INTO `hg_brand` VALUES ('2', '小米', 'X', '0');
INSERT INTO `hg_brand` VALUES ('3', '苹果', 'P', '0');
INSERT INTO `hg_brand` VALUES ('4', '华为', 'H', '0');
INSERT INTO `hg_brand` VALUES ('5', '海信', 'H', '0');
INSERT INTO `hg_brand` VALUES ('6', '格力', 'g', '0');
INSERT INTO `hg_brand` VALUES ('8', '以纯', 'y', '0');
INSERT INTO `hg_brand` VALUES ('9', '大众', 'd', '0');
INSERT INTO `hg_brand` VALUES ('11', '丰田', 'f', '0');
INSERT INTO `hg_brand` VALUES ('12', '杂牌', 'z', '0');

-- ----------------------------
-- Table structure for hg_cart
-- ----------------------------
DROP TABLE IF EXISTS `hg_cart`;
CREATE TABLE `hg_cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` varchar(255) CHARACTER SET latin1 DEFAULT NULL COMMENT '用户id',
  `skuid` varchar(255) CHARACTER SET latin1 DEFAULT NULL COMMENT '商品id(商品型号)',
  `pnum` decimal(10,0) DEFAULT NULL COMMENT '购买数量',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime DEFAULT NULL COMMENT '最后修改时间',
  `sum_total` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hg_cart
-- ----------------------------
INSERT INTO `hg_cart` VALUES ('20', '2', '1', '9', '2019-11-29 11:00:39', '2019-11-29 11:00:53', '74700');
INSERT INTO `hg_cart` VALUES ('21', '2', '6', '6', '2019-11-29 11:00:44', '2019-11-29 11:00:57', '6594');
INSERT INTO `hg_cart` VALUES ('22', '1', '7', '1', '2019-12-18 08:30:27', '2019-12-18 08:30:27', '279');
INSERT INTO `hg_cart` VALUES ('23', '1', '5', '1', '2019-12-18 08:30:31', '2019-12-18 08:30:31', '4999');
INSERT INTO `hg_cart` VALUES ('31', '10', '37', '1', '2020-04-11 09:11:49', '2020-04-11 09:11:49', null);
INSERT INTO `hg_cart` VALUES ('32', '10', '32', '1', '2020-04-11 20:56:49', '2020-04-11 20:56:49', null);
INSERT INTO `hg_cart` VALUES ('33', '10', '29', '1', '2020-04-13 10:50:38', '2020-04-13 10:50:38', null);
INSERT INTO `hg_cart` VALUES ('34', '10', '39', '1', '2020-04-13 18:09:11', '2020-04-13 18:09:11', null);

-- ----------------------------
-- Table structure for hg_category
-- ----------------------------
DROP TABLE IF EXISTS `hg_category`;
CREATE TABLE `hg_category` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '类目ID',
  `parent_id` int(20) unsigned zerofill DEFAULT '00000000000000000000' COMMENT '父类目ID=0时，代表的是一级的类目',
  `name` varchar(50) DEFAULT NULL COMMENT '类目名称',
  `path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1277 DEFAULT CHARSET=utf8 COMMENT='商品类目';

-- ----------------------------
-- Records of hg_category
-- ----------------------------
INSERT INTO `hg_category` VALUES ('1233', '00000000000000000000', '电器', '电器');
INSERT INTO `hg_category` VALUES ('1241', '00000000000000000000', '电子产品', '电子产品');
INSERT INTO `hg_category` VALUES ('1242', '00000000000000001241', '手机', '电子产品/手机');
INSERT INTO `hg_category` VALUES ('1243', '00000000000000001242', '智能手机', '电子产品/手机/智能手机');
INSERT INTO `hg_category` VALUES ('1244', '00000000000000001242', '老年机', '电子产品/手机/老年机');
INSERT INTO `hg_category` VALUES ('1245', '00000000000000001233', '家用电器', '电器/家用电器');
INSERT INTO `hg_category` VALUES ('1246', '00000000000000001245', '电视', '电器/家用电器/电视');
INSERT INTO `hg_category` VALUES ('1247', '00000000000000001242', '传统手机', null);
INSERT INTO `hg_category` VALUES ('1255', '00000000000000000000', '服装', '服装');
INSERT INTO `hg_category` VALUES ('1256', '00000000000000001255', '男装', null);
INSERT INTO `hg_category` VALUES ('1257', '00000000000000001255', '女装', null);
INSERT INTO `hg_category` VALUES ('1258', '00000000000000001255', '童装', null);
INSERT INTO `hg_category` VALUES ('1259', '00000000000000001256', '正装', null);
INSERT INTO `hg_category` VALUES ('1262', '00000000000000001245', '冰箱', null);
INSERT INTO `hg_category` VALUES ('1268', '00000000000000000000', '车', '大众');
INSERT INTO `hg_category` VALUES ('1269', '00000000000000001268', '年轻人', '大众');
INSERT INTO `hg_category` VALUES ('1271', '00000000000000001269', '大众', '大众/大众');
INSERT INTO `hg_category` VALUES ('1272', '00000000000000001270', '丰田', null);
INSERT INTO `hg_category` VALUES ('1274', '00000000000000001269', '丰田', '大众/丰田');
INSERT INTO `hg_category` VALUES ('1275', '00000000000000001268', '老年人', '大众/老年人');
INSERT INTO `hg_category` VALUES ('1276', '00000000000000001275', '电动车', '大众/老年人/电动车');

-- ----------------------------
-- Table structure for hg_goods
-- ----------------------------
DROP TABLE IF EXISTS `hg_goods`;
CREATE TABLE `hg_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  `sum` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hg_goods
-- ----------------------------
INSERT INTO `hg_goods` VALUES ('1', 'ccc', '108300.00', '砖石会员', '105300');

-- ----------------------------
-- Table structure for hg_sku
-- ----------------------------
DROP TABLE IF EXISTS `hg_sku`;
CREATE TABLE `hg_sku` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id，同时也是商品编号',
  `title` varchar(100) NOT NULL COMMENT '商品标题',
  `sell_point` varchar(500) DEFAULT NULL COMMENT '商品卖点',
  `price` decimal(20,2) NOT NULL DEFAULT '0.00' COMMENT '商品价格，单位为：元',
  `stock_count` int(10) DEFAULT NULL COMMENT '库存数量',
  `barcode` varchar(30) DEFAULT NULL COMMENT '商品条形码',
  `image` varchar(2000) DEFAULT NULL COMMENT '商品图片',
  `status` varchar(1) DEFAULT NULL COMMENT '商品状态，1-正常，2-下架，3-删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `cost_price` decimal(10,2) DEFAULT NULL COMMENT '成本价',
  `market_price` decimal(10,2) DEFAULT NULL,
  `spu_id` int(11) DEFAULT NULL,
  `cart_thumbnail` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `status` (`status`),
  KEY `updated` (`update_time`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
-- Records of hg_sku
-- ----------------------------
INSERT INTO `hg_sku` VALUES ('1', 'IphonX XMD', '内存大，实用，贵贵，猴贵侯工嘎嘎发达的范德萨发撒打发打法阿道夫撒啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊', '8300.00', '95', 'XUSxxx001', 'd801dbca8e58947c.jpg', '1', '2019-11-14 15:48:41', '2019-11-21 15:48:45', '1000.00', '100.00', '1', 'd801dbca8e58947c.jpg');
INSERT INTO `hg_sku` VALUES ('2', 'IphonX XMD', '阿斯顿发生发射点理发卡打算离开房间啊但阿斯顿发大水发大水发射点发大水发大水发是', '8500.00', '0', null, '20200409/4495a8aa-bcad-448f-8db9-c58e198d2131.jpg', '0', '2019-11-20 11:03:03', '2020-04-09 18:14:47', null, null, '1', '20200409/77f5f508-7013-4e39-8938-98d6044d086f.jpg');
INSERT INTO `hg_sku` VALUES ('3', 'Redmi 8A 5000mAh', '骁龙八核处理器 AI人脸解锁 4GB+64GB 深海蓝 游戏老人手机 小米 红米', '699.00', '100', 'xxx001111', '8b167328e1dadff8.jpg', '1', '2019-11-21 15:05:46', '2019-11-21 15:05:50', '1000.00', '100.00', '3', '8b167328e1dadff8.jpg');
INSERT INTO `hg_sku` VALUES ('4', '劳弗 红米8/8A', '骁龙八核处理器 AI人脸解锁 4GB+64GB 深海蓝 游戏老人手机 小米 红米', '300.00', '100', 'xxx001112', '8b167328e1dadff8.jpg', '1', '2019-11-21 15:06:59', '2019-11-21 15:07:02', '1000.00', '100.00', '3', '8b167328e1dadff8.jp');
INSERT INTO `hg_sku` VALUES ('5', '华为（HUAWEI）Mate 30', '麒麟990旗舰芯片全网通双卡双模手机 罗兰紫 8GB+128GB【5G版', '4999.00', null, 'xxx001113', '5356c63b4bc1300a.jpg', '1', '2019-11-21 15:11:21', '2019-11-21 15:11:24', '1000.00', '100.00', '4', '5356c63b4bc1300a.jpg');
INSERT INTO `hg_sku` VALUES ('6', ' 华为 HUAWEI Mate30 Plus', '宝石蓝 全网通 四摄超清全面屏大电池 移动联通电信4G手机 双卡双待', '1099.00', '99', 'xxx001114', '5356c63b4bc1300a.jpg', '1', '2019-11-21 15:13:45', '2019-11-21 15:13:49', '100.00', '100.00', '4', '5356c63b4bc1300a.jpg');
INSERT INTO `hg_sku` VALUES ('7', '飞利浦（PHILIPS）E218L 炫舞红 ', '移动联通 翻盖老人手机 双卡双待老年机 学生备用功能机', '279.00', '0', null, '20200409/bf14c840-e542-45d5-9d15-225c855532c5.png', '0', '2019-11-21 15:19:25', '2020-04-09 18:16:27', null, null, '5', '20200409/f2ce7a6d-486f-43ef-b6d0-49609167e203.jpg');
INSERT INTO `hg_sku` VALUES ('8', '海信（Hisense）H55E3A 55英寸', '超高清4K HDR 金属背板 人工智能液晶电视机 丰富影视教育资源', '1999.00', '0', null, '20200409/793a6946-bd05-4b64-8c2b-e7fcbcdaed6e.jpg', '0', '2019-11-22 16:04:48', '2020-04-09 18:15:37', null, null, '6', '20200409/eff2932f-a82b-4150-9c73-e996f806181a.png');
INSERT INTO `hg_sku` VALUES ('9', '小米Red老年手机白色大屏', '高端大气上档次', '666.00', '0', null, '20200408/d9e5ed08-44d9-49ee-a116-7bab32f13238.jpg', '0', '2020-03-26 10:07:54', '2020-04-08 23:25:09', null, null, '9', '20200408/83b9a301-60f8-4c23-9f8b-99e442312740.jpg');
INSERT INTO `hg_sku` VALUES ('10', '我的手机', '好用', '0.00', null, null, null, null, null, null, null, null, '1', null);
INSERT INTO `hg_sku` VALUES ('11', '我的手机', '好用', '0.00', null, null, null, null, null, null, null, null, '1', null);
INSERT INTO `hg_sku` VALUES ('14', '我的手机', '好用', '0.00', null, null, null, null, null, null, null, null, '1', null);
INSERT INTO `hg_sku` VALUES ('15', '我的手机', '好用', '0.00', null, null, null, null, null, null, null, null, '1', null);
INSERT INTO `hg_sku` VALUES ('16', '我喜欢的手机', '非常的音乐好听', '0.00', null, null, null, null, null, null, null, null, '11', null);
INSERT INTO `hg_sku` VALUES ('17', '我的小米手机', '这款手机非常的漂亮', '2300.00', null, null, null, null, null, null, null, null, '1', null);
INSERT INTO `hg_sku` VALUES ('18', 'iphoneX 11', '好看', '10000.00', null, null, null, null, null, null, null, null, '1', null);
INSERT INTO `hg_sku` VALUES ('19', 'iphoneX 112', '丑陋无比', '3000.00', null, null, null, null, null, null, null, null, '1', null);
INSERT INTO `hg_sku` VALUES ('20', '小米手机Red 学生用', '适合玩游戏', '90000.00', null, null, null, null, null, null, null, null, '53', null);
INSERT INTO `hg_sku` VALUES ('21', '小米手机Red 老年用', '便宜 铃声巨大', '500.00', null, null, null, null, null, null, null, null, '53', null);
INSERT INTO `hg_sku` VALUES ('22', 'aa', '卖点', '199.00', '0', null, '20200408/efc2799c-1ba0-4d3c-85ef-97e314f4c4d4.jpg', '0', '2020-03-12 08:15:26', '2020-04-08 23:33:05', null, null, '74', '20200408/2619db87-7918-4b68-9a4b-ab2bcfc329fb.JPG');
INSERT INTO `hg_sku` VALUES ('23', '舒适大方', '结实 耐用', '245.00', '0', null, '20200408/67094c40-0505-4b81-b2f8-9a176e167228.jpg', '0', '2020-03-12 08:52:19', '2020-04-08 23:25:26', null, null, '74', '20200312/388e59a8-9ac6-4425-af4d-bc1d0bd5e6c1.jpg');
INSERT INTO `hg_sku` VALUES ('27', '111', '1111', '11111.00', '0', null, '', '1', '2020-04-09 19:07:45', '2020-04-09 19:07:45', null, null, '99', '');
INSERT INTO `hg_sku` VALUES ('28', '好看', '1', '100.00', '-1', null, '20200409/bafcb1b6-c7d2-4b16-a4e6-f8e106fa14b2.jpg', '1', '2020-04-09 19:11:22', '2020-04-09 19:11:22', null, null, '99', '20200409/3fc6117d-f5a0-4342-8aa4-77584fd13f95.jfif');
INSERT INTO `hg_sku` VALUES ('29', '1', '1', '150.00', '-3', null, '20200409/dbdfb44b-3d16-448a-8f84-11ddb8af7801.jpg', '0', '2020-04-09 19:12:25', '2020-04-09 20:01:11', null, null, '99', '20200409/30d0c444-7ecb-4704-9c1f-0ee6978e6823.gif');
INSERT INTO `hg_sku` VALUES ('30', '电脑', '400', '5000.00', '-1', null, '20200409/891e51ef-c32a-4200-9d42-be5405637e6f.png', '0', '2020-04-09 19:13:40', '2020-04-09 19:59:58', null, null, '98', '20200409/4ebf2827-181b-4302-8993-904355ed2e11.jpg');
INSERT INTO `hg_sku` VALUES ('31', '衣服', '4', '50.00', '-1', null, '20200409/68d2bd92-ab3e-497f-a1cd-092593387836.jpg', '1', '2020-04-09 19:14:25', '2020-04-09 19:14:25', null, null, '97', '20200409/eeea4ffb-0d12-47e1-abd7-accf303ca29d.jpg');
INSERT INTO `hg_sku` VALUES ('32', '新飞47', '高清 大屏', '4000.00', '-3', null, '20200409/2ce5fc63-02cd-4e93-8780-5c7208e284a2.png', '1', '2020-04-09 19:40:23', '2020-04-09 19:40:23', null, null, '85', '20200409/cd7bd480-5a0c-4203-8f3a-84ee1dad7fa6.jfif');
INSERT INTO `hg_sku` VALUES ('33', '衣服', '春季单品', '150.00', '-1', null, '20200409/8aec553c-f1fe-4ee1-b4ad-0c199654fc75.jpg', '1', '2020-04-09 19:43:28', '2020-04-09 19:43:28', null, null, '99', '20200409/d54fce4b-c2d7-4de0-bcac-3ae258bb17f6.jpg');
INSERT INTO `hg_sku` VALUES ('34', '半袖', '夏季单品', '50.00', '0', null, '20200409/5306b212-cc99-4387-837a-a2d5a48ed1c8.jpg', '1', '2020-04-09 19:50:25', '2020-04-09 19:50:25', null, null, '94', '20200409/981fbe43-fb36-469b-839a-fc6a70c4a9b3.jpg');
INSERT INTO `hg_sku` VALUES ('35', '华为p30', '200', '5000.00', '0', null, '20200409/933ed3e5-f5e7-4cbe-b7b3-73258a200420.jpg', '0', '2020-04-09 19:58:37', '2020-04-09 19:58:59', null, null, '90', '20200409/eb71e5c3-3850-4dff-a705-f0b5368cc9fa.jpg');
INSERT INTO `hg_sku` VALUES ('36', '西服', '100', '500.00', '0', null, '20200409/b9f378d9-e509-4e35-882f-fcab381627b6.jpg', '1', '2020-04-09 20:05:12', '2020-04-09 20:05:12', null, null, '84', '');
INSERT INTO `hg_sku` VALUES ('37', '衣服', '100', '500.00', '0', null, '20200409/54876c26-fb9f-445d-830d-1fd63c8ff8fa.jpg', '1', '2020-04-09 22:31:38', '2020-04-09 22:31:38', null, null, '75', '');
INSERT INTO `hg_sku` VALUES ('38', '衬衫', '衬衫', '120.00', '0', null, '20200413/4ffddcaa-a312-4d83-822d-1e0ded60fce3.jpg', '0', '2020-04-13 10:59:59', '2020-04-13 11:06:52', null, null, '74', null);
INSERT INTO `hg_sku` VALUES ('39', '测试', '测试', '100000.00', '-1', null, '20200413/5f7accc3-4e2b-4a44-874a-77c8701daa8b.jfif', '1', '2020-04-13 18:08:20', '2020-04-13 18:08:20', null, null, '100', '');

-- ----------------------------
-- Table structure for hg_sku_spec
-- ----------------------------
DROP TABLE IF EXISTS `hg_sku_spec`;
CREATE TABLE `hg_sku_spec` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sku_id` int(11) DEFAULT NULL,
  `spec_id` int(11) DEFAULT NULL,
  `spec_option_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hg_sku_spec
-- ----------------------------
INSERT INTO `hg_sku_spec` VALUES ('1', '1', '3', '10');
INSERT INTO `hg_sku_spec` VALUES ('2', '1', '4', '8');
INSERT INTO `hg_sku_spec` VALUES ('5', '3', '3', '11');
INSERT INTO `hg_sku_spec` VALUES ('6', '3', '4', '7');
INSERT INTO `hg_sku_spec` VALUES ('7', '4', '3', '11');
INSERT INTO `hg_sku_spec` VALUES ('8', '4', '4', '7');
INSERT INTO `hg_sku_spec` VALUES ('9', '5', '3', '11');
INSERT INTO `hg_sku_spec` VALUES ('10', '5', '4', '7');
INSERT INTO `hg_sku_spec` VALUES ('11', '6', '3', '11');
INSERT INTO `hg_sku_spec` VALUES ('12', '6', '4', '7');
INSERT INTO `hg_sku_spec` VALUES ('15', '15', '7', '29');
INSERT INTO `hg_sku_spec` VALUES ('16', '15', '11', '64');
INSERT INTO `hg_sku_spec` VALUES ('17', '14', '7', '29');
INSERT INTO `hg_sku_spec` VALUES ('18', '14', '11', '64');
INSERT INTO `hg_sku_spec` VALUES ('19', '16', '2', '61');
INSERT INTO `hg_sku_spec` VALUES ('20', '16', '14', '45');
INSERT INTO `hg_sku_spec` VALUES ('21', '16', '11', '67');
INSERT INTO `hg_sku_spec` VALUES ('22', '17', '15', '65');
INSERT INTO `hg_sku_spec` VALUES ('23', '17', '11', '44');
INSERT INTO `hg_sku_spec` VALUES ('24', '18', '15', '62');
INSERT INTO `hg_sku_spec` VALUES ('25', '18', '2', '28');
INSERT INTO `hg_sku_spec` VALUES ('26', '19', '15', '64');
INSERT INTO `hg_sku_spec` VALUES ('27', '19', '11', '45');
INSERT INTO `hg_sku_spec` VALUES ('28', '20', '15', '65');
INSERT INTO `hg_sku_spec` VALUES ('29', '20', '11', '61');
INSERT INTO `hg_sku_spec` VALUES ('30', '21', '15', '67');
INSERT INTO `hg_sku_spec` VALUES ('31', '21', '11', '62');
INSERT INTO `hg_sku_spec` VALUES ('44', '9', '12', '40');
INSERT INTO `hg_sku_spec` VALUES ('45', '9', '2', '61');
INSERT INTO `hg_sku_spec` VALUES ('46', '23', '6', '27');
INSERT INTO `hg_sku_spec` VALUES ('47', '23', '12', '41');
INSERT INTO `hg_sku_spec` VALUES ('48', '23', '11', '67');
INSERT INTO `hg_sku_spec` VALUES ('49', '22', '12', '40');
INSERT INTO `hg_sku_spec` VALUES ('50', '22', '6', '27');
INSERT INTO `hg_sku_spec` VALUES ('51', '2', '20', '77');
INSERT INTO `hg_sku_spec` VALUES ('52', '8', '17', '50');
INSERT INTO `hg_sku_spec` VALUES ('53', '7', '8', '32');
INSERT INTO `hg_sku_spec` VALUES ('54', '27', '2', '61');
INSERT INTO `hg_sku_spec` VALUES ('55', '28', '12', '40');
INSERT INTO `hg_sku_spec` VALUES ('58', '31', '12', '39');
INSERT INTO `hg_sku_spec` VALUES ('59', '32', '21', '80');
INSERT INTO `hg_sku_spec` VALUES ('60', '32', '7', '29');
INSERT INTO `hg_sku_spec` VALUES ('61', '33', '21', '79');
INSERT INTO `hg_sku_spec` VALUES ('62', '33', '12', '39');
INSERT INTO `hg_sku_spec` VALUES ('65', '34', '11', '84');
INSERT INTO `hg_sku_spec` VALUES ('66', '34', '12', '39');
INSERT INTO `hg_sku_spec` VALUES ('71', '35', '20', '77');
INSERT INTO `hg_sku_spec` VALUES ('72', '35', '20', '77');
INSERT INTO `hg_sku_spec` VALUES ('73', '35', '11', '85');
INSERT INTO `hg_sku_spec` VALUES ('74', '35', '11', '85');
INSERT INTO `hg_sku_spec` VALUES ('77', '30', '7', '29');
INSERT INTO `hg_sku_spec` VALUES ('78', '30', '21', '80');
INSERT INTO `hg_sku_spec` VALUES ('79', '29', '11', '85');
INSERT INTO `hg_sku_spec` VALUES ('80', '29', '11', '86');
INSERT INTO `hg_sku_spec` VALUES ('81', '36', '21', '79');
INSERT INTO `hg_sku_spec` VALUES ('82', '36', '12', '41');
INSERT INTO `hg_sku_spec` VALUES ('83', '37', '11', '86');
INSERT INTO `hg_sku_spec` VALUES ('84', '37', '12', '40');
INSERT INTO `hg_sku_spec` VALUES ('89', '38', '11', '85');
INSERT INTO `hg_sku_spec` VALUES ('90', '38', '12', '41');
INSERT INTO `hg_sku_spec` VALUES ('91', '39', '2', '63');
INSERT INTO `hg_sku_spec` VALUES ('92', '39', '21', '81');
INSERT INTO `hg_sku_spec` VALUES ('93', '39', '22', '83');

-- ----------------------------
-- Table structure for hg_spec
-- ----------------------------
DROP TABLE IF EXISTS `hg_spec`;
CREATE TABLE `hg_spec` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `spec_name` varchar(255) DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hg_spec
-- ----------------------------
INSERT INTO `hg_spec` VALUES ('2', '体积');
INSERT INTO `hg_spec` VALUES ('7', '功率');
INSERT INTO `hg_spec` VALUES ('11', '颜色');
INSERT INTO `hg_spec` VALUES ('12', '衣服尺码');
INSERT INTO `hg_spec` VALUES ('17', '功率22');
INSERT INTO `hg_spec` VALUES ('20', '内存');
INSERT INTO `hg_spec` VALUES ('21', '价格');
INSERT INTO `hg_spec` VALUES ('22', '速度');

-- ----------------------------
-- Table structure for hg_spec_option
-- ----------------------------
DROP TABLE IF EXISTS `hg_spec_option`;
CREATE TABLE `hg_spec_option` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '规格项ID',
  `option_name` varchar(200) DEFAULT NULL COMMENT '规格项名称',
  `spec_id` int(11) DEFAULT NULL COMMENT '规格ID',
  `orders` int(11) DEFAULT NULL COMMENT '排序值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hg_spec_option
-- ----------------------------
INSERT INTO `hg_spec_option` VALUES ('11', '8GB', null, null);
INSERT INTO `hg_spec_option` VALUES ('28', '40W', '7', null);
INSERT INTO `hg_spec_option` VALUES ('29', '100W', '7', null);
INSERT INTO `hg_spec_option` VALUES ('39', '42', '12', '0');
INSERT INTO `hg_spec_option` VALUES ('40', '48', '12', '0');
INSERT INTO `hg_spec_option` VALUES ('41', '50', '12', '0');
INSERT INTO `hg_spec_option` VALUES ('46', '', '15', '0');
INSERT INTO `hg_spec_option` VALUES ('50', '999', '17', '0');
INSERT INTO `hg_spec_option` VALUES ('51', '777', '17', '0');
INSERT INTO `hg_spec_option` VALUES ('61', '100ml', '2', '0');
INSERT INTO `hg_spec_option` VALUES ('62', '300ml', '2', '0');
INSERT INTO `hg_spec_option` VALUES ('63', '6L', '2', '0');
INSERT INTO `hg_spec_option` VALUES ('75', '16g', '20', '1');
INSERT INTO `hg_spec_option` VALUES ('76', '64g', '20', '2');
INSERT INTO `hg_spec_option` VALUES ('77', '128', '20', '3');
INSERT INTO `hg_spec_option` VALUES ('78', '0-100', '21', '1');
INSERT INTO `hg_spec_option` VALUES ('79', '100-1000', '21', '2');
INSERT INTO `hg_spec_option` VALUES ('80', '1000-10000', '21', '3');
INSERT INTO `hg_spec_option` VALUES ('81', '10000-100000', '21', '4');
INSERT INTO `hg_spec_option` VALUES ('82', '8km/min', '22', '1');
INSERT INTO `hg_spec_option` VALUES ('83', '80km/min', '22', '2');
INSERT INTO `hg_spec_option` VALUES ('84', '金属黑', '11', '0');
INSERT INTO `hg_spec_option` VALUES ('85', '宝石蓝', '11', '0');
INSERT INTO `hg_spec_option` VALUES ('86', '玫瑰金', '11', '0');
INSERT INTO `hg_spec_option` VALUES ('87', '罗兰紫', '11', '0');

-- ----------------------------
-- Table structure for hg_spu
-- ----------------------------
DROP TABLE IF EXISTS `hg_spu`;
CREATE TABLE `hg_spu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `goods_name` varchar(100) DEFAULT NULL COMMENT 'SPU名',
  `is_marketable` varchar(1) DEFAULT NULL COMMENT '是否上架',
  `brand_id` int(11) DEFAULT NULL COMMENT '品牌',
  `caption` varchar(100) DEFAULT NULL COMMENT '副标题',
  `category_id` int(11) DEFAULT NULL COMMENT '一级类目',
  `small_pic` varchar(150) DEFAULT NULL COMMENT '小图',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hg_spu
-- ----------------------------
INSERT INTO `hg_spu` VALUES ('1', 'iPhone X', '1', '3', null, '1243', null);
INSERT INTO `hg_spu` VALUES ('3', 'Redmi', '1', '2', null, '1243', null);
INSERT INTO `hg_spu` VALUES ('4', '华为Mat30', '1', '4', null, '1243', null);
INSERT INTO `hg_spu` VALUES ('5', '飞利浦（PHILIPS）E218L', '1', '2', null, '1244', null);
INSERT INTO `hg_spu` VALUES ('6', '海信（Hisense）', '1', '5', null, '1246', null);
INSERT INTO `hg_spu` VALUES ('7', 'p50', null, '4', '华为高端手机', '1243', 'fde0251c-ab66-4fa8-9f9c-29753ea9fdc6_3.jpg');
INSERT INTO `hg_spu` VALUES ('8', 'VIVO X6 ', null, '4', 'vivo 拍照手机', '1243', 'b68bafcf-081d-45b8-a78a-565409567efe_4.jpg');
INSERT INTO `hg_spu` VALUES ('9', '小米REd6', null, '2', '红米 老年手机', '1244', '');
INSERT INTO `hg_spu` VALUES ('10', '手机', null, '5', '好手机', '1243', null);
INSERT INTO `hg_spu` VALUES ('11', '手机', null, '5', '好手机', '1243', '20200309/9260d06d-6815-484e-a5b2-1d1fc86d0450.jpg');
INSERT INTO `hg_spu` VALUES ('41', 'test222zz', null, '2', 'wweee', '1246', '20200309/99ac088d-1da5-49e4-81af-e429b74029b9.out');
INSERT INTO `hg_spu` VALUES ('42', '小米电脑', null, '2', '小米商务笔记本P50', '1246', '20200311/7d10c43a-d408-44f9-9060-57e4182a5fea.jpg');
INSERT INTO `hg_spu` VALUES ('43', '华为笔记本电脑', null, '4', '华为笔记本电脑P70', '1253', '20200311/bdb1a49e-8f71-4007-bfcb-f9ed47acc358.jpg');
INSERT INTO `hg_spu` VALUES ('44', '华为笔记本商务电脑', null, '4', '华为笔记本电脑P80', '1253', '20200311/1ac80186-8eeb-4d09-b605-f5ca1d04d094.jpg');
INSERT INTO `hg_spu` VALUES ('46', '华为休闲商务', null, '4', '华为LV490', '1246', '20200311/6dd7f79e-f99c-4ec7-b15b-7aef55ab5d28.jpg');
INSERT INTO `hg_spu` VALUES ('47', '小米手机', null, '2', '小米Mate0', '1243', '20200311/9e9afc3a-4631-48c1-b054-1aa923fef0f8.jpg');
INSERT INTO `hg_spu` VALUES ('48', '小米手机Note', null, '2', '小米Mate0Note', '1243', '20200311/c92941b1-6f74-4a11-aa56-1fed20f9b3bb.jpg');
INSERT INTO `hg_spu` VALUES ('53', '小米手机Red', null, '2', '小米红米', '1247', '20200311/38d6aa3d-f910-462e-a10a-ca3274eafbe4.jpg');
INSERT INTO `hg_spu` VALUES ('74', '杉杉衬衫22', null, '6', '改好了？这是一款很好的高级衬衫，防止缩水', '1243', '20200311/8b2aa9ae-bd10-4189-a8e4-398b45680ca2.jpg');
INSERT INTO `hg_spu` VALUES ('75', '非常好看的衣服', null, '6', '这个部分的东西可以完全省略掉', '1243', '20200409/f5642e32-b0ec-4f64-865b-d3178a721723.jpg');
INSERT INTO `hg_spu` VALUES ('84', '红豆西服', null, '4', '成功男士的首选西装', '1259', '20200409/6f4cd7a7-b249-4f7e-b68a-6f9273171606.jpg');
INSERT INTO `hg_spu` VALUES ('85', '新飞47', '1', '5', '清新 大屏', '1246', '20200409/17efee26-c480-46eb-a281-385b78dab66e.jpg');
INSERT INTO `hg_spu` VALUES ('88', '大众v7', '1', '5', '安全 性能好', '1246', '20200409/f536f9a2-2486-41b1-820a-fe87914cb344.png');
INSERT INTO `hg_spu` VALUES ('90', '华为p30', '1', '4', '手机降价', '1243', '20200409/c593ac53-f571-4992-9444-188bbbac9dc7.jpg');
INSERT INTO `hg_spu` VALUES ('94', '半袖', '1', '8', '便宜甩卖', '1257', '20200409/4c89336a-32ed-4255-88d9-1863f59b341d.jpg');
INSERT INTO `hg_spu` VALUES ('97', '夏季美人装', '1', '5', '非常漂亮 迷人', '1257', '20200409/2bf1b831-b6fa-4176-9e05-3e573d0b70af.jpg');
INSERT INTO `hg_spu` VALUES ('98', '小新超', '1', '2', '电脑/学习', '1243', '20200409/98b7aca3-ca8f-4c26-8d7e-0b82b0da94ad.jpg');
INSERT INTO `hg_spu` VALUES ('99', '背带裤', '1', '8', '背带裤/好看', '1257', '20200409/9437190f-4941-433a-aa7e-eab07cdbe1a2.jpg');
INSERT INTO `hg_spu` VALUES ('100', 'ceshi shangping', '1', '9', 'test caption', '1271', '20200413/eec28058-c480-4079-b349-6b57f8309355.jfif');
INSERT INTO `hg_spu` VALUES ('104', 'ceshi shangping', null, '1', 'test caption', '10', null);

-- ----------------------------
-- Table structure for hg_user
-- ----------------------------
DROP TABLE IF EXISTS `hg_user`;
CREATE TABLE `hg_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(60) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `code` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hg_user
-- ----------------------------
INSERT INTO `hg_user` VALUES ('1', 'chj', '123', '李四', 'chj@qq.com', null, '2019-11-07', null, null, null);
INSERT INTO `hg_user` VALUES ('2', 'chjx', '123', '李伟', 'lisi@qq.com', null, '2019-11-05', null, null, null);
INSERT INTO `hg_user` VALUES ('7', 'chjy', '123', '李达', null, null, null, null, null, null);
INSERT INTO `hg_user` VALUES ('9', 'zhangsan', 'e10adc3949ba59abbe56e057f20f883e', '张三', 'zhuag@sohu.com', '13683679291', null, '0', '0', null);
INSERT INTO `hg_user` VALUES ('10', 'bbb', '123', null, null, null, null, null, null, null);
INSERT INTO `hg_user` VALUES ('11', 'ccc', '60a12c45c664f9c3a488561930d09a82', null, null, null, null, null, null, null);
