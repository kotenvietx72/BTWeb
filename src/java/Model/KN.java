package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KN {
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("mysql://root:eUTJpNDWRmdIVtTbLIKLBPvLgrbhLFYz@mysql.railway.internal:3306/railway", "root", "eUTJpNDWRmdIVtTbLIKLBPvLgrbhLFYz");
    }

    public ArrayList<SinhVien> DocDuLieu() throws ClassNotFoundException {
        String sql = "select * from sinhvien";
        ArrayList<SinhVien> dssv = new ArrayList<>();
        try {
            Connection c = getConnection();
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String maSV = rs.getString(1);
                String HoTen = rs.getString(2);
                float Diem = rs.getFloat(3);
                String GioiTinh = rs.getString(4);
                dssv.add(new SinhVien(maSV, HoTen, Diem, GioiTinh));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KN.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dssv;
    }
    
    public boolean themSV(SinhVien sv) {
        String sql = "INSERT INTO sinhvien VALUES (?, ?, ?, ?)";
        try {
            Connection c = getConnection();
            PreparedStatement stm = c.prepareStatement(sql);
            
            stm.setString(1, sv.getMaSV());
            stm.setString(2, sv.getHoTen());
            stm.setFloat(3, sv.getDiem());
            stm.setString(4, sv.getGioiTinh());
            
            return stm.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(KN.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KN.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean suaSV(SinhVien sv, String maSV) {
        String sql = "UPDATE sinhvien SET HoTen = ?, Diem = ?, GioiTinh = ? WHERE maSV = ?";
        
        try {
            Connection c = getConnection();
            PreparedStatement stm = c.prepareStatement(sql);
            
            stm.setString(1, sv.getHoTen());
            stm.setFloat(2, sv.getDiem());
            stm.setString(3, sv.getGioiTinh());
            stm.setString(4, maSV);
            
            return stm.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(KN.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KN.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean xoaSV(String maSV) {
        String sql = "DELETE FROM sinhvien WHERE maSV = ?";
        
        try {
            Connection c = getConnection();
            PreparedStatement stm = c.prepareStatement(sql);
            
            stm.setString(1, maSV);
            return stm.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(KN.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KN.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public SinhVien timSV(String maSV){
        String sql = "SELECT * FROM sinhvien WHERE maSV = ?";
        try {
            Connection c = getConnection();
            PreparedStatement stm = c.prepareStatement(sql);
            
            stm.setString(1, maSV);
            
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                return new SinhVien(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getString(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KN.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KN.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
