CREATE TABLE `USER_PROFILE` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `user_role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `user_role_id` (`user_role_id`),
  CONSTRAINT `USER_PROFILE_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `USER` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `USER_PROFILE_ibfk_2` FOREIGN KEY (`user_role_id`) REFERENCES `USER_ROLE` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `VSAdb`.`USER_PROFILE`
(`id`,`user_id`,`user_role_id`)
VALUES
(1,1,1);
