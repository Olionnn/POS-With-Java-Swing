-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 27, 2023 at 08:26 AM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pos`
--

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `order_id` int NOT NULL,
  `order_product_id` int NOT NULL,
  `order_qty` int NOT NULL,
  `order_user_id` int NOT NULL,
  `order_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `order_selesai` enum('1','0') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`order_id`, `order_product_id`, `order_qty`, `order_user_id`, `order_date`, `order_selesai`) VALUES
(1, 1, 5, 3, '2023-12-27 01:38:04', '1'),
(2, 2, 2, 3, '2023-12-27 01:38:04', '1'),
(3, 3, 1, 1, '2023-12-25 23:08:20', '1'),
(4, 1, 2, 3, '2023-12-27 03:55:56', '1'),
(5, 3, 29, 3, '2023-12-27 03:55:56', '1'),
(6, 2, 2, 3, '2023-12-27 03:58:52', '1'),
(7, 3, 1, 3, '2023-12-27 07:09:14', '1'),
(8, 3, 2, 3, '2023-12-27 07:09:14', '1'),
(9, 2, 2, 3, '2023-12-27 07:09:14', '1'),
(14, 1, 50, 3, '2023-12-27 07:22:27', '1'),
(15, 1, 50, 3, '2023-12-27 12:22:18', '1');

--
-- Triggers `orders`
--
DELIMITER $$
CREATE TRIGGER `StockTgr` AFTER INSERT ON `orders` FOR EACH ROW BEGIN
    DECLARE jmlBarang INT;

    SELECT `order_qty` INTO jmlBarang
    FROM `orders`
    WHERE `order_id` = NEW.order_id;

    UPDATE `product`
    SET `product_stock` = `product_stock` - jmlBarang
    WHERE `product_id` = NEW.order_product_id;

    END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `product_id` int NOT NULL,
  `product_name` varchar(25) NOT NULL,
  `product_desc` text,
  `product_harga` int NOT NULL,
  `product_stock` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`product_id`, `product_name`, `product_desc`, `product_harga`, `product_stock`) VALUES
(8, 'Minyak Goreng', 'Minyak kelapa pilihan dengan kualitas tinggi', 15000, 100),
(9, 'Sabun Mandi', 'Sabun mandi dengan wangi melati', 5000, 200),
(10, 'Beras', 'Beras premium dengan kualitas terbaik', 25000, 50),
(11, 'Mie Instan', 'Mie instan rasa ayam bawang', 3000, 150),
(12, 'Gula Pasir', 'Gula pasir halus dari tebu pilihan', 12000, 80),
(13, 'Susu Kental Manis', 'Susu kental manis dengan rasa lezat', 8000, 120),
(14, 'Shampoo', 'Shampoo anti-ketombe dengan ekstrak lidah buaya', 10000, 100),
(15, 'Kopi', 'Kopi bubuk dengan aroma yang khas', 18000, 60),
(16, 'Tissue', 'Tissue toilet tahan air', 7000, 180),
(17, 'Pasta Gigi', 'Pasta gigi dengan kandungan fluoride', 6000, 120),
(18, 'Indomilk', 'Susu kental manis Indomilk', 5000, 100),
(19, 'ABC Bubur Bayi', 'Bubur bayi rasa buah-buahan', 8000, 50),
(20, 'Teh Pucuk Harum', 'Minuman teh manis rasa jeruk', 3000, 200),
(21, 'Mie Sedap Goreng', 'Mie instan rasa ayam goreng', 2500, 150),
(22, 'Pepsodent', 'Pasta gigi Pepsodent', 7000, 120),
(23, 'Silverqueen', 'Cokelat rasa almond', 15000, 80),
(24, 'Dancow', 'Susu bubuk Dancow', 10000, 90),
(25, 'Frisian Flag', 'Susu kental manis Frisian Flag', 5500, 110),
(26, 'Torabika Cappuccino', 'Kopi instan rasa cappuccino', 6000, 180),
(27, 'Rinso', 'Sabun cuci Rinso', 12000, 70),
(28, 'ABC', 'Minuman ringan berkarbonat merk ABC', 4000, 120),
(29, 'Sarden ABC', 'Kaleng sarden merk ABC', 8000, 50),
(30, 'Kopi Kapal Api', 'Kopi bubuk merk Kapal Api', 10000, 80),
(31, 'Ultra Milk', 'Susu cair rasa cokelat merk Ultra Milk', 6000, 100),
(32, 'MamyPoko', 'Popok bayi merk MamyPoko', 15000, 40),
(33, 'Sprite', 'Minuman bersoda merk Sprite', 5000, 130),
(34, 'Top Coffee', 'Minuman kopi kaleng merk Top Coffee', 7000, 90),
(35, 'Dua Kelinci', 'Kacang panggang merk Dua Kelinci', 12000, 60),
(36, 'Garnier', 'Shampoo merk Garnier', 9000, 75),
(37, 'Tango Wafer', 'Wafer cokelat merk Tango', 3500, 110);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `user_password` varchar(255) NOT NULL,
  `user_email` text NOT NULL,
  `user_phone` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `user_name`, `user_password`, `user_email`, `user_phone`) VALUES
(1, 'Ardi', '121212', 'ardi@pos.com', '0000000'),
(2, 'John Doe', 'joejoe', 'joe@pos.com', '00000000'),
(3, 'admin', 'admin', 'admin@pos.com', '00000000'),
(4, 'AHIHIHI', 'password1', '<EMAIL>', '123-456-7890');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`order_id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`product_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `order_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `product_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
