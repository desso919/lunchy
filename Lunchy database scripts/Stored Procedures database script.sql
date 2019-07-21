
-- #######################################################################
-- ##                                                                   ##
-- ##                                                                   ##
-- ##                    Lunchy Database - Stored Procedures            ##
-- ##                                                                   ##
-- ##                                                                   ##
-- #######################################################################


-- STORED PROCEDURE - add_new_user - for adding new user 
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_new_user`
(
IN username_in VARCHAR(200),
IN first_name_in VARCHAR(100),
IN last_name_in VARCHAR(100),
IN password_in VARCHAR(200),
IN account_type_id_in INT,
OUT result_message VARCHAR(200)
)
BEGIN

 DECLARE is_Valid_Account_Type INT;
 
 SET is_Valid_Account_Type = (SELECT count(*) FROM account_types where account_type_id = account_type_id_in);
 
 IF (is_Valid_Account_Type > 0) THEN
  INSERT INTO users(`username`, `first_name`,`last_name`,`password`, `account_type_id`) VALUES (username_in, first_name_in, last_name_in, password_in, account_type_id_in);
  SET result_message = 'USER WAS SUCCESSFULLY INSERTED';
 ELSE
  SET result_message = 'ERROR: USER WAS NOT INSERTED';
 END IF;

END


-- STORED PROCEDURE - add_new_order - for adding new order 
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_new_order`(
IN user_id_in INT,
IN menu_id_in INT, 
IN meal_id_in INT, 
IN order_status VARCHAR(100), 
IN is_oredred_for_office TINYINT(1), 
IN order_time DATETIME,
IN order_for_time DATETIME,
OUT result_message VARCHAR(200)
)
BEGIN

 DECLARE is_Valid_User INT;
 DECLARE is_Valid_Menu INT;
 DECLARE is_Valid_Meal INT;
 
 SET is_Valid_User = (SELECT count(*) FROM lunchy_db.users where user_id = user_id_in);
 SET is_Valid_Menu = (SELECT count(*) FROM lunchy_db.menus where menu_id = menu_id_in);
 SET is_Valid_Meal = (SELECT count(*) FROM lunchy_db.meals where meal_id = meal_id_in);
 
 IF (is_Valid_User > 0 && is_Valid_Menu > 0 && is_Valid_Meal > 0) THEN
  INSERT INTO orders (user_id, menu_id, meal_id, order_status, is_oredred_for_office, order_time, order_for_time) 
  VALUES (user_id_in, menu_id_in, meal_id_in, order_status, is_oredred_for_office, order_time, order_for_time);
  SET result_message = 'ORDER WAS SUCCESSFULLY INSERTED';
 ELSE
  SET result_message = 'ERROR: ORDER WAS NOT INSERTED';
 END IF;

END

-- STORED PROCEDURE - add_meal - for adding new meal
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_new_meal`(
IN meal_name_in VARCHAR(200),
IN menu_name_in VARCHAR(200),
IN description_in VARCHAR(600),
IN ingredients_in VARCHAR(600),
IN price_in DECIMAL(6,2),
OUT result_message VARCHAR(200)
)
this_procedure:BEGIN

 DECLARE var_menu_id INT;
 DECLARE var_new_meal_id INT;

 IF(price_in < 0) THEN
   SET result_message = 'ERROR: ENTER POSITIVE NUMBER FOR PRICE';
   LEAVE this_procedure;
 END IF;
 
 SELECT GET_LOCK('insert_meal_lock', 500);
 
 START TRANSACTION;
 SET autocommit = 0;

     -- Check if the menu name coming as "IN" parameter is valid
     IF((SELECT count(*) FROM menus where menu_name = menu_name_in) = 1) THEN  
        
        -- First insert new meal
		INSERT INTO meals (`meal_name`, `description`, `ingredients`, `price`) VALUES (meal_name_in, description_in, ingredients_in, price_in);  
        
        -- Get the id of the latest(just) inserted meal
		SELECT @var_new_meal_id := MAX(meal_id) from meals;
        
		IF(@var_new_meal_id > 0) THEN
          -- Fetch menu id
          SELECT @var_menu_id := menu_id FROM menus where menu_name = menu_name_in;
          
          -- Insert new meal in menu_meals table
		  INSERT INTO menu_meals (menu_id, meal_id) VALUES (@var_menu_id, @var_new_meal_id);
          
          -- Commit transaction
		  SET result_message = 'MEAL WAS SUCCESSFULLY INSERTED';
		  COMMIT;
		ELSE
		  -- New meal was not inserted, therefore we have to ROLLBACK
          SET result_message = 'ERROR:FAILED TO INSERT NEW MEAL';
		  ROLLBACK;
		END IF;
      ELSE   
       SET result_message = 'ERROR: ENTER VALID MENU NAME';
       ROLLBACK;
      END IF;
      
 DO RELEASE_LOCK('insert_meal_lock');
END


-- STORED PROCEDURE - delete_order - for deleting order
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_order`(
IN order_id_in INT,
OUT result_message VARCHAR(200))
BEGIN

 DECLARE is_Valid_Order INT;
 
 SET is_Valid_Order = (SELECT count(*) FROM orders where order_id = order_id_in);
 
  
 IF (is_Valid_Order > 0) THEN
  DELETE FROM orders WHERE order_id = order_id_in;
  SET result_message = 'ORDER WAS SUCCESSFULLY DELETED';
 ELSE
  SET result_message = 'ERROR: ORDER WAS NOT DELETED';
 END IF;
 
END