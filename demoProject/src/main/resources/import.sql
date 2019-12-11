use demo;

INSERT INTO `test_entity` (`id`, `nume`) VALUES (NULL, 'nume 1');
INSERT INTO `test_entity` (`id`, `nume`) VALUES (NULL, 'nume 2');
INSERT INTO `test_entity` (`id`, `nume`) VALUES (NULL, 'nume 3');
INSERT INTO `test_entity` (`id`, `nume`) VALUES (NULL, 'nume 4');
INSERT INTO `test_entity` (`id`, `nume`) VALUES (NULL, 'nume 5');
INSERT INTO `order_entity` (`id`, `cantitate`, `date_created`, `confirmation_number`) VALUES (NULL, 2, Now(), '7493872');
INSERT INTO `role_entity` (`id`, `name`) VALUES (NULL, 'USER');
INSERT INTO `category_entity` (`id`, `name`) VALUES (NULL, 'calculatoare');
INSERT INTO `produs_entity` (`id`, `name`, `price`, `description`) VALUES (NULL, 'lenovo', 2500, 'frumos calculator');

