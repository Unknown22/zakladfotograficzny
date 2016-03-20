-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Czas generowania: 20 Mar 2016, 14:50
-- Wersja serwera: 10.1.8-MariaDB
-- Wersja PHP: 5.6.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `zakladfotograficzny`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `account_type`
--

CREATE TABLE `account_type` (
  `id_account_type` int(11) NOT NULL,
  `type_of_account` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `account_type`
--

INSERT INTO `account_type` (`id_account_type`, `type_of_account`) VALUES
(1, 'admin');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `address`
--

CREATE TABLE `address` (
  `city` varchar(45) DEFAULT NULL,
  `postcode` varchar(45) DEFAULT NULL,
  `street` varchar(45) DEFAULT NULL,
  `street_number` varchar(45) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `department`
--

CREATE TABLE `department` (
  `id_department` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `postcode` varchar(45) NOT NULL,
  `street` varchar(45) NOT NULL,
  `street_number` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `department`
--

INSERT INTO `department` (`id_department`, `name`, `city`, `postcode`, `street`, `street_number`, `phone`, `email`) VALUES
(0, 'Siedziba Glowna', 'Krakow', '31-001', 'Chmieleniec', '2B/1', '111222333', 'admin@zakladfotograficzny.pl');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `order`
--

CREATE TABLE `order` (
  `id_order` int(11) NOT NULL,
  `id_status` int(11) NOT NULL,
  `creation_time` date NOT NULL,
  `last_edit_time` date DEFAULT NULL,
  `adding_information` varchar(100) DEFAULT NULL,
  `id_payment` int(11) NOT NULL,
  `id_shippment` int(11) NOT NULL,
  `id_department` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `order_status`
--

CREATE TABLE `order_status` (
  `id_status` int(11) NOT NULL,
  `type_of_status` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `payment`
--

CREATE TABLE `payment` (
  `id_payment` int(11) NOT NULL,
  `type_of_payment` varchar(45) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `photo`
--

CREATE TABLE `photo` (
  `id_photo` int(11) NOT NULL,
  `id_order` int(11) NOT NULL,
  `file_name` varchar(45) NOT NULL,
  `id_service` int(11) NOT NULL,
  `file_type` varchar(45) NOT NULL,
  `file_size` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `photo_format`
--

CREATE TABLE `photo_format` (
  `id_photo_format` int(11) NOT NULL,
  `format` varchar(45) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `photo_service`
--

CREATE TABLE `photo_service` (
  `id_service` int(11) NOT NULL,
  `copies` int(11) NOT NULL,
  `id_photo_format` int(11) NOT NULL,
  `id_sealing` int(11) NOT NULL,
  `id_retouch` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `retouch`
--

CREATE TABLE `retouch` (
  `id_retouch` int(11) NOT NULL,
  `type_of_retouch` varchar(45) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `sealing`
--

CREATE TABLE `sealing` (
  `id_sealing` int(11) NOT NULL,
  `type_of_sealing` varchar(45) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `shipment`
--

CREATE TABLE `shipment` (
  `id_shipment` int(11) NOT NULL,
  `type_of_shipment` varchar(45) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `id_account_type` int(11) DEFAULT NULL,
  `id_department` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `user`
--

INSERT INTO `user` (`id_user`, `firstname`, `lastname`, `email`, `login`, `password`, `id_account_type`, `id_department`) VALUES
(0, 'admin', 'admin', 'admin@zakladfotograficzny.pl', 'admin', 'admin', 1, 0);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `account_type`
--
ALTER TABLE `account_type`
  ADD PRIMARY KEY (`id_account_type`),
  ADD UNIQUE KEY `id_account_type_UNIQUE` (`id_account_type`);

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD KEY `id_user_idx` (`id_user`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`id_department`);

--
-- Indexes for table `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`id_order`),
  ADD KEY `id_payment_idx` (`id_payment`),
  ADD KEY `id_shipment_idx` (`id_shippment`),
  ADD KEY `id_status_idx` (`id_status`),
  ADD KEY `id_department_idx` (`id_department`);

--
-- Indexes for table `order_status`
--
ALTER TABLE `order_status`
  ADD PRIMARY KEY (`id_status`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`id_payment`);

--
-- Indexes for table `photo`
--
ALTER TABLE `photo`
  ADD PRIMARY KEY (`id_photo`),
  ADD KEY `id_service_idx` (`id_service`),
  ADD KEY `id_order_idx` (`id_order`);

--
-- Indexes for table `photo_format`
--
ALTER TABLE `photo_format`
  ADD PRIMARY KEY (`id_photo_format`);

--
-- Indexes for table `photo_service`
--
ALTER TABLE `photo_service`
  ADD PRIMARY KEY (`id_service`),
  ADD KEY `id_photo_format_idx` (`id_photo_format`),
  ADD KEY `id_sealing_idx` (`id_sealing`),
  ADD KEY `id_retouch_idx` (`id_retouch`);

--
-- Indexes for table `retouch`
--
ALTER TABLE `retouch`
  ADD PRIMARY KEY (`id_retouch`);

--
-- Indexes for table `sealing`
--
ALTER TABLE `sealing`
  ADD PRIMARY KEY (`id_sealing`);

--
-- Indexes for table `shipment`
--
ALTER TABLE `shipment`
  ADD PRIMARY KEY (`id_shipment`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `id_user_UNIQUE` (`id_user`),
  ADD KEY `id_account_type_idx` (`id_account_type`),
  ADD KEY `id_department_idx` (`id_department`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `order`
--
ALTER TABLE `order`
  MODIFY `id_order` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `order_status`
--
ALTER TABLE `order_status`
  MODIFY `id_status` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `payment`
--
ALTER TABLE `payment`
  MODIFY `id_payment` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `photo`
--
ALTER TABLE `photo`
  MODIFY `id_photo` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `photo_service`
--
ALTER TABLE `photo_service`
  MODIFY `id_service` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `retouch`
--
ALTER TABLE `retouch`
  MODIFY `id_retouch` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `sealing`
--
ALTER TABLE `sealing`
  MODIFY `id_sealing` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `shipment`
--
ALTER TABLE `shipment`
  MODIFY `id_shipment` int(11) NOT NULL AUTO_INCREMENT;
--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `address`
--
ALTER TABLE `address`
  ADD CONSTRAINT `id_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ograniczenia dla tabeli `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `id_department` FOREIGN KEY (`id_department`) REFERENCES `department` (`id_department`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `id_payment` FOREIGN KEY (`id_payment`) REFERENCES `payment` (`id_payment`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `id_shipment` FOREIGN KEY (`id_shippment`) REFERENCES `shipment` (`id_shipment`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `id_status` FOREIGN KEY (`id_status`) REFERENCES `order_status` (`id_status`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ograniczenia dla tabeli `photo`
--
ALTER TABLE `photo`
  ADD CONSTRAINT `id_order` FOREIGN KEY (`id_order`) REFERENCES `order` (`id_order`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `id_service` FOREIGN KEY (`id_service`) REFERENCES `photo_service` (`id_service`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ograniczenia dla tabeli `photo_service`
--
ALTER TABLE `photo_service`
  ADD CONSTRAINT `id_photo_format` FOREIGN KEY (`id_photo_format`) REFERENCES `photo_format` (`id_photo_format`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `id_retouch` FOREIGN KEY (`id_retouch`) REFERENCES `retouch` (`id_retouch`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `id_sealing` FOREIGN KEY (`id_sealing`) REFERENCES `sealing` (`id_sealing`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ograniczenia dla tabeli `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `id_account_type` FOREIGN KEY (`id_account_type`) REFERENCES `account_type` (`id_account_type`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `id_department2` FOREIGN KEY (`id_department`) REFERENCES `department` (`id_department`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
