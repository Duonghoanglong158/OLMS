package scripts;

import listeners.SimpleListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

import java.time.Duration;

@Listeners(SimpleListener.class)
public class Veryfy_DiemDanh extends BaseTest{
    @Test(dataProvider = "bookingData")
    public void KiemTraChucNangBTNDiemDanh(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        DiemDanh dd = new DiemDanh(driver);
        dd.GoToDiemDanh();
        dd.DiemDanhBaoLuu();
        dd.CheckTieuDe();
    }
    @Test(dataProvider = "bookingData")
    public void KiemTraDanhSachKhiDiemDanhVang(String username, String password) {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login(username, password);
            DiemDanh dd = new DiemDanh(driver);
            dd.GoToDiemDanh();
            dd.DiemDanhVang();
            driver.findElement(By.xpath("//a[@href='/academic/makeup-class']")).click();
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
