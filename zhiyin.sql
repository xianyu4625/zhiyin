/*
 Navicat Premium Data Transfer

 Source Server         : centos
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : 192.168.228.10:3306
 Source Schema         : zhiyin

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 27/02/2024 23:25:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `commentid` int(0) NOT NULL AUTO_INCREMENT COMMENT '评论表',
  `userid` int(0) NULL DEFAULT NULL COMMENT '用户id',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '内容',
  `timestamp` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '时间',
  `suggestionid` int(0) NULL DEFAULT NULL COMMENT '建议id',
  `deleted` int(0) NULL DEFAULT 0 COMMENT '删除标记1为删除0为正常',
  PRIMARY KEY (`commentid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, 8, '他那个杯子没洗干净', '2024-02-02 17:42:03', 3, 0);

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback`  (
  `feedbackid` int(0) NOT NULL AUTO_INCREMENT COMMENT '意见反馈表id',
  `userid` int(0) NULL DEFAULT NULL COMMENT '用户id',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '内容',
  `timetemp` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '时间',
  `show` int(0) NULL DEFAULT 0 COMMENT '是否展示0展示1隐藏',
  `deleted` int(0) NULL DEFAULT 0 COMMENT '删除标记1为删除0为正常',
  `suggestionid` int(0) NULL DEFAULT NULL COMMENT '建议id',
  PRIMARY KEY (`feedbackid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of feedback
-- ----------------------------
INSERT INTO `feedback` VALUES (2, 5, '九月椒的卫生我们已经排查过了，我们会尽力整改', '2024-02-02 15:34:14', 0, 0, 3);

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `goodid` int(0) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `goodname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品名称',
  `scription` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品描述',
  `goodimg` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品照片',
  `score` int(0) NULL DEFAULT NULL COMMENT '所需积分',
  `deleted` int(0) NULL DEFAULT 0 COMMENT '删除标记1为删除0为正常',
  PRIMARY KEY (`goodid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, '书签', '精美镂空书签，铁质扇子模型', 'https://ts1.cn.mm.bing.net/th?id=OIP-C.GBatoR8S7C0H6UF2YIUOFQHaHZ&w=144&h=150&c=8&rs=1&qlt=90&o=6&dpr=1.3&pid=3.1&rm=2', 90, 0);
INSERT INTO `goods` VALUES (2, '钢笔', '铱金笔练字钢笔007正楷', 'http://img.alicdn.com/i3/1913947441/O1CN01T5Q6vE24q1daQTumE_!!0-item_pic.jpg?&w=121&h=121&rs=0&qlt=100', 990, 0);
INSERT INTO `goods` VALUES (3, '毛笔', '正楷小笔，狼毫秀丽笔', 'https://ts1.cn.mm.bing.net/th?id=OIP-C.-L117UEUkDzYFodJ3RirLQHaE8&w=210&h=150&c=8&rs=1&qlt=90&o=6&dpr=1.3&pid=3.1&rm=2', 880, 0);
INSERT INTO `goods` VALUES (4, '铅笔', '2B铅笔,不易断，小学生专用铅笔', 'https://tse4-mm.cn.bing.net/th/id/OIP-C.oe8P-cQzMAhs1j67cuElRQHaGQ?w=249&h=210&c=7&r=0&o=5&dpr=1.3&pid=1.7', 880, 0);
INSERT INTO `goods` VALUES (5, '微信红包封面', '好看的微信红包封面，龙年封面', 'https://cdn.jsdelivr.net/gh/xianyu4625/imageBed/202402152219329.png', 30, 0);

-- ----------------------------
-- Table structure for like
-- ----------------------------
DROP TABLE IF EXISTS `like`;
CREATE TABLE `like`  (
  `likeid` int(0) NOT NULL AUTO_INCREMENT COMMENT '点赞表',
  `userid` int(0) NULL DEFAULT NULL COMMENT '用户id',
  `timestamp` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '时间',
  `suggestionid` int(0) NULL DEFAULT NULL COMMENT '建议id',
  `deleted` int(0) NULL DEFAULT 0 COMMENT '删除标记1为删除0为正常',
  PRIMARY KEY (`likeid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of like
-- ----------------------------
INSERT INTO `like` VALUES (1, 6, '2024-02-02 16:32:51', 3, 0);
INSERT INTO `like` VALUES (3, 8, '2024-02-02 17:03:13', 3, 1);

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `noticeid` int(0) NOT NULL AUTO_INCREMENT COMMENT '公告id',
  `userid` int(0) NULL DEFAULT NULL COMMENT '发布人',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '公告内容',
  `timestamp` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '发布时间',
  `deleted` int(0) NULL DEFAULT 0 COMMENT '1为删除',
  `show` int(0) NULL DEFAULT 0 COMMENT '0为展示',
  PRIMARY KEY (`noticeid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (1, 5, '2月12日西夏区北京西路路街区停水5小时，请做好相关准备', '2024-02-02 19:02:42', 0, 1);
INSERT INTO `notice` VALUES (19, 5, '<p>紧急通知：停水通知</p><p>由于维护工程需要，我们将进行紧急停水。请注意以下停水时间和范围：</p><p>停水时间：2024年2月18日（星期五）上午9点至下午2点</p><p>停水范围：物业小区所有楼栋</p><p><br></p>', '2024-02-16 20:58:06', 0, 0);
INSERT INTO `notice` VALUES (20, 5, '<p>鉴于锁正鹏同学上课玩金铲铲，记过处分</p>', '2024-02-17 11:36:29', 0, 0);
INSERT INTO `notice` VALUES (21, 5, '<p>是否</p>', '2024-02-18 21:35:23', 0, 0);
INSERT INTO `notice` VALUES (22, 5, '<p><span style=\"background-color: rgb(255, 255, 255); color: rgb(56, 58, 66);\">由于维护工程需要，我们将进行紧急停水。请注意以下停水时间和范围：</span></p><p><br></p>', '2024-02-18 21:35:48', 0, 0);
INSERT INTO `notice` VALUES (23, 5, '<p>这这里可以编辑发表公告等信息</p>', '2024-02-18 22:10:49', 0, 0);

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `permissionid` int(0) NOT NULL COMMENT '权限表id',
  `roleid` int(0) NULL DEFAULT NULL COMMENT '角色id',
  `permission` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '权限',
  PRIMARY KEY (`permissionid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (1, 1, '查看评论，点赞，发文，兑换商品');

-- ----------------------------
-- Table structure for report
-- ----------------------------
DROP TABLE IF EXISTS `report`;
CREATE TABLE `report`  (
  `reportid` int(0) NOT NULL AUTO_INCREMENT COMMENT '举报表id',
  `userid` int(0) NULL DEFAULT NULL COMMENT '用户id',
  `reportcontent` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '举报内容',
  `timestamp` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '时间',
  `show` int(0) NULL DEFAULT 0 COMMENT '展示1为展示0为不展示',
  `deleted` int(0) NULL DEFAULT 0 COMMENT '删除标记1为删除0为正常',
  PRIMARY KEY (`reportid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of report
-- ----------------------------
INSERT INTO `report` VALUES (1, 5, '举报是指公民或者单位依法行使其民主权利，向司法机关或者其他有关国家机关和组织检举、控告违纪、违法或犯罪的行为', '2024-02-01 17:21:55', 0, 0);
INSERT INTO `report` VALUES (2, 6, '举报强盛集团非法压榨员工', '2024-02-01 22:55:55', 0, 0);
INSERT INTO `report` VALUES (3, 5, '<p>举报锁正鹏玩金铲铲</p>', '2024-02-16 11:35:35', 0, 0);
INSERT INTO `report` VALUES (4, 5, '<p>举报锁正鹏上课玩手机</p>', '2024-02-17 11:36:51', 0, 0);

-- ----------------------------
-- Table structure for report_comment
-- ----------------------------
DROP TABLE IF EXISTS `report_comment`;
CREATE TABLE `report_comment`  (
  `reportid` int(0) NULL DEFAULT NULL COMMENT '举报id',
  `commentid` int(0) NULL DEFAULT NULL COMMENT '评论id'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of report_comment
-- ----------------------------

-- ----------------------------
-- Table structure for report_like
-- ----------------------------
DROP TABLE IF EXISTS `report_like`;
CREATE TABLE `report_like`  (
  `reportid` int(0) NULL DEFAULT NULL COMMENT '举报表id',
  `likeid` int(0) NULL DEFAULT NULL COMMENT '点赞id'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of report_like
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `roleid` int(0) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `rolename` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '角色名字',
  PRIMARY KEY (`roleid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '管理员');
INSERT INTO `role` VALUES (2, '普通用户');

-- ----------------------------
-- Table structure for scorerecord
-- ----------------------------
DROP TABLE IF EXISTS `scorerecord`;
CREATE TABLE `scorerecord`  (
  `scoreid` int(0) NOT NULL AUTO_INCREMENT COMMENT '积分id',
  `userid` int(0) NULL DEFAULT NULL COMMENT '用户id',
  `score` int(0) NULL DEFAULT NULL COMMENT '积分',
  PRIMARY KEY (`scoreid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of scorerecord
-- ----------------------------
INSERT INTO `scorerecord` VALUES (1, 5, 30);
INSERT INTO `scorerecord` VALUES (4, 8, 10);
INSERT INTO `scorerecord` VALUES (5, 6, 15);
INSERT INTO `scorerecord` VALUES (6, 7, 10);
INSERT INTO `scorerecord` VALUES (7, 9, 10);
INSERT INTO `scorerecord` VALUES (8, 10, 10);

-- ----------------------------
-- Table structure for suggestion
-- ----------------------------
DROP TABLE IF EXISTS `suggestion`;
CREATE TABLE `suggestion`  (
  `suggestionid` int(0) NOT NULL AUTO_INCREMENT COMMENT '建议id',
  `userid` int(0) NULL DEFAULT NULL COMMENT '用户id',
  `question` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '存在问题',
  `suggestion` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '建议',
  `timestamp` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '时间',
  `show` int(0) NULL DEFAULT 0 COMMENT '是否展示0展示1不展示',
  `deleted` int(0) NULL DEFAULT 0 COMMENT '删除标记1为删除0为正常',
  PRIMARY KEY (`suggestionid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of suggestion
-- ----------------------------
INSERT INTO `suggestion` VALUES (1, 5, '北京东路234号路灯不亮北京东路234号路灯不亮北京东路234号路灯不亮', '建议尽早修理路灯', '2024-02-01 12:30:55', 0, 0);
INSERT INTO `suggestion` VALUES (2, 5, '北京西路未打扫干净', '增加人手，尽快处理', '2024-02-01 13:07:29', 0, 0);
INSERT INTO `suggestion` VALUES (3, 6, '宁阳广场九月椒自助卫生不干净', '建议严查环境卫生', '2024-02-02 00:01:35', 0, 0);
INSERT INTO `suggestion` VALUES (4, 5, '知音平台操作指南', '注册登录查看', '2024-02-13 21:43:39', 0, 0);
INSERT INTO `suggestion` VALUES (5, 5, '帝豪小区车辆问题', '<p>车辆乱停乱放</p><p>没有划分停车位</p><p>停车收费不明确</p>', '2024-02-15 14:53:51', 0, 0);
INSERT INTO `suggestion` VALUES (6, 5, '二中南路积雪', '<p><br></p>', '2024-02-15 15:07:30', 0, 0);
INSERT INTO `suggestion` VALUES (7, 5, '道路积雪未处理', '<p>积雪太多未及时清扫，地面结冰</p>', '2024-02-15 15:42:54', 0, 0);
INSERT INTO `suggestion` VALUES (8, 5, '交通拥堵', '<p>下午5.30学生放学交通拥堵，学生不走斑马线，乱窜</p>', '2024-02-15 15:49:15', 0, 0);

-- ----------------------------
-- Table structure for switch
-- ----------------------------
DROP TABLE IF EXISTS `switch`;
CREATE TABLE `switch`  (
  `switchid` int(0) NOT NULL AUTO_INCREMENT COMMENT '积分兑换id',
  `userid` int(0) NULL DEFAULT NULL COMMENT '用户id',
  `goodid` int(0) NULL DEFAULT NULL COMMENT '商品id',
  `change` int(0) NULL DEFAULT NULL COMMENT '积分变化值',
  `timestamp` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '时间',
  `deleted` int(0) NULL DEFAULT 0 COMMENT '删除标记1为删除0为正常',
  PRIMARY KEY (`switchid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of switch
-- ----------------------------
INSERT INTO `switch` VALUES (1, 5, 1, 10, '2024-01-31 00:23:57', 0);
INSERT INTO `switch` VALUES (2, 5, 1, 10, '2024-01-31 19:53:51', 0);
INSERT INTO `switch` VALUES (3, 5, 2, 10, '2024-01-31 19:56:54', 0);
INSERT INTO `switch` VALUES (4, 6, 2, 10, '2024-02-01 23:45:27', 0);
INSERT INTO `switch` VALUES (5, 5, 5, 30, '2024-02-15 22:29:39', 0);
INSERT INTO `switch` VALUES (6, 5, 5, 30, '2024-02-17 11:35:44', 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `Id` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名称',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户密码',
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '昵称',
  `userpic` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户头像地址',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  `score` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户积分',
  `createtime` datetime(0) NOT NULL COMMENT '创建时间',
  `updatetime` datetime(0) NOT NULL COMMENT '更新时间',
  `roleid` int(0) NULL DEFAULT NULL COMMENT '角色id',
  `deleted` int(0) NULL DEFAULT 0 COMMENT '删除1为删除0为正常',
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (5, 'xianyu4625', 'e10adc3949ba59abbe56e057f20f883e', '咸鱼', 'https://cdn.jsdelivr.net/gh/xianyu4625/imageBed/202402070039673.jpg', '2052309069@qq.com', '80', '2024-01-29 13:38:59', '2024-02-14 10:42:46', 1, 0);
INSERT INTO `user` VALUES (6, 'feiyangyang', '4297f44b13955235245b2497399d7a93', 'tiangou', 'http://img1.ali213.net/glpic/2022/03/09/584_2022030915909642.jpg', 'tiangou@qq.com', '10', '2024-01-30 12:44:12', '2024-02-01 22:57:18', 1, 0);
INSERT INTO `user` VALUES (7, 'lanyangyang', '4297f44b13955235245b2497399d7a93', NULL, '', NULL, '10', '2024-01-30 12:44:54', '2024-01-30 12:44:54', 1, 0);
INSERT INTO `user` VALUES (8, 'cunzhang', '4297f44b13955235245b2497399d7a93', NULL, NULL, NULL, '10', '2024-01-30 12:47:04', '2024-01-30 12:47:04', 1, 0);
INSERT INTO `user` VALUES (9, 'nobug', '4297f44b13955235245b2497399d7a93', '原神学长', 'https://zhiyinimage.oss-cn-beijing.aliyuncs.com/7ee83d78-2bb6-429e-a93b-6ad6b8e87a68.png', '123@qq.com', '10', '2024-02-04 20:50:37', '2024-02-17 11:38:40', 2, 0);
INSERT INTO `user` VALUES (10, '锁正鹏你好', '96e79218965eb72c92a549dd5a330112', NULL, 'https://zhiyinimage.oss-cn-beijing.aliyuncs.com/169d465d-385a-4aa4-8d04-c0892d1a3e3f.png', NULL, '10', '2024-02-04 20:53:27', '2024-02-07 17:36:06', 2, 0);

-- ----------------------------
-- View structure for report_user_view
-- ----------------------------
DROP VIEW IF EXISTS `report_user_view`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `report_user_view` AS select `r`.`reportid` AS `reportid`,`r`.`userid` AS `userid`,`r`.`reportcontent` AS `reportcontent`,`r`.`timestamp` AS `timestamp`,`r`.`show` AS `show`,`r`.`deleted` AS `deleted`,`u`.`nickname` AS `nickname`,`u`.`roleid` AS `roleid` from (`report` `r` join `user` `u` on((`r`.`userid` = `u`.`Id`)));

-- ----------------------------
-- View structure for suggestion_user_view
-- ----------------------------
DROP VIEW IF EXISTS `suggestion_user_view`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `suggestion_user_view` AS select `s`.`suggestionid` AS `suggestionid`,`s`.`userid` AS `userid`,`s`.`question` AS `question`,`s`.`suggestion` AS `suggestion`,`s`.`timestamp` AS `timestamp`,`s`.`show` AS `show`,`s`.`deleted` AS `deleted`,`u`.`username` AS `username`,`u`.`roleid` AS `roleid` from (`suggestion` `s` join `user` `u` on((`s`.`userid` = `u`.`Id`)));

-- ----------------------------
-- View structure for switch_view
-- ----------------------------
DROP VIEW IF EXISTS `switch_view`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `switch_view` AS select `s`.`switchid` AS `switchid`,`u`.`username` AS `username`,`g`.`goodname` AS `goodname`,`s`.`change` AS `change`,`s`.`timestamp` AS `timestamp`,`s`.`userid` AS `userid` from ((`switch` `s` left join `user` `u` on((`s`.`userid` = `u`.`Id`))) left join `goods` `g` on((`s`.`goodid` = `g`.`goodid`)));

SET FOREIGN_KEY_CHECKS = 1;
