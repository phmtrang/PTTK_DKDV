/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PhamTrang
 */
public class DichVuDaDangKy {
    private String ngaySuDung;
    private String yeuCauChiTiet;
    private String trangThai;
    private String IDDichVu;
    private String MSV;

    public DichVuDaDangKy(String ngaySuDung, String yeuCauChiTiet, String trangThai, String IDDichVu, String MSV) {
        this.ngaySuDung = ngaySuDung;
        this.yeuCauChiTiet = yeuCauChiTiet;
        this.trangThai = trangThai;
        this.IDDichVu = IDDichVu;
        this.MSV = MSV;
    }

    public String getMSV() {
        return MSV;
    }

    public String getIDDichVu() {
        return IDDichVu;
    }

    public String getNgaySuDung() {
        return ngaySuDung;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public String getYeuCauChiTiet() {
        return yeuCauChiTiet;
    }
    
    
}
