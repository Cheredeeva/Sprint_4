import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import poms.MainPageObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import poms.MakeOrderPageObject;
import poms.MakeOrderRentPageObject;

@RunWith(Parameterized.class)
public class MakeOrderTest {

    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phone;
    private final String date;
    private final String rent;
    private final boolean blackSelected;
    private final boolean graySelected;
    private final String comment;

    public MakeOrderTest(
        String name,
        String surname,
        String address,
        String metro,
        String phone,
        String date,
        String rent,
        boolean blackSelected,
        boolean graySelected,
        String comment
    ) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
        this.rent = rent;
        this.blackSelected = blackSelected;
        this.graySelected = graySelected;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[] getOrderData() {
        return new Object[][] {
                {
                    "Ярик",
                    "Люблин",
                    "Москва",
                    "Сокольники",
                    "89324467785",
                    "15.02.2022",
                    "сутки",
                    false,
                    true,
                    "Домофон:6386"
                },
                {
                    "Маша",
                    "Мухина",
                    "Москва, Красная площадь",
                    "Измайлово",
                    "89324563700",
                    "06.03.2022",
                    "трое суток",
                    true,
                    false,
                    "И печенек"
                },
        };
    }

    private WebDriver driver;

    @Before
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/order");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void positiveFlowFromHeaderButtonTest() {
        MainPageObject mainPageObject = new MainPageObject(driver);
        mainPageObject.clickCookiesButton();
        mainPageObject.clickOrderButtonInHeader();

        performFlow();
    }

    @Test
    public void positiveFlowFromPageButtonTest() {
        MainPageObject mainPageObject = new MainPageObject(driver);
        mainPageObject.clickCookiesButton();
        mainPageObject.clickOrderButtonInPage();

        performFlow();
    }

    private void performFlow() {
        MakeOrderPageObject makeOrderPageObject = new MakeOrderPageObject(driver);
        makeOrderPageObject.checkOrderFormDisplayed();
        makeOrderPageObject.enterName(name);
        makeOrderPageObject.enterSurname(surname);
        makeOrderPageObject.enterAddress(address);
        makeOrderPageObject.selectMetro(metro);
        makeOrderPageObject.enterPhone(phone);
        makeOrderPageObject.clickNextButton();

        MakeOrderRentPageObject makeOrderRentPageObject = new MakeOrderRentPageObject(driver);
        makeOrderRentPageObject.checkRentFormDisplayed();
        makeOrderRentPageObject.enterDate(date);
        makeOrderRentPageObject.selectRent(rent);

        makeOrderRentPageObject.selectBlackColour(blackSelected);
        makeOrderRentPageObject.selectGrayColour(graySelected);
        makeOrderRentPageObject.enterComment(comment);
        makeOrderRentPageObject.clickOrderButton();
        makeOrderRentPageObject.checkOrderTitleFormDisplayed();
        makeOrderRentPageObject.clickYesButton();
        makeOrderRentPageObject.checkOrderConfirmTitleFormDisplayed();
    }
}
