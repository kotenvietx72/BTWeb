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
public class xoaSV extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        
        String maSV = request.getParameter("maSV");
        SinhVien sv = new KN().timSV(maSV);
        request.setAttribute("sv", sv);
        
        request.getRequestDispatcher("xoa.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String maSV = request.getParameter("maSV");
        new KN().xoaSV(maSV);
        
        response.sendRedirect("QLSV");
    }
    
}
