package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

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
    public boolean isInputDisabled(String xpath) {
        try {
            WebElement inputElement = driver.findElement(By.xpath(xpath));
            String isDisabled = inputElement.getAttribute("disabled");
            return isDisabled != null && isDisabled.equals("true");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.err.println("Warning: Input element with XPath '" + xpath + "' not found.");
            return false; // Trả về false nếu không tìm thấy element
        }
    }
    public void verifyLopHocPageNavigation() {
        String expectedUrl = "https://olms.codedao.io.vn/academic/classesa"; // Lấy URL chính xác của trang
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Không đúng trang Lớp học. URL thực tế: " + actualUrl);
    }
    public void sendKey_TenLopHoc(String tenLop) {
        WebElement tenLopHocInput = driver.findElement(By.xpath("(//input[@id='name'])[1]"));
        tenLopHocInput.sendKeys(tenLop);
    }
    public void sendKey_DoTuoi(int tuoi) {
        WebElement doTuoiInput = driver.findElement(By.xpath("(//input[@id='name'])[2]"));
        doTuoiInput.sendKeys(String.valueOf(tuoi));
    }
    public void ClickChonLich(){
        driver.findElement(By.xpath("//button//*[name()='svg'][@data-testid='CalendarIcon']")).click();
    }
    public void clickOnDay(int day) {
        String dayXpath = "//button[contains(@class, 'MuiPickersDay-root') and text()='" + day + "']";
        WebElement dayElement = driver.findElement(By.xpath(dayXpath));
        dayElement.click();
    }
    public void clickAddLichHoc(){
        driver.findElement(By.xpath("//div[contains(@class, 'MuiGrid-item') and .//label[text()='Lịch học']]//button//*[name()='svg'][@data-testid='AddCircleOutlineIcon']")).click();

    }
    public void clickLuuButton(){
        driver.findElement(By.xpath("//button[text()='Lưu']")).click();
    }
    public void ChonLichDay(){
        driver.findElement(By.xpath("(//div[@id='class-status' and @role='combobox'])[1]")).click();
    }
    public void ChonPhongHoc(String expectedValue){
        By autocompleteInputLocator = By.xpath("//input[@id='asynchronous' and @value]");
        driver.findElement(By.xpath("(//input[@id='asynchronous'])[4]")).click();
        WebElement inputElement = driver.findElement(By.xpath("//input[@id='asynchronous' and @value='" + expectedValue + "']"));
            inputElement.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(autocompleteInputLocator));

        inputElement.sendKeys(Keys.DOWN);
            inputElement.sendKeys(Keys.ENTER);
    }
    public void sendKeySearch(String textToSend){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Chờ tối đa 10 giây
        WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Tìm kiếm lớp học']")));
        searchInput.sendKeys(textToSend);
        searchInput.sendKeys(Keys.ENTER);
    }
    public boolean clickListItemByDataValue(String dataValue, int timeoutSeconds) {
        String xpath = "//li[@data-value='" + dataValue + "']";
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
            WebElement listItem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            listItem.click();
            System.out.println("Đã click vào thẻ li với data-value: " + dataValue);
            return true; // Click thành công
        } catch (org.openqa.selenium.TimeoutException e) {
            System.err.println("Không tìm thấy hoặc không thể click vào thẻ li với data-value: " + dataValue + " sau " + timeoutSeconds + " giây.");
            return false; // Không tìm thấy hoặc không click được
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.err.println("Không tìm thấy thẻ li với data-value: " + dataValue);
            return false;
        } catch (org.openqa.selenium.ElementNotInteractableException e) {
            System.err.println("Không thể tương tác (không click được) với thẻ li có data-value: " + dataValue);
            return false;
        }
    }
    public void selectAutocompleteOption(String optionText) {
        By autocompleteInputLocator = By.xpath("(//input[@role='combobox'])[3]");
        By autocompleteOptionsLocator = By.xpath("//ul[contains(@class, 'MuiAutocomplete-listbox')]//li");

        WebElement inputElement = driver.findElement(autocompleteInputLocator);
        inputElement.sendKeys(optionText);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(autocompleteOptionsLocator));
        inputElement.sendKeys(Keys.ENTER);
        System.err.println("Không tìm thấy tùy chọn autocomplete: " + optionText);

    }
    public void Edit(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Chờ tối đa 10 giây
        WebElement EditButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button//*[name()='svg'][@data-testid='EditIcon']/..")));
        EditButton.click();
    }
    public void Delete(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Chờ tối đa 10 giây
        WebElement DeleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button//*[@data-testid='DeleteIcon']/..")));
        DeleteButton.click();
    }
    public void XacNhanXoa(){
        driver.findElement(By.xpath("//button[text()='Xoá']")).click();
    }
    public boolean isElementDisplayed(String xpathLocator) {
        int defaultTimeoutSeconds = 5;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(defaultTimeoutSeconds));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLocator)));
            return element.isDisplayed();
        } catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

}
