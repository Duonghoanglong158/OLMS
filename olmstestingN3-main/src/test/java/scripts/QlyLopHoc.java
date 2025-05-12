package scripts;

import listeners.SimpleListener;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    public void testCreate(String username, String password){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        LoginPage loginPage = new LoginPage(driver);
        PageQLClass pageQLclass = new PageQLClass(driver);
        loginPage.login(username, password);
        LopHoc lp = new LopHoc(driver);
        lp.GoToLopHoc();
        lp.CreateLopHoc();
    }


    @DataProvider(name = "bookingData")
    public Object[][] getBookingData() {
        return ExtentHelper.getExcelData("src/main/resources/data1.xlsx", "Sheet1"); //Sheet1 = tên đặt trên sheet Excel
    }
}
