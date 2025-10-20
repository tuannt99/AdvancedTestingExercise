package vn.hoctotlamhay.service;

import vn.hoctotlamhay.entity.SinhVien;

public class SinhVienService {
    //Stub dữ liệu sinh viên
    protected SinhVien sinhVien = new SinhVien(
            "SV0001",
            "Nguyễn Tường Minh",
            20,
            8.5F,
            3,
            "Công nghệ thông tin"
            );
    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }
    public SinhVien getSinhVien() {
        return sinhVien;
    }
    public void updateSinhVien(SinhVien sinhVienMoi) {
        if (sinhVienMoi == null) {
            throw new IllegalArgumentException("Đối tượng sinh viên mới không được null.");
        }
        if (sinhVienMoi.getMaSinhVien() == null || sinhVienMoi.getMaSinhVien().isEmpty()
                || sinhVienMoi.getTen() == null || sinhVienMoi.getTen().isEmpty()
                || sinhVienMoi.getChuyenNganh() == null || sinhVienMoi.getChuyenNganh().isEmpty()) {
            throw new IllegalArgumentException("Các thuộc tính không được để trống.");
        }
        if (sinhVienMoi.getDiemTrungBinh() < 0 || sinhVienMoi.getDiemTrungBinh() > 10) {
            throw new IllegalArgumentException("Điểm trung bình phải trong khoảng từ 0 đến 10.");
        }
        sinhVien.setMaSinhVien(sinhVienMoi.getMaSinhVien());
        sinhVien.setTen(sinhVienMoi.getTen());
        sinhVien.setTuoi(sinhVienMoi.getTuoi());
        sinhVien.setDiemTrungBinh(sinhVienMoi.getDiemTrungBinh());
        sinhVien.setKyHoc(sinhVienMoi.getKyHoc());
        sinhVien.setChuyenNganh(sinhVienMoi.getChuyenNganh());
    }
}