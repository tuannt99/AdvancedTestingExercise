import org.junit.jupiter.api.Test;
import vn.hoctotlamhay.utils.ArrayUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArrayTest {
    //Kiểm tra kết quả chính xác
    @Test
    void sumArrayNormalTest(){
        assertEquals(500500, ArrayUtils.sumArray());
    }
    //Kiểm tra giá trị biên
    @Test
    public void sumArrayBoundaryUpperTest() {
        long expected = 1000L * (1000 + 1) / 2;
        assertEquals(expected, ArrayUtils.sumArray());
    }
    //Kiểm tra tính đúng đắn theo công thức
    @Test
    public void sumArrayMatchesFormulaTest() {
        int n = 1000;
        long expected = (long) n * (n + 1) / 2;
        assertEquals(expected, ArrayUtils.sumArray());
    }
    //Kiểm tra tính ổn định của hàm
    @Test
    public void testSumConsistency() {
        long result1 = ArrayUtils.sumArray();
        long result2 = ArrayUtils.sumArray();
        assertEquals(result1, result2);
    }
    //Kiểm tra tổng không bị tràn
    @Test
    public void testSumDoesNotOverflow() {
        long result = ArrayUtils.sumArray();
        assertTrue(result < Long.MAX_VALUE,
        "Giá trị tổng vượt quá giới hạn kiểu long!");
    }
}
