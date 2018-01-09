-- #######################################################################
-- ##                                                                   ##
-- ##                                                                   ##
-- ##                    Lunchy Database - Insert statements            ##
-- ##                                                                   ##
-- ##                                                                   ##
-- #######################################################################


-- INSERT INTO account_types TABLE
INSERT INTO `lunchy_db`.`account_types` (`account_type`) VALUES ('administrator');
INSERT INTO `lunchy_db`.`account_types` (`account_type`) VALUES ('restaurant worker');
INSERT INTO `lunchy_db`.`account_types` (`account_type`) VALUES ('client');


-- INSERT INTO users TABLE
INSERT INTO `lunchy_db`.`users` (`username`, `password`, `account_type_id`) VALUES ('deso', 'deso', '1');
INSERT INTO `lunchy_db`.`users` (`username`, `password`, `account_type_id`) VALUES ('dimana', 'dimana', '2');
INSERT INTO `lunchy_db`.`users` (`username`, `password`, `account_type_id`) VALUES ('magi', 'magi', '3');

-- INSERT INTO meals TABLE
INSERT INTO `lunchy_db`.`meals` (`meal_name`, `description`, `ingredients`, `price`) VALUES ('potatoes', ' Belguim meal', 'potatoes and cheese', 6.50);
INSERT INTO `lunchy_db`.`meals` (`meal_name`, `description`, `ingredients`, `price`) VALUES ('Chicken', ' Bulgarian meal', 'chicken, potatoes and cheese', 9.50);

-- INSERT INTO menus TABLE
INSERT INTO `lunchy_db`.`menus` (`menu_name`, `meal_id`) VALUES ('Vegetarian Menu', 1);
INSERT INTO `lunchy_db`.`menus` (`menu_name`, `meal_id`) VALUES ('Meat Menu', 2);


-- INSERT INTO orders TABLE
INSERT INTO `lunchy_db`.`orders` (`user_id`, `menu_id`,`meal_id`,`order_status`) VALUES (3 , 1, 2, "COOKING");
INSERT INTO `lunchy_db`.`orders` (`user_id`, `menu_id`,`meal_id`,`order_status`) VALUES (2 , 2, 1, "READY");

-- UPDATE DATE IN orders TABLE
UPDATE `lunchy_db`.`orders` SET `order_time`='2017-01-19 12:14:07', `order_for_time`='2017-01-19 13:15:00' WHERE `order_id`='1';
UPDATE `lunchy_db`.`orders` SET `order_time`='2017-01-19 13:30:00', `order_for_time`='2017-01-19 14:30:00' WHERE `order_id`='2';
UPDATE `lunchy_db`.`orders` SET `is_oredred_for_office`='1' WHERE `order_id`='2';
