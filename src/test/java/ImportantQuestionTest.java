import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import poms.MainPageObject;
import org.junit.Test;
import org.junit.After;

public class ImportantQuestionTest {
    private WebDriver driver;

    @Test
    public void panelDisplaysOnItemClickTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPageObject mainPageObject = new MainPageObject(driver);
        mainPageObject.clickImportantQuestionItem();
        mainPageObject.checkImportantQuestionPanelDisplayed();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
