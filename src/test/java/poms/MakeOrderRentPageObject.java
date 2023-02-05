package poms;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MakeOrderRentPageObject {
    private WebDriver driver;
    // Заголовок "Про аренду"
    private By rentTitle = By.className("Order_Header__BZXOb");
    // Поле "Когда привезти самокат"
    private By dateField = By.cssSelector(".Input_Input__1iN_Z.Input_Responsible__1jDKN[placeholder=\"* Когда привезти самокат\"]");
    // Поле "Срок аренды"
    private By rentPeriodField = By.className("Dropdown-placeholder");
    // Выпадающий список со сроками
    private By rentPeriodList = By.className("Dropdown-menu");
    // Чекбокс "Черный жемчуг"
    private By colorBlack = By.id("black");
    // Чекбокс "Серая безысходность"
    private By colorGray = By.id("grey");
    // Поле "комментарий для курьера"
    private By commentField = By.cssSelector(".Input_Input__1iN_Z.Input_Responsible__1jDKN[placeholder=\"Комментарий для курьера\"]");
    // Кнопка "Заказать"
    private By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    //Заголовок "Хотите оформить заказ?"
    private By orderTitle = By.className("Order_ModalHeader__3FDaJ");
    // Кнопка "Да"
    private By buttonYes = By.xpath(".//button[text()='Да']");
    // Поле "Заказ оформлен"
    private By orderConfirmTitle = By.xpath(".//*[text()='Заказ оформлен']");

    public MakeOrderRentPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void checkRentFormDisplayed() {
        boolean isDisplayed = driver
                .findElement(rentTitle)
                .isDisplayed();
        Assert.assertTrue(isDisplayed);
    }

    public void enterDate(String date) {
        driver.findElement(dateField).sendKeys(date);
        driver.findElement(rentTitle).click();
    }

    public void selectRent(String rent) {
        driver.findElement(rentPeriodField).click();
        driver
                .findElement(rentPeriodList)
                .findElement(By.xpath(".//*[text()='" + rent + "']"))
                .click();
    }

    public void selectBlackColour(boolean selected) {
        WebElement element = driver.findElement(colorBlack);
        if (element.isSelected() != selected) {
            element.click();
        }
    }

    public void selectGrayColour(boolean selected) {
        WebElement element = driver.findElement(colorGray);
        if (element.isSelected() != selected) {
            element.click();
        }
    }

    public void enterComment(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void checkOrderTitleFormDisplayed() {
        boolean isDisplayed = driver
                .findElement(orderTitle)
                .isDisplayed();
        Assert.assertTrue(isDisplayed);
    }

    public void clickYesButton() {
        driver.findElement(buttonYes).click();
    }

    public void checkOrderConfirmTitleFormDisplayed() {
        boolean isDisplayed = driver
                .findElement(orderConfirmTitle)
                .isDisplayed();
        Assert.assertTrue(isDisplayed);
    }
}
