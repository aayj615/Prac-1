-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- 主机： db
-- 生成日期： 2023-02-21 02:44:20
-- 服务器版本： 10.5.17-MariaDB-1:10.5.17+maria~ubu2004
-- PHP 版本： 8.0.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 数据库： `test1`
--

-- --------------------------------------------------------

--
-- 表的结构 `singers`
--

CREATE TABLE `singers` (
  `position` int(3) NOT NULL,
  `singer_name` varchar(15) NOT NULL,
  `singer_wages` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `singers`
--

INSERT INTO `singers` (`position`, `singer_name`, `singer_wages`) VALUES
(1, 'aweger', 2),
(2, 'aweger', 2);

--
-- 转储表的索引
--

--
-- 表的索引 `singers`
--
ALTER TABLE `singers`
  ADD PRIMARY KEY (`position`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `singers`
--
ALTER TABLE `singers`
  MODIFY `position` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
