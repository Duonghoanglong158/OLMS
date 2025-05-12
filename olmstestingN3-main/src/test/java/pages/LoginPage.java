package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String userName, String pwd){
        driver.findElement(By.xpath("//input[@id='emailOrUsername']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }



    public void verifyErrorMessageIsDisplay(){
        WebElement errorMsg = driver.findElement(By.xpath("//p[@id='matKhau-helper-text']"));
        Assert.assertTrue(errorMsg.equals(""));
    }

    public void verifyErrorMessageIsDisplayGhiDanh(){
        WebElement errorMsg = driver.findElement(By.xpath("//p[text()='The given id must not be null']"));
        Assert.assertEquals("The given id must not be null", errorMsg.getText());
    }
}
