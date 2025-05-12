package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BoiBai {

    WebDriver driver;
    public BoiBai(WebDriver driver) {
        this.driver = driver;
    }
    public void GoToBoiBai(){
        driver.findElement(By.xpath("//span[text()='Đào tạo']")).click();
        driver.findElement(By.xpath("//a[@href='/academic/makeup-class']")).click();
    }
    public void ClickBoiBai(){
        driver.findElement(By.xpath("//button[contains(@class, 'MuiIconButton-root') and contains(@class, 'css-rrlqo')][1]")).click();

    }
    public void ClickNghiTinhPhi(){
        driver.findElement(By.xpath("//button[contains(@class, 'MuiIconButton-root') and contains(@class, 'css-rrlqo')][2]")).click();

    }
    public void ClickNghiBaoLuu(){
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div[2]/div/div[3]/div/table/tbody/tr[1]/td[9]/button[3]/svg/path")).click();

    }


}
