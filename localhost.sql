-- phpMyAdmin SQL Dump
-- version 4.4.15.10
-- https://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Aug 02, 2017 at 10:33 AM
-- Server version: 5.5.55-log
-- PHP Version: 5.4.45

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `IMUCommunity`
--
CREATE DATABASE IF NOT EXISTS `IMUCommunity` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `IMUCommunity`;

-- --------------------------------------------------------

--
-- Table structure for table `Answer`
--

CREATE TABLE IF NOT EXISTS `Answer` (
  `ansid` int(11) NOT NULL,
  `aid` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `content` varchar(500) NOT NULL,
  `time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Ask`
--

CREATE TABLE IF NOT EXISTS `Ask` (
  `aid` int(11) NOT NULL,
  `title` varchar(50) NOT NULL,
  `detail` varchar(500) DEFAULT NULL,
  `uid` int(11) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Comments`
--

CREATE TABLE IF NOT EXISTS `Comments` (
  `cid` int(11) NOT NULL,
  `tid` int(11) NOT NULL,
  `content` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Likes`
--

CREATE TABLE IF NOT EXISTS `Likes` (
  `lid` int(11) NOT NULL,
  `tid` int(11) NOT NULL,
  `uid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Notification`
--

CREATE TABLE IF NOT EXISTS `Notification` (
  `nid` int(11) NOT NULL,
  `oid` int(11) NOT NULL,
  `content` varchar(500) NOT NULL,
  `stick` tinyint(1) NOT NULL DEFAULT '0',
  `important` tinyint(1) NOT NULL DEFAULT '0',
  `time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Official_account`
--

CREATE TABLE IF NOT EXISTS `Official_account` (
  `oid` int(11) NOT NULL,
  `name` varchar(25) NOT NULL,
  `type` int(11) NOT NULL COMMENT '0 组织\n1 社团\n2 学校\n3 学院\n4 班级',
  `token` varchar(36) NOT NULL,
  `description` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Tucao`
--

CREATE TABLE IF NOT EXISTS `Tucao` (
  `tid` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `content` varchar(1024) NOT NULL,
  `time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `like_num` int(11) NOT NULL DEFAULT '0',
  `comment_num` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `User`
--

CREATE TABLE IF NOT EXISTS `User` (
  `uid` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `password` varchar(32) NOT NULL,
  `gender` int(11) NOT NULL DEFAULT '0',
  `sid` varchar(10) DEFAULT NULL,
  `spassword` varchar(32) DEFAULT NULL,
  `token` varchar(36) NOT NULL,
  `avatar` varchar(40) DEFAULT 'default.png'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Answer`
--
ALTER TABLE `Answer`
  ADD PRIMARY KEY (`ansid`);

--
-- Indexes for table `Ask`
--
ALTER TABLE `Ask`
  ADD PRIMARY KEY (`aid`);

--
-- Indexes for table `Comments`
--
ALTER TABLE `Comments`
  ADD PRIMARY KEY (`cid`);

--
-- Indexes for table `Likes`
--
ALTER TABLE `Likes`
  ADD PRIMARY KEY (`lid`),
  ADD UNIQUE KEY `Like_history_uid_tid_pk` (`uid`,`tid`);

--
-- Indexes for table `Notification`
--
ALTER TABLE `Notification`
  ADD PRIMARY KEY (`nid`);

--
-- Indexes for table `Official_account`
--
ALTER TABLE `Official_account`
  ADD PRIMARY KEY (`oid`),
  ADD UNIQUE KEY `Official_account_name_uindex` (`name`),
  ADD UNIQUE KEY `Official_account_token_uindex` (`token`);

--
-- Indexes for table `Tucao`
--
ALTER TABLE `Tucao`
  ADD PRIMARY KEY (`tid`);

--
-- Indexes for table `User`
--
ALTER TABLE `User`
  ADD PRIMARY KEY (`uid`),
  ADD UNIQUE KEY `user_token_uindex` (`token`),
  ADD UNIQUE KEY `User_name_uindex` (`name`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Answer`
--
ALTER TABLE `Answer`
  MODIFY `ansid` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Ask`
--
ALTER TABLE `Ask`
  MODIFY `aid` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Comments`
--
ALTER TABLE `Comments`
  MODIFY `cid` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Likes`
--
ALTER TABLE `Likes`
  MODIFY `lid` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Notification`
--
ALTER TABLE `Notification`
  MODIFY `nid` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Official_account`
--
ALTER TABLE `Official_account`
  MODIFY `oid` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Tucao`
--
ALTER TABLE `Tucao`
  MODIFY `tid` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `User`
--
ALTER TABLE `User`
  MODIFY `uid` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
