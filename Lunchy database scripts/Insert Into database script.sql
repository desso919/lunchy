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
INSERT INTO `lunchy_db`.`orders` (`user_id`, `menu_id`,`meal_id`) VALUES (3 , 1, 2);
INSERT INTO `lunchy_db`.`orders` (`user_id`, `menu_id`,`meal_id`) VALUES (2 , 2, 1);
