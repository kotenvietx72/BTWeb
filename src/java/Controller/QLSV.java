package Controller;

import Model.*;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QLSV extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<SinhVien> dssv = new ArrayList<>();
        try {
            dssv = (new KN()).DocDuLieu();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLSV.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("DanhSachSinhVien", dssv);
        response.setContentType("text/html;charset=UTF-8");
        
        RequestDispatcher r = request.getRequestDispatcher("./hienthi.jsp");
        r.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        
        String maSV = request.getParameter("maSV");
        String hoTen = request.getParameter("hoTen");
        float diem = Float.parseFloat(request.getParameter("diem"));
        String gioiTinh = request.getParameter("gioiTinh");
        
        KN kn = new KN();
        kn.themSV(new SinhVien(maSV, hoTen, diem, gioiTinh));
        
        response.sendRedirect("QLSV");
    }
}
