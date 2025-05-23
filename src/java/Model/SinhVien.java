package Model;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

public class SinhVien {
    private String maSV;
    private String hoTen;
    private float diem;
    private String gioiTinh;

    public SinhVien(String maSV, String hoTen, float diem, String gioiTinh) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.diem = diem;
        this.gioiTinh = gioiTinh;
    }

    public SinhVien() {
    }
    
    public String getMaSV() {
        return maSV;
    }
    
    public void setMaSV(String maSV){
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    
    
}
