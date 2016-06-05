CREATE TABLE `TEAM` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_bin NOT NULL,
  `short_name` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `notes` varchar(250) COLLATE utf8_bin DEFAULT NULL,
  `creator` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_TEAM_1_idx` (`creator`),
  CONSTRAINT `fk_TEAM_1` FOREIGN KEY (`creator`) REFERENCES `USER` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
