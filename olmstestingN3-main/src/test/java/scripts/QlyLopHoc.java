package scripts;

import listeners.SimpleListener;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LopHoc;
import pages.PageQLClass;
import ultilities.ExtentHelper;

import java.time.Duration;

@Listeners(SimpleListener.class)

public class QlyLopHoc extends BaseTest{
    @Test(dataProvider = "bookingData")
    public void testClickCreate(String username, String password){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        LoginPage loginPage = new LoginPage(driver);
        PageQLClass pageQLclass = new PageQLClass(driver);
        loginPage.login(username, password);
        LopHoc lp = new LopHoc(driver);
        lp.GoToLopHoc();
        lp.CreateLopHoc();
    }
    @Test(dataProvider = "bookingData")
    public void testInputIsDisabled(String username, String password) {
        String xpathInput = "//input[@id='asynchronous' and @disabled]";
        LoginPage loginPage = new LoginPage(driver);
        LopHoc lp = new LopHoc(driver);
        loginPage.login(username, password);
        lp.GoToLopHoc();
        lp.CreateLopHoc();
        boolean isDisabled = lp.isInputDisabled(xpathInput);
        Assert.assertTrue(isDisabled, "Test Failed: Input field should be disabled but it is enabled.");
        if (isDisabled) {
            System.out.println("Test Passed: Input field is disabled.");
        } else {
            Assert.fail("Test Failed: Input field is enabled."); // Fail test một cách tường minh
        }
    }
    @Test(dataProvider = "bookingData")
    public void TaoLopHocVoiThieuTruongBatBuoc(String username, String password) {

        String xpathInput = "//input[@id='asynchronous' and @disabled]";
        String valueToClick = "Phòng 1 - Tầng 2";
        LoginPage loginPage = new LoginPage(driver);
        LopHoc lp = new LopHoc(driver);
        loginPage.login(username, password);
        lp.GoToLopHoc();
        lp.CreateLopHoc();
        lp.sendKey_TenLopHoc("Testing02");
        lp.sendKey_DoTuoi(18);
        lp.selectAutocompleteOption("Khóa Học IELTS");
        lp.ClickChonLich();
        lp.clickOnDay(16);
//        lp.clickLuuButton();
    }
    @Test(dataProvider = "bookingData")
    public void KiemTraLopHocVuaTao(String username, String password) {
        String search ="0028";
        String Xpath="//td[contains(@class, 'MuiTableCell-body')]//a/p[text()='0028']";
        LoginPage loginPage = new LoginPage(driver);
        LopHoc lp = new LopHoc(driver);
        loginPage.login(username, password);
        lp.GoToLopHoc();
        lp.sendKeySearch(search);
        lp.isElementDisplayed(Xpath);
    }
    @Test(dataProvider = "bookingData")
    public void checkButtonEditClass(String username, String password) {
        String search ="0028";
        String Xpath="//td[contains(@class, 'MuiTableCell-body')]//a/p[text()='0028']";
        LoginPage loginPage = new LoginPage(driver);
        LopHoc lp = new LopHoc(driver);
        loginPage.login(username, password);
        lp.GoToLopHoc();
        lp.sendKeySearch(search);
        lp.Edit();
    }
    @Test(dataProvider = "bookingData")
    public void checkButtonDeleteClass(String username, String password) {
        String search ="0028";
        String Xpath="//td[contains(@class, 'MuiTableCell-body')]//a/p[text()='0028']";
        LoginPage loginPage = new LoginPage(driver);
        LopHoc lp = new LopHoc(driver);
        loginPage.login(username, password);
        lp.GoToLopHoc();
        lp.sendKeySearch(search);
        lp.Delete();
    }
    @Test(dataProvider = "bookingData")
    public void checkAfterDeleteClass(String username, String password) {
        String search ="bbbbb";
        LoginPage loginPage = new LoginPage(driver);
        LopHoc lp = new LopHoc(driver);
        loginPage.login(username, password);
        lp.GoToLopHoc();
        lp.sendKeySearch(search);
        lp.Delete();
        lp.XacNhanXoa();
        lp.sendKeySearch(search);
    }
    @DataProvider(name = "bookingData")
    public Object[][] getBookingData() {
        return ExtentHelper.getExcelData("src/main/resources/data1.xlsx", "Sheet1"); //Sheet1 = tên đặt trên sheet Excel
    }
}
