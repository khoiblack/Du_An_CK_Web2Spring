<h1 align="center">🖥️ IT Lab Equipment Management System</h1>

<p align="center">
  <img src="https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=spring&logoColor=white" alt="Spring Boot">
  <img src="https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java">
  <img src="https://img.shields.io/badge/MySQL-8.0-4479A1?style=for-the-badge&logo=mysql&logoColor=white" alt="MySQL">
  <img src="https://img.shields.io/badge/Bootstrap-5-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white" alt="Bootstrap">
</p>

<p align="center">
  <i>Hệ thống Quản lý và Đăng ký mượn phòng máy, thiết bị IT dành cho Khoa Công nghệ Thông tin.</i>
</p>

---

## 📖 Giới thiệu dự án
Dự án **IT Lab Equipment Management** được xây dựng nhằm số hóa quy trình đăng ký mượn trả phòng máy và thiết bị phần cứng của sinh viên. Hệ thống giúp loại bỏ hoàn toàn quy trình giấy tờ thủ công, tự động hóa việc tính toán số lượng tồn kho và ngăn chặn tình trạng trùng lịch (conflict) khi đăng ký phòng máy.

## ✨ Tính năng nổi bật

### 👨‍💻 Dành cho Quản trị viên (Admin)
* **Quản lý Tài nguyên:** Thêm, sửa, xóa thông tin phòng máy và thiết bị (CRUD).
* **Quét tìm kiếm tức thời (Real-time Search):** Lọc dữ liệu nhanh chóng bằng JavaScript không cần tải lại trang.
* **Phê duyệt đơn đăng ký:** Tự động trừ số lượng thiết bị trong kho khi duyệt đơn (Approve) và hoàn lại khi từ chối (Reject).
* **Quản lý Sinh viên:** Khóa tài khoản, đặt lại mật khẩu mặc định (Reset Password).
* **Lịch sử hoạt động:** Tải ngầm dữ liệu lịch sử mượn trả của từng sinh viên qua Fetch API (AJAX).

### 🎓 Dành cho Sinh viên (Student)
* **Đăng ký / Đăng nhập:** Hệ thống tự động phân quyền truy cập.
* **Theo dõi tài nguyên rảnh:** Xem danh sách phòng máy và thiết bị khả dụng theo thời gian thực.
* **Tạo phiếu mượn trực tuyến:** Hệ thống tự động chặn các đơn mượn vượt quá số lượng tồn kho hoặc trùng lặp thời gian sử dụng phòng máy.

## 📸 Giao diện màn hình (Screenshots)

| Trang Đăng Nhập & Đăng Ký | Dashboard Quản Trị (Admin) |
| :---: | :---: |
| <img src="https://via.placeholder.com/600x400.png?text=Hinh+Anh+Login" width="400"> | <img src="https://via.placeholder.com/600x400.png?text=Hinh+Anh+Admin+Dashboard" width="400"> |

| Tìm Kiếm Tức Thời (Real-time) | Lịch Sử Mượn (Fetch API) |
| :---: | :---: |
| <img src="https://via.placeholder.com/600x400.png?text=Hinh+Anh+Search" width="400"> | <img src="https://via.placeholder.com/600x400.png?text=Hinh+Anh+History+Modal" width="400"> |

*(Lưu ý: Thay thế các link `https://via.placeholder.com/...` bằng link ảnh thật của bạn)*

## 🛠️ Công nghệ sử dụng

**Backend:**
* Java 21
* Spring Boot (Web, Data JPA)
* Hibernate (ORM)

**Frontend:**
* Thymeleaf (Template Engine)
* HTML5, CSS3, Vanilla JavaScript
* Bootstrap 5, FontAwesome 6

**Database & Tools:**
* MySQL
* Eclipse IDE / Maven

src/main/java/ntu/khoi/
 ├── config/            # Cấu hình hệ thống (Interceptors, Security)
 ├── controller/        # Xử lý các HTTP Request (Admin, Student, Login)
 ├── entity/            # Các lớp ánh xạ Cơ sở dữ liệu (User, Equipment, Room...)
 ├── repository/        # Giao tiếp với Database (Spring Data JPA)
 └── service/           # Xử lý logic nghiệp vụ (Business Logic)
 
src/main/resources/
 ├── static/            # Chứa các file CSS, JS tĩnh
 ├── templates/         # Giao diện HTML (Thymeleaf, Fragments)
 └── application.properties # Cấu hình môi trường Spring Boot
