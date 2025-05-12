package scripts;

import listeners.SimpleListener;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BoiBai;
import pages.DiemDanh;
import pages.LoginPage;
import ultilities.ExtentHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.Duration;

@Listeners(SimpleListener.class)
public class Veryfy_BoiBai extends BaseTest{
    @Test(dataProvider = "bookingData")
    public void verifyButtonBoiBai(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        BoiBai bb = new BoiBai(driver);
        bb.GoToBoiBai();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //bb.ClickNghiBaoLuu();
    }
    @Test(dataProvider = "bookingData")
    public void kiemTraChuyenTrangSauKhiNhanVaoDSBoiBai(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        BoiBai bb = new BoiBai(driver);
        bb.GoToBoiBai();
        String expectedUrl = "https://olms.codedao.io.vn/academic/makeup-class"; // Lấy URL chính xác của trang
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Không đúng trang bồi bài. URL thực tế: " + actualUrl);
    }
    @Test(dataProvider = "bookingData")
    public void kiemTraHocVienSauKhiDiemDanhVangMat(String username, String password) {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        BoiBai bb = new BoiBai(driver);
        bb.GoToBoiBai();
        // Kiểm tra sự tồn tại của "Tùng Lâm - Tom"
        By tungLamTomLocator = By.xpath("//td[text()='Tùng Lâm - Tom']");
        Assert.assertTrue(isElementVisible(tungLamTomLocator), "Thành phần 'Tùng Lâm - Tom' không hiển thị trên trang sau " + 1 + " giây.");

        // Kiểm tra sự tồn tại của "Sunny 66"
        By sunny66Locator = By.xpath("//td[text()='Sunny 66']");
        Assert.assertTrue(isElementVisible(sunny66Locator), "Thành phần 'Sunny 66' không hiển thị trên trang sau " + 1 + " giây.");

        // Kiểm tra sự tồn tại của "12/05/2025"
        By ngayThangLocator = By.xpath("//td[text()='12/05/2025']");
        Assert.assertTrue(isElementVisible(ngayThangLocator), "Thành phần '12/05/2025' không hiển thị trên trang sau " + 1 + " giây.");
    }



    // Phương thức hỗ trợ kiểm tra xem một element có hiển thị trên trang hay không
    private boolean isElementVisible(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return element.isDisplayed();
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }
    @DataProvider(name = "bookingData")
    public Object[][] getBookingData() {
        return ExtentHelper.getExcelData("src/main/resources/data1.xlsx", "Sheet1"); //Sheet1 = tên đặt trên sheet Excel
    }
}
