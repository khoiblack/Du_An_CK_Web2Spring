-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 02, 2026 lúc 12:40 PM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `lab_management_db`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `booking_requests`
--

CREATE TABLE `booking_requests` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `room_id` int(11) DEFAULT NULL,
  `equipment_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT 1,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `purpose` text NOT NULL,
  `status` varchar(20) DEFAULT 'PENDING'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `booking_requests`
--

INSERT INTO `booking_requests` (`id`, `user_id`, `room_id`, `equipment_id`, `quantity`, `start_time`, `end_time`, `purpose`, `status`) VALUES
(3, 3, 2, NULL, 0, '2026-06-04 09:00:00', '2026-06-04 11:00:00', 'Sinh hoạt câu lạc bộ Tin học', 'REJECTED'),
(6, 4, 2, 2, 1, '2026-06-07 02:40:00', '2026-06-17 02:39:00', 'dafdsg', 'REJECTED');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `equipment`
--

CREATE TABLE `equipment` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `category` varchar(50) NOT NULL,
  `total_quantity` int(11) NOT NULL,
  `available_quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `equipment`
--

INSERT INTO `equipment` (`id`, `name`, `category`, `total_quantity`, `available_quantity`) VALUES
(1, 'Bộ định tuyến Cisco Router 2911', 'Network', 10, 0),
(2, 'Thiết bị chuyển mạch Switch Aruba 24P', 'Network', 8, 8),
(3, 'Máy chiếu EPSON X41', 'Đồ dùng', 5, 3),
(4, 'Bộ kính thực tế ảo Oculus Quest 2', 'Linh kiện', 3, 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `lab_rooms`
--

CREATE TABLE `lab_rooms` (
  `id` int(11) NOT NULL,
  `room_name` varchar(50) NOT NULL,
  `capacity` int(11) NOT NULL,
  `status` varchar(50) DEFAULT 'AVAILABLE'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `lab_rooms`
--

INSERT INTO `lab_rooms` (`id`, `room_name`, `capacity`, `status`) VALUES
(1, 'Phòng Lab 101', 40, 'AVAILABLE'),
(2, 'Phòng Lab 102', 35, 'AVAILABLE'),
(3, 'Phòng Lab 201 (Chuyên đề AI)', 30, 'AVAILABLE');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `full_name` varchar(100) NOT NULL,
  `role` varchar(20) NOT NULL,
  `student_class` varchar(50) DEFAULT NULL,
  `student_id` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `full_name`, `role`, `student_class`, `student_id`) VALUES
(1, 'admin', 'admin123', 'Quản Trị Viên Khoa IT', 'ADMIN', NULL, NULL),
(3, 'sinhvien2', 'sv123', 'Nguyễn Quốc Khánh', 'STUDENT', NULL, NULL),
(4, 'dangkhoi123', '123456', 'Cái Trần Đăng Khôi', 'STUDENT', '65.CNTT-CLC', '65131508');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `booking_requests`
--
ALTER TABLE `booking_requests`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_booking_user` (`user_id`),
  ADD KEY `fk_booking_room` (`room_id`),
  ADD KEY `fk_booking_equipment` (`equipment_id`);

--
-- Chỉ mục cho bảng `equipment`
--
ALTER TABLE `equipment`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `lab_rooms`
--
ALTER TABLE `lab_rooms`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `room_name` (`room_name`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `booking_requests`
--
ALTER TABLE `booking_requests`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `equipment`
--
ALTER TABLE `equipment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `lab_rooms`
--
ALTER TABLE `lab_rooms`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `booking_requests`
--
ALTER TABLE `booking_requests`
  ADD CONSTRAINT `fk_booking_equipment` FOREIGN KEY (`equipment_id`) REFERENCES `equipment` (`id`) ON DELETE SET NULL,
  ADD CONSTRAINT `fk_booking_room` FOREIGN KEY (`room_id`) REFERENCES `lab_rooms` (`id`) ON DELETE SET NULL,
  ADD CONSTRAINT `fk_booking_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
