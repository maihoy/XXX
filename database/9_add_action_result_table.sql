CREATE TABLE `ACTION_RESULT` (
  `id` int(11) NOT NULL,
  `name` varchar(100) COLLATE utf8_bin NOT NULL,
  `code` varchar(100) COLLATE utf8_bin NOT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `action` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_new_table_1_idx` (`action`),
  CONSTRAINT `fk_new_table_1` FOREIGN KEY (`action`) REFERENCES `ACTION` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `VSAdb`.`ACTION_RESULT`(`id`, `name`, `code`, `status`, `action`)
VALUES  ('1', 'Serve Result', 'SERVE_RESULT', NULL, '1');
INSERT INTO `VSAdb`.`ACTION_RESULT`(`id`, `name`, `code`, `status`, `action`)
VALUES  ('2', 'Serve Result Kill', 'SERVE_RESULT_KILL', '1', '1');
INSERT INTO `VSAdb`.`ACTION_RESULT`(`id`, `name`, `code`, `status`, `action`)
VALUES  ('3', 'Serve Result Err', 'SERVE_RESULT_ERR', '0', '1');
INSERT INTO `VSAdb`.`ACTION_RESULT`(`id`, `name`, `code`, `status`, `action`)
VALUES  ('4', 'Reseption Result', 'RESEPTION_RESULT', NULL, '2');
INSERT INTO `VSAdb`.`ACTION_RESULT`(`id`, `name`, `code`, `status`, `action`)
VALUES  ('5', 'Reception Result Kill', 'RECEPTION_RESULT_KILL', '1', '2');
INSERT INTO `VSAdb`.`ACTION_RESULT`(`id`, `name`, `code`, `status`, `action`)
VALUES  ('6', 'Reception Result Err', 'RECEPTION_RESULT_ERR', '0', '2');
INSERT INTO `VSAdb`.`ACTION_RESULT`(`id`, `name`, `code`, `status`, `action`)
VALUES  ('7', 'Attack Result', 'ATTACK_RESULT', NULL, '3');
INSERT INTO `VSAdb`.`ACTION_RESULT`(`id`, `name`, `code`, `status`, `action`)
VALUES  ('8', 'Attack Result Kill', 'ATTACK_RESULT_KILL', '1', '3');
INSERT INTO `VSAdb`.`ACTION_RESULT`(`id`, `name`, `code`, `status`, `action`)
VALUES  ('9', 'Attack Result Err', 'ATTACK_RESULT_ERR', '0', '3');
INSERT INTO `VSAdb`.`ACTION_RESULT`(`id`, `name`, `code`, `status`, `action`)
VALUES  ('10', 'Block Result', 'BLOCK_RESULT', NULL, '4');
INSERT INTO `VSAdb`.`ACTION_RESULT`(`id`, `name`, `code`, `status`, `action`)
VALUES  ('11', 'Block Result Kill', 'BLOCK_RESULT_KILL', '1', '4');
INSERT INTO `VSAdb`.`ACTION_RESULT`(`id`, `name`, `code`, `status`, `action`)
VALUES  ('12', 'Block Result Err', 'BLOCK_RESULT_ERR', '0', '4');
INSERT INTO `VSAdb`.`ACTION_RESULT`(`id`, `name`, `code`, `status`, `action`)
VALUES  ('13', 'Pass Result', 'PASS_RESULT', NULL, '5');
INSERT INTO `VSAdb`.`ACTION_RESULT`(`id`, `name`, `code`, `status`, `action`)
VALUES  ('14', 'Pass Result Kill', 'PASS_RESULT_KILL', '1', '5');
INSERT INTO `VSAdb`.`ACTION_RESULT`(`id`, `name`, `code`, `status`, `action`)
VALUES  ('15', 'Pass Result Err', 'PASS_RESULT_ERR', '0', '5');
















