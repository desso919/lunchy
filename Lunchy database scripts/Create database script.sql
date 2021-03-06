
-- #######################################################################
-- ##                                                                   ##
-- ##                                                                   ##
-- ##                    Lunchy Database - Create table statements      ##
-- ##                                                                   ##
-- ##                                                                   ##
-- #######################################################################


-- CREATE DATABASE
CREATE SCHEMA `lunchy_db` ;


-- CREATE account_types TABLE
CREATE TABLE `lunchy_db`.`account_types` (
  `account_type_id` INT NOT NULL AUTO_INCREMENT,
  `account_type` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`account_type_id`));
  
  
-- CREATE users TABLE
  CREATE TABLE `lunchy_db`.`users` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(200) NOT NULL,
  `password` VARCHAR(200) NOT NULL,
  `account_type_id` INT NOT NULL,
  PRIMARY KEY (`user_id`),
  INDEX `users_account_type_id_fk_idx` (`account_type_id` ASC),
  CONSTRAINT `user_account_type_id_fk`
    FOREIGN KEY (`account_type_id`)
    REFERENCES `lunchy_db`.`account_types` (`account_type_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
	
-- ALTER users TABLE
	ALTER TABLE `lunchy_db`.`users` 
ADD COLUMN `first_name` VARCHAR(100) NOT NULL AFTER `account_type_id`,
ADD COLUMN `last_name` VARCHAR(100) NOT NULL AFTER `first_name`;


	
-- CREATE meals TABLE
	CREATE TABLE `lunchy_db`.`meals` (
  `meal_id` INT NOT NULL AUTO_INCREMENT,
  `meal_name` VARCHAR(200) NOT NULL,
  `description` VARCHAR(600) NOT NULL,
  `ingredients` VARCHAR(600) NOT NULL,
  PRIMARY KEY (`meal_id`));
  
-- ALTER meals TABLE 
  ALTER TABLE `lunchy_db`.`meals` 
ADD COLUMN `price` DECIMAL(6,2) NOT NULL AFTER `ingredients`;


-- CREATE menus TABLE
CREATE TABLE `lunchy_db`.`menus` (
  `menu_id` INT NOT NULL AUTO_INCREMENT,
  `menu_name` VARCHAR(200) NOT NULL,
  `meal_id` INT NOT NULL,
  PRIMARY KEY (`menu_id`),
  INDEX `menu_meal_id_fk_idx` (`meal_id` ASC),
  CONSTRAINT `menu_meal_id_fk`
    FOREIGN KEY (`meal_id`)
    REFERENCES `lunchy_db`.`meals` (`meal_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
	
-- ALTER menus TABLE 
	ALTER TABLE `lunchy_db`.`menus` 
DROP FOREIGN KEY `menu_meal_id_fk`;
ALTER TABLE `lunchy_db`.`menus` 
DROP COLUMN `meal_id`,
DROP INDEX `menu_meal_id_fk_idx` ;

	
-- CREATE menu_meals TABLE
	CREATE TABLE `lunchy_db`.`menu_meals` (
  `menu_meals_id` INT NOT NULL AUTO_INCREMENT,
  `menu_id` INT NOT NULL,
  `meal_id` INT NOT NULL,
  PRIMARY KEY (`menu_meals_id`),
  INDEX `menu_meals_menu_id_fk_idx` (`menu_id` ASC),
  INDEX `menu_meals_meal_id_fk_idx` (`meal_id` ASC),
  CONSTRAINT `menu_meals_menu_id_fk`
    FOREIGN KEY (`menu_id`)
    REFERENCES `lunchy_db`.`menus` (`menu_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `menu_meals_meal_id_fk`
    FOREIGN KEY (`meal_id`)
    REFERENCES `lunchy_db`.`meals` (`meal_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
	
-- CREATE orders TABLE
	CREATE TABLE `lunchy_db`.`orders` (
  `order_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `menu_id` INT NOT NULL,
  `meal_id` INT NOT NULL,
  PRIMARY KEY (`order_id`),
  INDEX `order_user_id_fk_idx` (`user_id` ASC),
  INDEX `order_menu_id_fk_idx` (`menu_id` ASC),
  INDEX `order_meal_id_fk_idx` (`meal_id` ASC),
  CONSTRAINT `order_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `lunchy_db`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `order_menu_id_fk`
    FOREIGN KEY (`menu_id`)
    REFERENCES `lunchy_db`.`menus` (`menu_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `order_meal_id_fk`
    FOREIGN KEY (`meal_id`)
    REFERENCES `lunchy_db`.`meals` (`meal_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
	
	
-- ALTER orders TABLE 
	ALTER TABLE `lunchy_db`.`orders` 
ADD COLUMN `order_status` VARCHAR(100) NOT NULL AFTER `meal_id`;

-- ALTER orders TABLE 
ALTER TABLE `lunchy_db`.`orders` 
ADD COLUMN `is_oredred_for_office` TINYINT(1) NOT NULL DEFAULT 0 AFTER `order_status`,
ADD COLUMN `order_time` DATETIME NOT NULL AFTER `is_oredred_for_office`,
ADD COLUMN `order_for_time` DATETIME NOT NULL AFTER `order_time`;


	



