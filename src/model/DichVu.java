/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PhamTrang
 */
public class DichVu {
    private String ID;
    private String ten;
    private String loai;
    private String donGia;

    public DichVu() {
    }

    public DichVu(String ID, String ten) {
        this.ID = ID;
        this.ten = ten;
    }

    public DichVu(String ID, String ten, String loai, String donGia) {
        this.ID = ID;
        this.ten = ten;
        this.loai = loai;
        this.donGia = donGia;
    }
    
    public String getTen() {
        return ten;
    }

    public String getID() {
        return ID;
    }

    public String getDonGia() {
        return donGia;
    }

    public String getLoai() {
        return loai;
    }
    
    
            
}
