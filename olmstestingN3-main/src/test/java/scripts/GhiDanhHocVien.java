package scripts;


import ObjectRepository.webS;
import listeners.SimpleListener;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import ultilities.ExtentHelper;

import java.util.HashMap;
import java.util.Map;

@Listeners(SimpleListener.class)
public class GhiDanhHocVien extends BaseTest {

    @Test(dataProvider = "bookingData")
    public void verifyGhiDanhHocVien(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        PageQLClass pageQLclass = new PageQLClass(driver);
        PageQLClass.ScrollingActions scroll = new PageQLClass.ScrollingActions(driver);

        loginPage.login(username, password);

        // Cuộn xuống 3 lần
        for (int i = 0; i < 3; i++) {
            scroll.scrollByVerticalPixels(500);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Chờ 5 giây
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        pageQLclass.clickDaoTao();
    }
    @Test(dataProvider = "bookingData")
    public void verifyGhiDanhHocVienKhongChonHV(String username, String password){
        LoginPage loginPage = new LoginPage(driver);
        PageQLClass pageQLclass = new PageQLClass(driver);

        loginPage.login(username, password);
        pageQLclass.clickGhiDanhKhongChonHV();
        loginPage.verifyErrorMessageIsDisplayGhiDanh();

    }

    @DataProvider(name = "bookingData")
    public Object[][] getBookingData() {
        return ExtentHelper.getExcelData("src/main/resources/data1.xlsx", "Sheet1"); //Sheet1 = tên đặt trên sheet Excel
    }

}