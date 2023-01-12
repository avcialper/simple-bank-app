-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 12 Oca 2023, 12:29:55
-- Sunucu sürümü: 10.4.24-MariaDB
-- PHP Sürümü: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `bank`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `users`
--

CREATE TABLE `users` (
  `ibanNumber` int(11) NOT NULL,
  `accountNumber` int(11) NOT NULL,
  `idNumber` int(11) NOT NULL,
  `name` text CHARACTER SET utf32 COLLATE utf32_turkish_ci NOT NULL,
  `surname` text CHARACTER SET utf32 COLLATE utf32_turkish_ci NOT NULL,
  `tlBalance` double NOT NULL,
  `dolarBalance` double NOT NULL,
  `euroBalance` double NOT NULL,
  `password` int(11) NOT NULL,
  `email` text CHARACTER SET utf32 COLLATE utf32_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `users`
--

INSERT INTO `users` (`ibanNumber`, `accountNumber`, `idNumber`, `name`, `surname`, `tlBalance`, `dolarBalance`, `euroBalance`, `password`, `email`) VALUES
(9999, 999999, 99999999, 'admin', 'admin', 0, 0, 0, 999999, 'admin@gmail.com');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`idNumber`),
  ADD UNIQUE KEY `iban` (`ibanNumber`),
  ADD UNIQUE KEY `acountNumber` (`accountNumber`),
  ADD UNIQUE KEY `tcNumber` (`idNumber`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
