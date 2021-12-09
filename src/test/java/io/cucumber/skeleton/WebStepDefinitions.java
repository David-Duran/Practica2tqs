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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    public void iGoToTheHomePage() {
        driver.get("https://www.prozis.com/");
    }

    @Then("Deberia ver el {string} button/text")
    public void iShouldSeeAButton(String text) {
        By byXPath = By.xpath("//*[contains(text(),'" + text + "')]");
        boolean present = driver.findElements(byXPath).size() > 0;
        Assertions.assertTrue(present);
    }

    @When("I click on {string} button")
    public void iClickOnButton(String button_text) {
        driver.findElement(By.linkText(button_text)).click();
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

    @Then("Deberia ver el boton de {string}")
    public void deberiaVerElBotonDe(String boton) {
        boolean present = driver.findElements(By.xpath("//*[contains(text(),'Crear cuenta')]")).size() > 0;

        Assertions.assertTrue(present);
    }

    @When("Voy al carrito")
    public void voyAlCarrito() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"header_search_area\"]/div/div[3]/div/div[4]")).click();
        Thread.sleep(500);    }

    @Then("El carrito esta vacio")
    public void elCarritoEstaVacio() {
        // Aparece el mensaje "Tu carrito de la compra está vacío.!"
        boolean present = driver.findElements(By.xpath("//*[@id=\"content\"]/div/div/section/div")).size()>0;
        Assertions.assertTrue(present);
    }

    @Then("Deberia ver el texto {string}")
    public void deberiaVerElTexto(String texto) {
        By byXPath = By.xpath("//*[contains(text(),'" + texto + "')]");
        boolean present = driver.findElements(byXPath).size() > 0;
        Assertions.assertTrue(present);
    }

    @Then("Busco {string}")
    public void busco(String text) throws InterruptedException{
        driver.findElement(By.xpath("//*[@id=\"quick-search_query\"]")).sendKeys(text);
        Thread.sleep(3000);
    }


}
