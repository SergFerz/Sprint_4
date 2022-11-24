package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class HomePage {
    // Стрелочка открывающая текст вопроса 1
    private final By showQuest_1 = By.id("accordion__heading-0");
    // Окно текста вопроса 1
    private final By displayQuest_1 = By.xpath(".//div/p[text()='Сутки — 400 рублей. " +
            "Оплата курьеру — наличными или картой.']");

    // Стрелочка открывающая текст вопроса 2
    private final By showQuest_2 = By.id("accordion__heading-1");
    // Окно текста вопроса 2
    private final By displayQuest_2 = By.xpath(".//div/p[text()='Пока что у нас так: один " +
            "заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько " +
            "заказов — один за другим.']");
    // Стрелочка открывающая текст вопроса 3
    private final By showQuest_3 = By.id("accordion__heading-2");
    // Окно текста вопроса 3
    private final By displayQuest_3 = By.xpath(".//div/p[text()='Допустим, вы оформляете заказ на 8 мая. " +
            "Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите " +
            "заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.']");
    // Стрелочка открывающая текст вопроса 4
    private final By showQuest_4 = By.id("accordion__heading-3");

    // Окно текста вопроса 4
    private final By displayQuest_4 = By.xpath(".//div/p[text()='Только начиная с завтрашнего дня. " +
            "Но скоро станем расторопнее.']");
    // Стрелочка открывающая текст вопроса 5
    private final By showQuest_5 = By.id("accordion__heading-4");
    // Окно текста вопроса 5
    private final By displayQuest_5 = By.xpath(".//div/p[text()='Пока что нет! Но если что-то срочное — " +
            "всегда можно позвонить в поддержку по красивому номеру 1010.']");
    // Стрелочка открывающая текст вопроса 6
    private final By showQuest_6 = By.id("accordion__heading-5");
    // Окно текста вопроса 6
    private final By displayQuest_6 = By.xpath(".//div/p[text()='Самокат приезжает к вам с полной зарядкой." +
            " Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.']");
    // Стрелочка открывающая текст вопроса 7
    private final By showQuest_7 = By.id("accordion__heading-6");
    // Окно текста вопроса 7
    private final By displayQuest_7 = By.xpath(".//div/p[text()='Да, пока самокат не привезли. Штрафа не " +
            "будет, объяснительной записки тоже не попросим. Все же свои.']");
    // Стрелочка открывающая текст вопроса 8
    private final By showQuest_8 = By.id("accordion__heading-7");
    // Окно текста вопроса 8
    private final By displayQuest_8 = By.xpath(".//div/p[text()='Да, обязательно. Всем самокатов! И Москве," +
            " и Московской области.']");
    private final WebDriver driver;
    private final String url = "https://qa-scooter.praktikum-services.ru/";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public String displayAnswer(int numberQuest) {
        if (numberQuest == 1) {return getHowMuchDoesItCostAnswer();}
        if (numberQuest == 2) {return getWantSeveralScootersAtOnceAnswer();}
        if (numberQuest == 3) {return getHowRentalTimeCalculatedAnswer();}
        if (numberQuest == 4) {return getPossibleToOrderScooterToday();}
        if (numberQuest == 5) {return getPossibleToExtendOrderOrReturnEarlier();}
        if (numberQuest == 6) {return getChargingAlongWithScooter();}
        if (numberQuest == 7) {return getPossibleToCancelOrder();}
        return getBringScooterBeyondMKAD();
    }

    //Открыть текст ответа
    public String getHowMuchDoesItCostAnswer() {
        driver.findElement(showQuest_1).click();
        return driver.findElement(displayQuest_1).getText();
    }
    public String getWantSeveralScootersAtOnceAnswer() {
        driver.findElement(showQuest_2).click();
        return driver.findElement(displayQuest_2).getText();
    }
    public String getHowRentalTimeCalculatedAnswer() {
        driver.findElement(showQuest_3).click();
        return driver.findElement(displayQuest_3).getText();
    }
    public String getPossibleToOrderScooterToday() {
        driver.findElement(showQuest_4).click();
        return driver.findElement(displayQuest_4).getText();
    }
    public String getPossibleToExtendOrderOrReturnEarlier() {
        driver.findElement(showQuest_5).click();
        return driver.findElement(displayQuest_5).getText();
    }
    public String getChargingAlongWithScooter() {
        driver.findElement(showQuest_6).click();
        return driver.findElement(displayQuest_6).getText();
    }
    public String getPossibleToCancelOrder() {
        driver.findElement(showQuest_7).click();
        return driver.findElement(displayQuest_7).getText();
    }
    public String getBringScooterBeyondMKAD() {
        driver.findElement(showQuest_8).click();
        return driver.findElement(displayQuest_8).getText();
    }

    //Прокрутка страниц до раздела "Важные вопросы"
    public void scrollingToQuestion() {
        WebElement element = driver.findElement(showQuest_8);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    //Открытие сайта
    public void open() {
        driver.get(url);
    }
}
