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

## 🎥 Video Demo Sản Phẩm

Mời thầy và các bạn xem video demo chi tiết về luồng hoạt động của hệ thống (Sinh viên tạo đơn mượn & Admin duyệt đơn tự động trừ kho) tại đường link YouTube dưới đây:

<p align="center">
  <a href="https://www.youtube.com/watch?v=qebByWE90ZM">
    <img src="https://img.shields.io/badge/YouTube-Xem_Video_Demo-FF0000?style=for-the-badge&logo=youtube&logoColor=white" alt="Xem Video Demo trên YouTube" title="Click để xem video demo">
  </a>
</p>

*(Lưu ý: Click trực tiếp vào nút YouTube màu đỏ ở trên để chuyển hướng tới video)*

## 📸 Giao diện màn hình (Screenshots)

| Trang Đăng Nhập | Trang Đăng Ký |
| :---: | :---: |
| <img src="https://github.com/user-attachments/assets/fce41dd4-a5a2-4256-a128-75df41ad8df6" width="400"> | <img src="https://github.com/user-attachments/assets/de04cb4a-e9a5-4aae-92b4-1549d1e05ebd" width="400"> |

| Giao Diện Trang Sinh Viên | Form mượn |
| :---: | :---: |
| <img src="https://github.com/user-attachments/assets/72f42651-3ad6-49de-8d99-8ca48250de33" width="400"> | <img src="https://github.com/user-attachments/assets/5979c13a-311c-48ea-8b30-3a5c3f0cf8fd" width="400"> |

| Quản Lý Phòng Máy | Duyệt form mượn |
| :---: | :---: |
| <img src="https://github.com/user-attachments/assets/e79ee2bf-b1da-4366-add0-42c819653079" width="400"> | <img src="https://github.com/user-attachments/assets/056e7743-833c-4722-be04-5bd6ec41c5d9" width="400"> |

| Quản Lý Thiết Bị | Quản Lý Sinh Viên |
| :---: | :---: |
| <img src="https://github.com/user-attachments/assets/4aa1475c-c638-42db-9891-66438a3a574e" width="400"> | <img src="https://github.com/user-attachments/assets/c1086199-6154-491b-908c-519a611196e0" width="400"> |

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

## 📂 Cấu trúc thư mục (Folder Structure)
```text
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
```
## 🚀 Hướng dẫn cài đặt & Chạy dự án (Local Setup)

Để chạy dự án trên máy tính cá nhân, vui lòng làm theo các bước sau:

**Bước 1: Clone dự án về máy**
```bash
git clone https://github.com/khoiblack/Du_An_CK_Web2Spring.git
```
Bước 2: Cài đặt Cơ sở dữ liệu (MySQL)

Mở XAMPP và khởi động dịch vụ MySQL.

Truy cập http://localhost/phpmyadmin và tạo một Database mới có tên là: lab_management_db.

Import file database_backup.sql (nằm trong thư mục database của dự án) vào cơ sở dữ liệu vừa tạo để có sẵn dữ liệu mẫu.

Bước 3: Cấu hình kết nối (application.properties)
Mở file src/main/resources/application.properties bằng Eclipse/IntelliJ và cập nhật thông tin đăng nhập MySQL của bạn (nếu có thay đổi mật khẩu):
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/lab_management_db
spring.datasource.username=root
spring.datasource.password=
```
Bước 4: Chạy ứng dụngMở dự án bằng Eclipse IDE (hoặc IntelliJ IDEA).Nhấn chuột phải vào project $\rightarrow$ Run As $\rightarrow$ Maven build để tải các thư viện cần thiết.Chạy class chính chứa hàm main @SpringBootApplication.Mở trình duyệt và truy cập hệ thống tại: http://localhost:8084/login (Thay đổi cổng port nếu cần thiết).


