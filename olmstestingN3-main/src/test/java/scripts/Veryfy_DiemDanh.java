package scripts;

import listeners.SimpleListener;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.DiemDanh;
import pages.LoginPage;
import ultilities.ExtentHelper;

@Listeners(SimpleListener.class)
public class Veryfy_DiemDanh extends BaseTest{
    @Test(dataProvider = "bookingData")
    public void verifyGhiDanhHocVien(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        DiemDanh dd = new DiemDanh(driver);
        dd.GoToDiemDanh();
        //dd.DiemDanhCoMat();
        //dd.DiemDanhVang();
        dd.DiemDanhBaoLuu();
    }
    @DataProvider(name = "bookingData")
    public Object[][] getBookingData() {
        return ExtentHelper.getExcelData("src/main/resources/data1.xlsx", "Sheet1"); //Sheet1 = tên đặt trên sheet Excel
    }
}
