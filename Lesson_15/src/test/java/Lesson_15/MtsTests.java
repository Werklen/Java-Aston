package Lesson_15;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.List;

public class MtsTests {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.mts.by/");

        // Обработка кнопки cookie
        try {
            WebElement continueButtonCookie = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree")));
            continueButtonCookie.click();
        } catch (Exception e) {
            // Кнопка не найдена, продолжаем
        }
    }

    @Test
    public void testOnlineReplenishmentBlock() {
        // 1. Проверка названия указанного блока
        WebElement blockTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pay__wrapper")));
        String blockTitleText = blockTitle.getText().replaceAll("\r?\n", " ").replaceAll(" +", " ").trim();

        Assert.assertTrue("Блок 'Онлайн пополнение без комиссии' не найден", blockTitle.isDisplayed());
        Assert.assertTrue("Элемент не содержит ожидаемый текст!", blockTitleText.contains("Онлайн пополнение без комиссии"));


        // 2. Проверка наличия логотипов платёжных систем
        int paymentLogosCount = driver.findElements(By.xpath("//div[@class='pay__partners']//img")).size();
        Assert.assertEquals("Логотипы платёжных систем не найдены", 5, paymentLogosCount);
    }

    @Test
    public void testPlaceholder() {
        WebElement serviceOption = driver.findElement(By.xpath("//button[@class='select__header']"));
        if (serviceOption.isDisplayed() && serviceOption.isEnabled()) {
            // Кликаем на элемент
            serviceOption.click();
            List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class='select__list']/li")));

//             Перебираем элементы и кликаем на нужный
            for (WebElement option : options) {
                if (option.getText().equals("Услуги связи")) {
                    option.click();

                    WebElement inputFieldPhone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("connection-phone")));
                    WebElement inputFieldSum = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("connection-sum")));
                    WebElement inputFieldMail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("connection-email")));
                    // Получаем плейсхолдер
                    String placeholderPhone = inputFieldPhone.getAttribute("placeholder");
                    String placeholderSum = inputFieldSum.getAttribute("placeholder");
                    String placeholderMail = inputFieldMail.getAttribute("placeholder");
                    // Ожидаемое значение плейсхолдера
