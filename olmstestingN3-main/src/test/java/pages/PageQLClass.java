package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageQLClass {

    WebDriver driver;

    public PageQLClass(WebDriver driver) {
        this.driver = driver;
    }

    public void clickDaoTao() {
        driver.findElement(By.xpath("//span[text()='Đào tạo']")).click();
        driver.findElement(By.xpath("//p[text()='Lớp học']")).click();
        driver.findElement(By.xpath("//a[p[text()='0028']]")).click();
        //driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div[2]/div/div[2]/div[3]/div[2]/div/div/div/div/div[1]/div[3]/div/button")).click();
        //WebElement inputBox = driver.findElement(By.id("asynchronous"));
        //inputBox.clear();
        //inputBox.sendKeys("Hoàng Anh Khang");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement suggestion = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@value='Hoàng Anh Khang - Lucas (10/10/2019) (Chị Vân - 0989527759)']")
        ));
        suggestion.click();
    }

    // Định nghĩa ScrollingActions là một static inner class
    public static class ScrollingActions {
        private WebDriver driver;

        public ScrollingActions(WebDriver driver) {
            this.driver = driver;
        }

        public void scrollToBottomOfPage() {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        }
        public void scrollByPixels(int xPixels, int yPixels) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(" + xPixels + ", " + yPixels + ")");
        }
        public void scrollByVerticalPixels(int pixels) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, " + pixels + ")");
        }
    }

    public void clickGhiDanhKhongChonHV() {
        driver.findElement(By.xpath("//span[text()='Đào tạo']")).click();
        driver.findElement(By.xpath("//p[text()='Lớp học']")).click();
        driver.findElement(By.xpath("//a[p[text()='0028']]")).click();
        //driver.findElement(By.xpath("//div[contains(@class,'MuiButtonGroup-root')]//button[@type='button']")).click();
        driver.findElement(By.xpath("//button[text()='Lưu']")).click();
    }
}