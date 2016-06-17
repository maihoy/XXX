CREATE TABLE `SCORE` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `my_team` int(11) NOT NULL,
  `their_team` int(11) NOT NULL,
  `my_score` tinyint(40) NOT NULL,
  `their_srore` tinyint(40) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_SCORE_1_idx` (`my_team`),
  KEY `fk_SCORE_2_idx` (`their_team`),
  CONSTRAINT `fk_SCORE_1` FOREIGN KEY (`my_team`) REFERENCES `TEAM` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_SCORE_2` FOREIGN KEY (`their_team`) REFERENCES `TEAM` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