//                    String expectedPhonePlaceholder = "Номер телефона";
//                    String expectedSumPlaceholder = "Сумма";
//                    String expectedMailPlaceholder = "E-mail для отправки чека";
                    // Проверяем плейсхолдер
                    Assert.assertEquals("Плейсхолдеры некорректны для телефона", "Номер телефона", placeholderPhone);
                    Assert.assertEquals("Плейсхолдеры некорректны для почты", "Сумма", placeholderSum);
                    Assert.assertEquals("Плейсхолдеры некорректны для суммы", "E-mail для отправки чека", placeholderMail);
                }

                if (option.getText().equals("Домашний интернет")) {
                    option.click();
                    WebElement inputFieldPhone = driver.findElement(By.id("internet-phone"));
                    WebElement inputFieldSum = driver.findElement(By.id("internet-sum"));
                    WebElement inputFieldMail = driver.findElement(By.id("internet-email"));
                    // Получаем плейсхолдер
                    String placeholderPhone = inputFieldPhone.getAttribute("placeholder");
                    String placeholderSum = inputFieldSum.getAttribute("placeholder");
                    String placeholderMail = inputFieldMail.getAttribute("placeholder");
                    // Ожидаемое значение плейсхолдера
//                    String expectedPhonePlaceholder = "Номер абонента";
//                    String expectedSumPlaceholder = "Сумма";
//                    String expectedMailPlaceholder = "E-mail для отправки чека";
                    // Проверяем плейсхолдер
                    Assert.assertEquals("Плейсхолдеры некорректны для телефона", "Номер абонента", placeholderPhone);
                    Assert.assertEquals("Плейсхолдеры некорректны для почты", "Сумма", placeholderSum);
                    Assert.assertEquals("Плейсхолдеры некорректны для суммы", "E-mail для отправки чека", placeholderMail);
                }

                if (option.getText().equals("Рассрочка")) {
                    option.click();
                    WebElement inputFieldPhone = driver.findElement(By.id("score-instalment"));
                    WebElement inputFieldSum = driver.findElement(By.id("instalment-sum"));
                    WebElement inputFieldMail = driver.findElement(By.id("instalment-email"));

                    // Получаем плейсхолдер
                    String placeholderPhone = inputFieldPhone.getAttribute("placeholder");
                    String placeholderSum = inputFieldSum.getAttribute("placeholder");
                    String placeholderMail = inputFieldMail.getAttribute("placeholder");

                    // Ожидаемое значение плейсхолдера
//                    String expectedPhonePlaceholder = "Номер счета на 44";
//                    String expectedSumPlaceholder = "Сумма";
//                    String expectedMailPlaceholder = "E-mail для отправки чека";

                    // Проверяем плейсхолдер
                    Assert.assertEquals("Плейсхолдеры некорректны для телефона", "Номер счета на 44", placeholderPhone);
                    Assert.assertEquals("Плейсхолдеры некорректны для почты", "Сумма", placeholderSum);
                    Assert.assertEquals("Плейсхолдеры некорректны для суммы", "E-mail для отправки чека", placeholderMail);
                }
                if (option.getText().equals("Задолженность")) {
                    option.click();
                    WebElement inputFieldPhone = driver.findElement(By.id("score-arrears"));
                    WebElement inputFieldSum = driver.findElement(By.id("arrears-sum"));
                    WebElement inputFieldMail = driver.findElement(By.id("arrears-email"));
                    // Получаем плейсхолдер
                    String placeholderPhone = inputFieldPhone.getAttribute("placeholder");
                    String placeholderSum = inputFieldSum.getAttribute("placeholder");
                    String placeholderMail = inputFieldMail.getAttribute("placeholder");
                    // Ожидаемое значение плейсхолдера
//                    String expectedPhonePlaceholder = "Номер счета на 2073";
//                    String expectedSumPlaceholder = "Сумма";
//                    String expectedMailPlaceholder = "E-mail для отправки чека";
                    // Проверяем плейсхолдер
                    Assert.assertEquals("Плейсхолдеры некорректны для телефона", "Номер счета на 2073", placeholderPhone);
                    Assert.assertEquals("Плейсхолдеры некорректны для почты", "Сумма", placeholderSum);
                    Assert.assertEquals("Плейсхолдеры некорректны для суммы", "E-mail для отправки чека", placeholderMail);

                }
            }
        } else {
            System.out.println("Элемент недоступен для взаимодействия.");
        }

    }
    @Test
    public void testDetailsLink() {

//         3. Проверка работы ссылки «Подробнее о сервисе»

        WebElement link = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'Подробнее о сервисе')]")));
        link.click();
        wait.until(ExpectedConditions.titleContains("Порядок оплаты и безопасность интернет платежей"));
        Assert.assertTrue("Страница 'Подробнее о сервисе' не открылась", driver.getTitle().contains("Порядок оплаты и безопасность интернет платежей"));

        // Вернуться на главную страницу
        driver.navigate().back();
        WebElement blockTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(normalize-space(), 'Онлайн пополнение без комиссии')]")));
        Assert.assertTrue("Переход на главную страницу не произведен", blockTitle.isDisplayed());

    }
    @Test
    public void testContinueButtonFunctionality() throws InterruptedException {
        // 4. Заполнить поля и проверить работу кнопки «Продолжить»
        WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("connection-phone")));
        phoneInput.sendKeys("297777777");
        Assert.assertTrue(phoneInput.isDisplayed());

        WebElement sumInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("connection-sum")));
        String bynAmount = "10";
        sumInput.sendKeys(bynAmount);
        Assert.assertTrue(sumInput.isDisplayed());

        WebElement continueButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Продолжить')]")));
        continueButton.click();

        Thread.sleep(8000);

        driver.switchTo().frame(wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bepaid-iframe"))));
        //List<WebElement> amountElementList = driver.findElements(By.xpath("//*[contains(text(), 'BYN')]"));
        WebElement bynAmountTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'BYN')]")));
        Assert.assertTrue("Элемент не содержит ожидаемый текст!", bynAmountTitle.getText().contains(bynAmount));

        WebElement bynAmountButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'BYN')]")));
        Assert.assertTrue("Элемент не содержит ожидаемый текст!", bynAmountButton.getText().contains(bynAmount));

        WebElement phoneNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Номер')]")));
        Assert.assertTrue("Элемент не содержит ожидаемый текст!", phoneNumber.getText().contains("375297777777"));

        WebElement inputCardNumber = driver.findElement(By.className("ng-tns-c46-1"));
        Assert.assertEquals("Элемент не содержит ожидаемый текст!", "Номер карты", inputCardNumber.getText());
        WebElement inputCardDate = driver.findElement(By.className("ng-tns-c46-4"));
        Assert.assertEquals("Элемент не содержит ожидаемый текст!", "Срок действия", inputCardDate.getText());
        WebElement inputCardCvc = driver.findElement(By.className("ng-tns-c46-5"));
        Assert.assertEquals("Элемент не содержит ожидаемый текст!", "CVC", inputCardCvc.getText());

        WebElement inputCardName = driver.findElement(By.className("ng-tns-c46-3"));
        Assert.assertEquals("Элемент не содержит ожидаемый текст!", "Имя держателя (как на карте)", inputCardName.getText());

        int paymentLogosCount = driver.findElements(By.xpath("//div[contains(@class,'cards-brands') and contains(@class,'cards-brands__container')]//img")).size();
        Assert.assertEquals("Логотипы платёжных систем не найдены", 5, paymentLogosCount);

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
