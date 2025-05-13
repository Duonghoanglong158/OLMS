package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BoiBai {
    private String urlTrangCanKiemTra = "https://olms.codedao.io.vn/academic/makeup-class";
    private int timeoutTrongGiay = 10;
    WebDriver driver;
    public BoiBai(WebDriver driver) {
        this.driver = driver;
    }
    public void GoToBoiBai(){
        driver.findElement(By.xpath("//span[text()='Đào tạo']")).click();
        driver.findElement(By.xpath("//a[@href='/academic/makeup-class']")).click();
    }
    public void ClickBoiBai(){
        driver.findElement(By.xpath("(//button//*[name()='svg'][@data-testid='TaskAltIcon'])[1]")).click();
    }
    public void ClickNghiTinhPhi(){
        driver.findElement(By.xpath("(//button//*[name()='svg'][@data-testid='UnpublishedIcon'])[1]")).click();

    }
    public void ClickNghiBaoLuu(){
        driver.findElement(By.xpath("(//button//*[name()='svg'][@data-testid='DoNotDisturbOnIcon'])[1]")).click();

    }
    public void HoiBuoiDiemDanh(){
        driver.findElement(By.xpath("(//button//*[name()='svg'][@data-testid='HistoryIcon'])[1]")).click();

    }
    public void kiemTraClickButtonDSBoiBai() {
        driver.get(urlTrangCanKiemTra);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutTrongGiay));

        // Tìm element <a> có thuộc tính href là '/academic/makeup-class'
        WebElement buttonDSBoiBai = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/academic/makeup-class']")));

        // Kiểm tra xem button có được hiển thị và có thể tương tác hay không
        Assert.assertTrue(buttonDSBoiBai.isDisplayed(), "Button 'DS Học viên bồi bài' không hiển thị.");
        Assert.assertTrue(buttonDSBoiBai.isEnabled(), "Button 'DS Học viên bồi bài' không được kích hoạt.");

        // Thực hiện click vào button
        buttonDSBoiBai.click();

        // Kiểm tra URL sau khi click
        String expectedUrlSauClick = "https://olms.codedao.io.vn/academic/makeup-class";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrlSauClick, "Không chuyển đến đúng URL sau khi click.");
    }

}
