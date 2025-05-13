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
    public void KiemTraNutDanhSachHocVienBoiBai(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        BoiBai bb = new BoiBai(driver);
        bb.GoToBoiBai();
        bb.kiemTraClickButtonDSBoiBai();
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
    public void kiemTraDanhDauDaBoiBai(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        BoiBai bb = new BoiBai(driver);
        bb.GoToBoiBai();
        bb.ClickBoiBai();
    }
    @Test(dataProvider = "bookingData")
    public void kiemTraDanhDauNghiTinhPhi(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        BoiBai bb = new BoiBai(driver);
        bb.GoToBoiBai();
        bb.ClickNghiTinhPhi();
    }
    @Test(dataProvider = "bookingData")
    public void kiemTraDanhDauNghiBaoLuu(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        BoiBai bb = new BoiBai(driver);
        bb.GoToBoiBai();
        bb.ClickNghiBaoLuu();
    }
    @Test(dataProvider = "bookingData")
    public void kiemTraClickHoiBuoiDiemDanh(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        BoiBai bb = new BoiBai(driver);
        bb.GoToBoiBai();
        bb.HoiBuoiDiemDanh();
    }


    // Phương thức hỗ trợ kiểm tra xem một element có hiển thị trên trang hay không

    @DataProvider(name = "bookingData")
    public Object[][] getBookingData() {
        return ExtentHelper.getExcelData("src/main/resources/data1.xlsx", "Sheet1"); //Sheet1 = tên đặt trên sheet Excel
    }
}
