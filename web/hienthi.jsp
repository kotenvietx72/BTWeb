<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <title>Thông tin Sinh viên</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #1e3c72, #2a5298);
            color: #f0f4f8;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 900px;
            margin: 50px auto;
            background: #12263f;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 0 20px rgba(0,0,0,0.5);
        }
        h1 {
            text-align: center;
            color: #4fc3f7;
            margin-bottom: 30px;
            font-weight: 700;
            letter-spacing: 2px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            background: #1b2a47;
            color: #e1eaff;
            box-shadow: 0 0 10px rgba(0,0,0,0.3);
            border-radius: 8px;
            overflow: hidden;
        }
        th, td {
            padding: 12px 18px;
            border-bottom: 1px solid #2c3e70;
            text-align: center;
        }
        th {
            background: #2979ff;
            font-size: 1.1em;
            letter-spacing: 1px;
        }
        tr:hover {
            background: #2e4ca7;
            cursor: default;
        }
        .btn {
            padding: 6px 12px;
            border: none;
            border-radius: 6px;
            color: white;
            font-weight: 600;
            cursor: pointer;
            transition: background-color 0.3s ease;
            font-size: 0.9em;
            user-select: none;
        }
        .btn-edit {
            background-color: #4caf50;
        }
        .btn-edit:hover {
            background-color: #3a8b37;
        }
        .btn-delete {
            background-color: #f44336;
        }
        .btn-delete:hover {
            background-color: #ba3124;
        }
    </style>
</head>    
<body>
    <div class="container">
        <h1>THÔNG TIN SINH VIÊN</h1>

        <table>
            <thead>
                <tr>
                    <th>Mã sinh viên</th>
                    <th>Họ tên</th>
                    <th>Điểm</th>
                    <th>Giới tính</th>
                    <th>Sửa</th>
                    <th>Xóa</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="sv" items="${DanhSachSinhVien}">
                    <tr>
                        <td><c:out value="${sv.maSV}"/></td>
                        <td><c:out value="${sv.hoTen}"/></td>
                        <td><c:out value="${sv.diem}"/></td>
                        <td><c:out value="${sv.gioiTinh}"/></td>
                        <td>
                            <form action="SuaSV" method="get" style="margin:0;">
                                <input type="hidden" name="maSV" value="${sv.maSV}"/>
                                <input type="hidden" name="hoTen" value="${sv.hoTen}"/>
                                <input type="hidden" name="diem" value="${sv.diem}"/>
                                <input type="hidden" name="gioiTinh" value="${sv.gioiTinh}"/>
                                <button type="submit" class="btn btn-edit">Sửa</button>
                            </form>
                        </td>
                        <td>
                            <form action="xoaSV" method="get" style="margin:0;">
                                <input type="hidden" name="maSV" value="${sv.maSV}"/>
                                <button type="submit" class="btn btn-delete">Xóa</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                <c:if test="${empty DanhSachSinhVien}">
                    <tr>
                        <td colspan="5" style="color: #f44336; font-weight: bold;">Chưa có sinh viên nào trong danh sách!</td>
                    </tr>
                </c:if>
            </tbody>
        </table>
    </div>
    <h2 style="text-align:center; color:#4fc3f7; margin-top:40px;">Thêm Sinh Viên Mới</h2>
    <form action="QLSV" method="post" style="margin-top: 20px;">
        <table>
            <tr>
                <th>Mã sinh viên</th>
                <th>Họ tên</th>
                <th>Điểm</th>
                <th>Giới tính</th>
                <th>Thêm</th>
            </tr>
            <tr>
                <td><input type="text" name="maSV" required style="width: 90%; padding: 8px; border-radius: 5px; border: none;"></td>
                <td><input type="text" name="hoTen" required style="width: 90%; padding: 8px; border-radius: 5px; border: none;"></td>
                <td><input type="number" step="0.01" name="diem" required style="width: 90%; padding: 8px; border-radius: 5px; border: none;"></td>
                <td>
                    <select name="gioiTinh" style="width: 90%; padding: 8px; border-radius: 5px; border: none;">
                        <option value="Nam">Nam</option>
                        <option value="Nữ">Nữ</option>
                        <option value="Khác">Khác</option>
                    </select>
                </td>
                <td><button type="submit" class="btn btn-edit">Thêm</button></td>
            </tr>
        </table>
    </form>
    <h2 style="text-align:center; color:#4fc3f7; margin-top:40px;">Hiển Thị/ Tìm Kiếm Sinh Viên</h2>

    <div style="display: flex; justify-content: space-between; align-items: center; margin: 30px auto; max-width: 900px; flex-wrap: wrap;">

        <!-- Form hiển thị tất cả sinh viên bên trái -->
        <form action="QLSV" method="get">
            <button type="submit" class="btn btn-edit" 
                    style="background-color: #ff9800; padding: 14px 28px; font-size: 1.1em; border-radius: 8px;">
                Hiển thị tất cả
            </button>
        </form>

        <!-- Form tìm kiếm sinh viên bên phải -->
        <form action="TimSV" method="get" style="display: flex; gap: 10px; align-items: center;">
            <input type="text" name="maSV" placeholder="Nhập mã sinh viên cần tìm:" required 
                   style="padding: 12px; width: 300px; border-radius: 6px; border: none;">
            <button type="submit" class="btn btn-edit" 
                    style="background-color: #4caf50; font-size: 1em; padding: 12px 20px;">
                Tìm
            </button>
        </form>

    </div>

</body>
</html>
