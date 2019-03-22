CREATE TABLE `test` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `testcol` varchar(255) DEFAULT NULL COMMENT '代码项名称',
  `created_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(255) DEFAULT NULL COMMENT '更新人',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  `version` bigint(20) DEFAULT NULL COMMENT '版本',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='TEST';
