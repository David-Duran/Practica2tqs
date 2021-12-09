package io.cucumber.skeleton;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;


public class WebStepDefinitions {

    /**
     * Note: You must have installed chromedriver in your system
     *       https://chromedriver.chromium.org/downloads
     *       The version must match with the version of your Chrome browser
     *
     *      // Optional. If not specified, WebDriver searches the PATH for chromedriver.
     *      System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
     */

    private final WebDriver driver = new ChromeDriver();
    private Scenario scenario;


    @BeforeAll
    public static void setUp() {
        // This property is optional.
        // If not specified, WebDriver searches the path for chromedriver in your environment variables
        // Example path for Linux or Mac:
        System.setProperty("webdriver.chrome.driver", "src/Driver/chromedriver.exe");
        //driver = new ChromeDriver();
    }

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    @Given("Voy a la pagina de inicio")
    public void iGoToTheHomePage() throws InterruptedException {
        driver.get("https://www.prozis.com/");
    }

    @Then("Deberia ver el boton de {string}")
    public void deberiaVerElBotonDe(String boton) {
        By byXPath = By.xpath("//*[@id='" + boton + "']");
        boolean present = driver.findElements(byXPath).size() > 0;
        Assertions.assertTrue(present);
    }

    @Then("Deberia ver el texto {string}")
    public void deberiaVerElTexto(String texto) throws InterruptedException {
        By byXPath = By.xpath("//*[contains(text(),'" + texto + "')]");
        boolean present = driver.findElements(byXPath).size() > 0;
        Assertions.assertTrue(present);
    }

    @When("Hago clic en el boton de {string}")
    public void hagoClicEnElBotonDe(String boton) {
        driver.findElement(By.linkText(boton)).click();

    }

    @When("Crear cuenta")
    public void crearCuenta() throws InterruptedException {
        WebElement element = driver.findElement(By.name("yt0"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();


    }

    @Then("Inserto el texto {string} en el boton {string}")
    public void insertoElTextoEnElBoton(String valor, String input) {
        driver.findElement(By.id(input)).sendKeys(valor);
    }

    @And("Selecciono el genero")
    public void seleccionoElGenero() {
        driver.findElement(By.id("CreateAccount_gender")).click();
    }

    @And("Acepto terminos")
    public void aceptoTerminos() {
        WebElement element = driver.findElement(By.id("terms_and_conditions"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }


    @And("I take a screenshot with filename {string}")
    public void iTakeAScreenshotWithFilename(String filename) {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "filename");
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }


    @Then("Acepto las cookies")
    public void aceptoLasCookies() {
        driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();
    }

    @And("Espero {string} segundo")
    public void esperoSegundo(String seconds) throws InterruptedException {
        Thread.sleep(Integer.parseInt(seconds)*1000);
    }
}
