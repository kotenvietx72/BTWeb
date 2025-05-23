<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Xác nhận xóa</title>
    </head>
    <body>
        <h2 style="color: red;">Bạn có chắc muốn xóa sinh viên sau không?</h2>
        <ul>
            <li><strong>Mã SV:</strong> ${sv.maSV}</li>
            <li><strong>Họ tên:</strong> ${sv.hoTen}</li>
            <li><strong>Điểm:</strong> ${sv.diem}</li>
            <li><strong>Giới tính:</strong> ${sv.gioiTinh}</li>
        </ul>

        <form action="xoaSV" method="post">
            <input type="hidden" name="maSV" value="${sv.maSV}" />
            <button type="submit">Xác nhận</button>
            <a href="QLSV"><button type="button">Hủy</button></a>
        </form>
    </body>
</html>
