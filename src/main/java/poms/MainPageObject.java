package poms;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageObject {
    private WebDriver driver;
    // Элемент списка "Вопросы о важном"
    private By importantQuestionItem = By.className("accordion__item");
    // Выпадающий элемент списка "Вопросы о важном"
    private By importantQuestionPanel = By.className("accordion__panel");
    // Кнопка "Принять куки"
    private By acceptCookiesButton = By.cssSelector(".App_CookieButton__3cvqF");
    // Кнопка "Заказать" в хэдере
    private By orderButtonInHeader = By.cssSelector(".Header_Header__214zg .Button_Button__ra12g");
    // Кнопка "Заказать" внизу
    private By orderButtonInPage = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");

    public MainPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickImportantQuestionItem() {
        WebElement element = driver.findElement(importantQuestionItem);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(element))
                .click();
    }

    public void checkImportantQuestionPanelDisplayed() {
        boolean isDisplayed = driver
                .findElement(importantQuestionItem)
                .findElement(importantQuestionPanel)
                .isDisplayed();
        Assert.assertTrue(isDisplayed);
    }

    public void clickCookiesButton() {
        driver.findElement(acceptCookiesButton).click();
    }

    public void clickOrderButtonInHeader() {
        driver.findElement(orderButtonInHeader).click();
    }

    public void clickOrderButtonInPage() {
        driver.findElement(orderButtonInPage).click();
    }

}
