package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DiemDanh {
    WebDriver driver;
    public DiemDanh(WebDriver driver) {
        this.driver = driver;
    }
    public void GoToDiemDanh(){
        driver.findElement(By.xpath("//span[text()='Đào tạo']")).click();
        driver.findElement(By.xpath("//p[text()='Điểm danh']")).click();
    }
    public void DiemDanhVang(){
        driver.findElement(By.xpath("//tr/td[text()='Tùng Lâm - Tom']")).click();
        driver.findElement(By.xpath("//button/text()[normalize-space()='Điểm danh']/parent::button")).click();
        driver.findElement(By.xpath("//th[normalize-space()='Vắng mặt']//input[@type='checkbox']")).click();
        //driver.findElement(By.xpath("//button[text()='Lưu']")).click();
    }
    public void DiemDanhBaoLuu(){
        driver.findElement(By.xpath("//tr/td[text()='Tùng Lâm - Tom']")).click();
        driver.findElement(By.xpath("//button/text()[normalize-space()='Điểm danh']/parent::button")).click();
        driver.findElement(By.xpath("//th[normalize-space()='Nghỉ bảo lưu']//input[@class='PrivateSwitchBase-input css-1m9pwf3']")).click();
        //driver.findElement(By.xpath("//button[text()='Lưu']")).click();
    }
    public void DiemDanhCoMat(){
        driver.findElement(By.xpath("//tr/td[text()='Tùng Lâm - Tom']")).click();
        driver.findElement(By.xpath("//button/text()[normalize-space()='Điểm danh']/parent::button")).click();
        driver.findElement(By.xpath("//th[normalize-space()='Có mặt']//input[@class='PrivateSwitchBase-input css-1m9pwf3']")).click();
        //driver.findElement(By.xpath("//button[text()='Lưu']")).click();
    }
}
