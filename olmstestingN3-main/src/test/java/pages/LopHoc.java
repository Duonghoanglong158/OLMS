package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LopHoc {
    WebDriver driver;
    public LopHoc(WebDriver driver) {
        this.driver = driver;
    }
    public void GoToLopHoc(){
        driver.findElement(By.xpath("//span[text()='Đào tạo']")).click();
        driver.findElement(By.xpath("//p[text()='Lớp học']")).click();
    }
    public void CreateLopHoc(){
        driver.findElement(By.xpath("//button[text()='Tạo mới']")).click();
        WebElement taoLopHocTitle = driver.findElement(By.xpath("//h2[text()='Tạo lớp học']"));
        String actualTitle = taoLopHocTitle.getText();
        String expectedTitle = "Tạo lớp học";
        System.out.println(actualTitle);
        Assert.assertEquals(actualTitle, actualTitle, "Tiêu đề 'Tạo lớp học' không đúng. Tiêu đề thực tế: " + actualTitle);
    }
    public void verifyLopHocPageNavigation() {
        String expectedUrl = "https://olms.codedao.io.vn/academic/classesa"; // Lấy URL chính xác của trang
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Không đúng trang Lớp học. URL thực tế: " + actualUrl);
    }

}
