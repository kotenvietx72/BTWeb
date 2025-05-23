<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Sửa thông tin sinh viên</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f0f4f8;
        }
        .form-container {
            width: 500px;
            margin: 50px auto;
            background: #ffffff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.2);
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #0077cc;
        }
        label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
        }
        input[type="text"], input[type="number"] {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 6px;
        }
        .btn-submit {
            margin-top: 20px;
            width: 100%;
            background: #0077cc;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-weight: bold;
        }
        .btn-submit:hover {
            background: #005fa3;
        }
    </style>
    </head>
    <body>
        <div class="form-container">
        <h2>Sửa Thông Tin Sinh Viên</h2>
        <form action="SuaSV" method="post">
            <label>Họ tên:</label>
            <input type="text" name="maSV" value="${param.maSV}" readonly />
            
            <label>Họ tên:</label>
            <input type="text" name="hoTen" value="${param.hoTen}" required />

            <label>Điểm:</label>
            <input type="number" name="diem" step="0.1" value="${param.diem}" required />

            <label>Giới tính:</label>
            <input type="text" name="gioiTinh" value="${param.gioiTinh}" required />

            <button type="submit" class="btn-submit">Cập nhật</button>
        </form>
    </div>
    </body>
</html>
