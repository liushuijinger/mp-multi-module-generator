SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

CREATE TABLE `user` (
                        `id` bigint(20) NOT NULL COMMENT '主键ID',
                        `name` varchar(30) DEFAULT NULL COMMENT '姓名',
                        `age` int(11) DEFAULT NULL COMMENT '年龄',
                        `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
                        `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO mp.user (id, name, age, email) VALUES (1, 'Jone', 18, 'test1@baomidou.com');
INSERT INTO mp.user (id, name, age, email) VALUES (2, 'Jack', 20, 'test2@baomidou.com');
INSERT INTO mp.user (id, name, age, email) VALUES (3, 'Tom', 28, 'test3@baomidou.com');
INSERT INTO mp.user (id, name, age, email) VALUES (4, 'Sandy', 21, 'test4@baomidou.com');
INSERT INTO mp.user (id, name, age, email) VALUES (5, 'Billie', 24, 'test5@baomidou.com');


SET FOREIGN_KEY_CHECKS = 1;
