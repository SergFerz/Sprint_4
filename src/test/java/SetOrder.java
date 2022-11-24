import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_objects.HomePage;
import page_objects.OrderPageRegistration;
import page_objects.OrderPageSelection;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.startsWith;

@RunWith(Parameterized.class)
public class SetOrder {

    private final String firstName;
    private final String secondName;
    private final String address;
    private final String metro;
    private final String phoneNumber;
    private final String duration;
    private final int colour;
    private final String comment;
    private final String date;
    private final int typeButton;
    WebDriver driver = new ChromeDriver();
    HomePage homePage = new HomePage(driver);
    OrderPageRegistration orderPageRegistration = new OrderPageRegistration(driver);
    OrderPageSelection orderPageSelection = new OrderPageSelection(driver);

    public SetOrder(String firstName, String secondName, String address, String metro, String phoneNumber, String date,
                    String duration, int colour, String comment, int typeButton) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.metro = metro;
        this.phoneNumber = phoneNumber;
        this.duration = duration;
        this.colour = colour;
        this.comment = comment;
        this.date = date;
        this.typeButton = typeButton;
    }

    @Before
    public void initOrder() {
        driver.get(homePage.getUrl());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Parameterized.Parameters
    public static Object[][] getQuest() {
        return new Object[][]{
                {"Алексей", "Быков", "Луганская", "Черкизовская", "892223332524", "3.11.22", "сутки", 1, "Быстрее бы", 1},
                {"Дмитрий", "Алексеев", "Салютная", "Сокольники", "892225532524", "4.12.22", "двое суток", 2, "Приехать в 17.00", 1},
        };
    }

    @Test
    public void SetOrderClickOnButtonUp() {
        orderPageRegistration.clickButtonOrder(typeButton);
        orderPageRegistration.enterValueOrder(firstName, secondName, address, metro, phoneNumber);
        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(orderPageSelection.getDisplaySuccessful()));
        orderPageSelection.enterParameters(date, duration, comment, colour);
        MatcherAssert.assertThat(driver.findElement(orderPageSelection.getDisplaySuccessful()).getText(), startsWith("Заказ оформлен"));
    }

    @After
    public void quit() {
        driver.quit();
    }
}