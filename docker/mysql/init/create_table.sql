CREATE TABLE `user` (
     `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '사용자 Primary Key',
     `email` varchar(64) NOT NULL COMMENT '사용자 로그인용 ID',
     `provider` varchar(200) NOT NULL COMMENT '사용자 인증 서비스 사',
     `name` varchar(200) NOT NULL COMMENT '사용자 이름',
     `nickname` varchar(200) NULL COMMENT '사용자 별명',
     `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
     `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일',
     PRIMARY KEY (`id`),
     UNIQUE KEY `u_idx_1` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COMMENT='사용자 테이블';