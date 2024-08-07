CREATE SCHEMA `java-demo` DEFAULT CHARACTER SET utf8mb4 ;

CREATE TABLE `java-demo`.`product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `description` TEXT NULL,
  `create_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP  ON UPDATE CURRENT_TIMESTAMP,
  `delete_time` DATETIME NULL,
  PRIMARY KEY (`id`));


INSERT INTO `java-demo`.`product` (`name`) VALUES ('C1');
INSERT INTO `java-demo`.`product` (`name`) VALUES ('C2');
