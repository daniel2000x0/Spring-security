INSERT INTO `category` (`id_category`, `description`) VALUES (NULL, 'Sport'), (NULL, 'Thecnology');
INSERT INTO `products` (`precio`, `created_at`, `id_category`, `id_product`, `stock`, `description`, `image_file_name`, `name`) VALUES ('2345', '2024-06-03 19:29:58.000000', '1', NULL, '234', ' Camiseta  Alemania 2006', 'image01', 'jersey alemana');
INSERT INTO `mode_payment` (`num_pago`, `other_details`, `name`) VALUES (NULL, ' asd a a', 'PAYPAL'), (NULL, 'presacac', 'DEPOSITO');
INSERT INTO `client` (`client_no_locked`, `birth date`, `id_client`, `phone`, `user_id_id`, `address`, `email`, `lastname`, `name`) VALUES (b'0000', '2024-06-25 12:03:38.000000', NULL, '3456789', '3', '35werer', 'anansdnas@gmail.com', 'asdas', 'asdasd');
INSERT INTO `factura` (`date`, `id_client`, `id_modepayment`, `num_factura`) VALUES ('2024-06-05 13:12:30.000000', '2', '2', NULL);
INSERT INTO `detallefactura` (`cantidad`, `precio`, `id_factura`, `num_detalle`) VALUES ('3', '2345', '2', NULL);