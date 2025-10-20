package vn.hoctotlamhay.entity;
public class SinhVien {
    private String maSinhVien;
    private String ten;
    private Integer tuoi;
    private float diemTrungBinh;
    private int kyHoc;
    private String chuyenNganh;

    public String getMaSinhVien() {
        return maSinhVien;
    }
    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }
    public String getTen() {
        return ten;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }
    public Integer getTuoi() {
        return tuoi;
    }
    public void setTuoi(Integer tuoi) {
        this.tuoi = tuoi;
    }
    public float getDiemTrungBinh() {
        return diemTrungBinh;
    }
    public void setDiemTrungBinh(float diemTrungBinh) {
        this.diemTrungBinh = diemTrungBinh;
    }
    public Integer getKyHoc() {
        return kyHoc;
    }
    public void setKyHoc(Integer kyHoc) {
        this.kyHoc = kyHoc;
    }
    public String getChuyenNganh() {
        return chuyenNganh;
    }
    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }
    public SinhVien(String maSinhVien,
                    String ten,
                    Integer tuoi,
                    float diemTrungBinh,
                    Integer kyHoc,
                    String chuyenNganh) {
        this.maSinhVien = maSinhVien;
        this.ten = ten;
        this.tuoi = tuoi;
        this.diemTrungBinh = diemTrungBinh;
        this.kyHoc = kyHoc;
        this.chuyenNganh = chuyenNganh;
    }
}
