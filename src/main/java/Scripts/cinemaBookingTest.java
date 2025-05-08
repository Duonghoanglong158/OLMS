package Scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProfilePage;
import Pages.PurchasePage;

import java.time.Duration;

public class cinemaBookingTest extends BaseTest{

    @Test
    public void bookingTest() throws InterruptedException {

        Actions actions = new Actions(driver);

        LoginPage loginPage = new LoginPage(driver);
        PurchasePage purchasePage = new PurchasePage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        HomePage homePage = new HomePage(driver);

        homePage.clickSignInButton();
        loginPage.login("huydao226", "asdEDZ12#");

        Thread.sleep(10000);
        WebElement homeTool = driver.findElement(By.xpath("//div[@id='homeTool']"));
        actions.scrollToElement(homeTool);
        WebElement filmPlayButton = driver
                .findElement(By.xpath("//div[@id='lichChieu']//button[contains(@class,'MuiFab-root')]"));
        actions.moveToElement(filmPlayButton).perform();
        WebElement bookTicket = driver.findElement(By.xpath("//a[@class =\"jss294\" and contains(.,'MUA VÉ')]"));
        bookTicket.click();

        // Chọn Thời gian
        WebElement bookTime = driver.findElement(By.xpath("(//a[contains(@href, '/purchase/')])[1]"));
        bookTime.click();

//        purchasePage.purchaseSlot("12");
        profilePage.verifyBookingPrice("130000", "55");
    }
}

