INSERT INTO `Eclothe`.`item_type_cat`(`name`)
VALUES ('clothe'),('accesories'),( 'shoes'),('cosmetics');

INSERT INTO `Eclothe`.`item_category` (`item_type_id`, `sub_cat_level`, `cat_name`, `sub_cat_name`)
VALUES
(1, 1,       'category',  	'sport'),
(1, 2,       'subcategory',	'running'),
(1, 3,       'brand',	  	'nike'),
(1, 4,       'sub_brand', 	'nike+'),
(1, -999999, 'item',	  	'Nike Revolution 4'),

(1, 1,       'category',  	'sport'),
(1, 2,       'subcategory',	'running'),
(1, 3,       'brand',	  	'nike'),
(1, 4,       'sub_brand', 	'Flex Experience'),
(1, -999999, 'item',	  	'Nike - Flex Experience RN 9 - CD0225004'),

(1, 1,       'category',  	'sport'),
(1, 2,       'subcategory',	'running'),
(1, 3,       'brand',	  	'puma'),
(1, 4,       'sub_brand', 	'Fracture'),
(1, -999999, 'item',	  	'PUMA Tazon 6 Fracture FM'),

(1, 1,       'category',  	'sport'),
(1, 2,       'subcategory',	'running'),
(1, 3,       'brand',	  	'puma'),
(1, 4,       'sub_brand', 	'PUMA SF Drift'),
(1, -999999, 'item',	  	'PUMA SF Drift Cat 5 Ultra II');


