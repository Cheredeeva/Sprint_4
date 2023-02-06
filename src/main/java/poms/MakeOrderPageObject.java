package poms;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MakeOrderPageObject {

    private WebDriver driver;
    // Заголовок "Для кого самокат"
    private By scooterTitle = By.className("Order_Header__BZXOb");
    // Поле "Имя"
    private By nameField = By.cssSelector(".Input_Input__1iN_Z.Input_Responsible__1jDKN[placeholder=\"* Имя\"]");
    // Поле "Фамилия"
    private By surnameField = By.cssSelector(".Input_Input__1iN_Z.Input_Responsible__1jDKN[placeholder=\"* Фамилия\"]");
    // Поле "Адрес"
    private By addressField = By.cssSelector(".Input_Input__1iN_Z.Input_Responsible__1jDKN[placeholder=\"* Адрес: куда привезти заказ\"]");
    // Поле "Станция метро"
    private By metroField = By.className("select-search__input");
    // Выпадающий список с метро
    private By metroList = By.className("select-search__select");
    // Поле "Телефон"
    private By phoneField = By.cssSelector(".Input_Input__1iN_Z.Input_Responsible__1jDKN[placeholder=\"* Телефон: на него позвонит курьер\"]");
    // Кнопка "Далее"
    private By nextButton = By.xpath(".//button[text()='Далее']");

    public MakeOrderPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void checkOrderFormDisplayed() {
        boolean isDisplayed = driver
                .findElement(scooterTitle)
                .isDisplayed();
        Assert.assertTrue(isDisplayed);
    }

    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterSurname(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    public void enterAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void selectMetro(String metro) {
        driver.findElement(metroField).click();
        WebElement element = driver
                .findElement(metroList)
                .findElement(By.xpath(".//*[text()='" + metro + "']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(element))
                .click();
    }

    public void enterPhone(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }

    public void clickNextButton() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(nextButton))
                .click();
    }

}
