import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountManagerTest {
    private static WebDriver driver;
    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @ParameterizedTest
    @CsvSource({
            "Nguyễn Tường Minh,minhnt@gmail.com,minhnt123",
    })
    public void registerTest(String name, String email, String password) {
        driver.get("https://hoctotlamhay.vn/register");
        WebElement nameInput = driver.findElement(By.name("name"));
        WebElement emailInput = driver.findElement(By.name("user_email"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Đăng ký')]"));
        //Nhập dữ liệu
        nameInput.sendKeys(name);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        //Nhấn nút Đăng ký
        submitButton.click();
        //Chờ chuyển hướng
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.urlToBe("https://hoctotlamhay.vn/")
        ));
        // Kiểm tra URL sau khi đăng ký
        String currentUrl = driver.getCurrentUrl();
        assertEquals("https://hoctotlamhay.vn/", currentUrl,
                "Không trở lại trang chủ sau khi đăng ký thành công.");
    }
//    @ParameterizedTest
//    @CsvSource({
//            "minhnt@gmail.com,minhnt123,Nguyễn Tường Minh"
//    })
//    public void loginTest(String email, String password, String expectedName) {
//        driver.get("https://hoctotlamhay.vn/login");
//        // Tìm và nhập thông tin đăng nhập
//        WebElement emailInput = driver.findElement(By.name("user_email"));
//        WebElement passwordInput = driver.findElement(By.name("password"));
//        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Đăng nhập')]"));
//        emailInput.sendKeys(email);
//        passwordInput.sendKeys(password);
//        loginButton.click();
//        //Chờ cho đến khi trang chủ tải xong
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.urlContains("https://hoctotlamhay.vn/"));
//        //Kiểm tra sự xuất hiện của tên người dùng
//        WebElement nameElement = wait.until(ExpectedConditions.presenceOfElementLocated(
//                By.xpath("//*[contains(text(),'" + expectedName + "')]")
//        ));
//        assertTrue(nameElement.isDisplayed(),
//                "Không tìm thấy tên: " + expectedName);
//    }
    @AfterAll
    public static void tearDown() {
        if (driver != null) driver.quit();
    }
}
