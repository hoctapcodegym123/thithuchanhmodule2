package Models;

import java.io.Serializable;

public class Sanpham implements Serializable {
    private int idSanPham;
    private String tenSanPham;
    private float giaSanPham;
    private int soLuongSanPham;
    private String moTaSanPham;

    public Sanpham(int idSanPham, String tenSanPham, float giaSanPham, int soLuongSanPham, String moTaSanPham) {
        this.idSanPham = idSanPham;
        this.tenSanPham = tenSanPham;
        this.giaSanPham = giaSanPham;
        this.soLuongSanPham = soLuongSanPham;
        this.moTaSanPham = moTaSanPham;
    }

    public Sanpham() {
    }

    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public float getGiaSanPham() {
        return giaSanPham;
    }

    public void setGiaSanPham(float giaSanPham) {
        this.giaSanPham = giaSanPham;
    }

    public int getSoLuongSanPham() {
        return soLuongSanPham;
    }

    public void setSoLuongSanPham(int soLuongSanPham) {
        this.soLuongSanPham = soLuongSanPham;
    }

    public String getMoTaSanPham() {
        return moTaSanPham;
    }

    public void setMoTaSanPham(String moTaSanPham) {
        this.moTaSanPham = moTaSanPham;
    }

    @Override
    public String toString() {
        return "Sanpham :" +
                "idSanPham=" + idSanPham +
                ", tenSanPham='" + tenSanPham + '\'' +
                ", giaSanPham=" + giaSanPham +
                ", soLuongSanPham=" + soLuongSanPham +
                ", moTaSanPham='" + moTaSanPham + '\'';
    }

    public String write() {
        return idSanPham + "," + tenSanPham + "," + giaSanPham + "," + soLuongSanPham + "," + moTaSanPham;
    }
}
