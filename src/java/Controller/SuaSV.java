package Controller;

import Model.*;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class SuaSV extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String maSV = request.getParameter("maSV");
        String hoTen = request.getParameter("hoTen");
        float diem = Float.parseFloat(request.getParameter("diem"));
        String gioiTinh = request.getParameter("gioiTinh");
        
        request.setAttribute("hoTen", hoTen);
        request.setAttribute("diem", diem);
        request.setAttribute("gioiTinh", gioiTinh);
        
        request.getRequestDispatcher("sua.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        
        String maSV = request.getParameter("maSV");
        String hoTen = request.getParameter("hoTen");
        float diem = Float.parseFloat(request.getParameter("diem"));
        String gioiTinh = request.getParameter("gioiTinh");

        SinhVien sv = new SinhVien(maSV, hoTen, diem, gioiTinh);
        KN kn = new KN();
        kn.suaSV(sv, maSV);
        
        response.sendRedirect("QLSV");
    }

}
