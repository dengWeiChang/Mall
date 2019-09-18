user db_mall;
-- ----------------------------
-- Table structure for tb_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_category`;
CREATE TABLE `tb_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(32) NOT NULL COMMENT '类目名称',
  `parent_id` bigint(20) NOT NULL COMMENT '父类目id,顶级类目为0',
  `is_parent` tinyint(1) NOT NULL COMMENT '是否为父节点，0为否，1为是',
  `sort` int(4) NULL DEFAULT '1' COMMENT '排序指数，越小越靠前',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_enable` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有效，0为否，1为是',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除，0为否，1为是',
  PRIMARY KEY (`id`),
  KEY `key_parent_id` (`parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品类目表';

INSERT INTO `tb_category` VALUES (1, '家用电器', 0, 1, 1, '2019-9-16 12:46:22', '2019-9-16 12:46:22', 1, 0);
INSERT INTO `tb_category` VALUES (2, '个护化妆', 0, 1, 4, '2019-9-16 17:46:33', '2019-9-16 17:46:33', 1, 1);
INSERT INTO `tb_category` VALUES (3, '大家电', 1, 1, 3, '2019-9-17 10:02:43', '2019-9-17 10:02:43', 1, 0);
INSERT INTO `tb_category` VALUES (4, '生活电器', 1, 1, 1, '2019-9-17 10:02:56', '2019-9-17 10:02:56', 1, 1);
INSERT INTO `tb_category` VALUES (5, '钟表', 0, 1, 1, '2019-9-17 14:20:12', '2019-9-17 14:20:12', 1, 0);


-- ----------------------------
-- Table structure for tb_brand
-- ----------------------------
DROP TABLE IF EXISTS `tb_brand`;
CREATE TABLE `tb_brand` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(32) NOT NULL COMMENT '品牌名称',
  `image` varchar(128) DEFAULT '' COMMENT '品牌图片URL地址',
  `letter` char(1) DEFAULT '' COMMENT '品牌首字母',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_enable` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有效，0为否，1为是',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除，0为否，1为是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='品牌表';

INSERT INTO `tb_brand` VALUES (null, '华为（HUAWEI）', 'http://img10.360buyimg.com/popshop/jfs/t5662/36/8888655583/7806/1c629c01/598033b4Nd6055897.jpg', 'H', null, null, 1, 0);
INSERT INTO `tb_brand` VALUES (null, 'Apple', 'http://img12.360buyimg.com/popshop/jfs/t2989/240/151377693/3895/30ad9044/574d36dbN262ef26d.jpg', 'A', null, null, 1, 0);
INSERT INTO `tb_brand` VALUES (null, '小米（MI）', 'http://img10.360buyimg.com/popshop/jfs/t7084/169/439244907/4647/724c7958/598042c9N6e4e79e5.jpg', 'X', null, null, 1, 0);
INSERT INTO `tb_brand` VALUES (null, '一加', 'http://img14.360buyimg.com/popshop/jfs/t2398/233/975959106/6263/a786f5b8/563b33ffN9c288c6c.jpg', 'Y', null, null, 1, 0);
INSERT INTO `tb_brand` VALUES (null, '锤子（smartisan）', 'http://img13.360buyimg.com/popshop/jfs/t1954/102/907711365/5487/9f26868f/5631ccdeNe8df5efb.jpg', 'C', null, null, 1, 0);
INSERT INTO `tb_brand` VALUES (null, '海尔（Haier）', 'http://image.leyou.com/group1/M00/00/00/wKhSZFufmLeAektLAAAZT9-WCLY396.jpg', 'H', null, null, 1, 0);
INSERT INTO `tb_brand` VALUES (null, '海信（Hisense）', '', 'H', null, null, 1, 0);
INSERT INTO `tb_brand` VALUES (null, '黑莓（BlackBerry）', '', 'H', null, null, 1, 0);
INSERT INTO `tb_brand` VALUES (null, '华硕（ASUS）', '', 'H', null, null, 1, 0);