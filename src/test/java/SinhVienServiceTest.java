import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import vn.hoctotlamhay.entity.SinhVien;
import vn.hoctotlamhay.service.SinhVienService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SinhVienServiceTest {
    protected static SinhVien sinhVien;
    private static SinhVienService service;
    @BeforeAll
    static void setUp() {
        service = new SinhVienService();
    }
    //Điểm hợp lệ
    @Test
    void testUpdateDiem() {
        //Stub dữ liệu sinh viên
        sinhVien = new SinhVien(
                "SV0001",
                "Nguyễn Tường Minh",
                20,
                7.5F,
                3,
                "Công nghệ thông tin"
        );
        service.updateSinhVien(sinhVien);
        assertEquals(7.5F, service.getSinhVien().getDiemTrungBinh());
    }
    //Điểm nhỏ hơn 1
    @Test
    void testUpdateDiemLessThan0() {
        //Stub dữ liệu sinh viên
        sinhVien = new SinhVien(
                "SV0001",
                "Nguyễn Tường Minh",
                20,
                -1F,
                3,
                "Công nghệ thông tin"
        );
        Exception ex = assertThrows(IllegalArgumentException.class, () -> service.updateSinhVien(sinhVien));
        assertEquals("Điểm trung bình phải trong khoảng từ 0 đến 10.", ex.getMessage());
    }
    //Điểm lớn hơn 10
    @Test
    void testUpdateDiemGreater10() {
        //Stub dữ liệu sinh viên
        sinhVien = new SinhVien(
                "SV0001",
                "Nguyễn Tường Minh",
                20,
                11F,
                3,
                "Công nghệ thông tin"
        );
        Exception ex = assertThrows(IllegalArgumentException.class, () -> service.updateSinhVien(sinhVien));
        assertEquals("Điểm trung bình phải trong khoảng từ 0 đến 10.", ex.getMessage());
    }
    //Điểm = 1 (biên dưới hợp lệ)
    @Test
    void testUpdateEqual0() {
        //Stub dữ liệu sinh viên
        sinhVien = new SinhVien(
                "SV0001",
                "Nguyễn Tường Minh",
                20,
                0F,
                3,
                "Công nghệ thông tin"
        );
        service.updateSinhVien(sinhVien);
        assertEquals(0F, service.getSinhVien().getDiemTrungBinh());
    }
    //Điểm = 10 (biên trên hợp lệ)
    @Test
    void testUpdateDiemEqual10() {
        //Stub dữ liệu sinh viên
        sinhVien = new SinhVien(
                "SV0001",
                "Nguyễn Tường Minh",
                20,
                10F,
                3,
                "Công nghệ thông tin"
        );
        service.updateSinhVien(sinhVien);
        assertEquals(10.0, service.getSinhVien().getDiemTrungBinh());
    }
}
