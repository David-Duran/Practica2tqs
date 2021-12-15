package io.cucumber.skeleton;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;



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

    @When("Iniciar sesión")
    public void iniciarSesion(){
        driver.findElement(By.name("yt0")).click();
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

    @When("Voy al carrito")
    public void voyAlCarrito() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"header_search_area\"]/div/div[3]/div/div[4]")).click();
        Thread.sleep(500);    }

    @Then("El carrito esta vacio")
    public void elCarritoEstaVacio() {
        // Aparece el mensaje "Tu carrito de la compra está vacío.!"
        boolean present = driver.findElements(By.xpath("//*[@id=\"content\"]/div/div/section/div")).size() > 0;
        Assertions.assertTrue(present);
    }

    @And("Espero {string} segundo")
    public void esperoSegundo(String seconds) throws InterruptedException {
        Thread.sleep(Integer.parseInt(seconds)*1000);
    }

    @When("Busco {string}")
    public void busco(String text) {
        driver.findElement(By.xpath("//*[@id=\"quick-search_query\"]")).sendKeys(text + "\n");
    }


    @When("Ordeno por {string}")
    public void ordenoPor(String arg0){
        Actions act = new Actions(driver);
        WebElement element1= driver.findElement(By.xpath("//*[@id=\"modal-search\"]/div/div/div/div[2]/div[1]/div[1]/div/div[2]/a/span[1]"));
        act.moveToElement(element1).click().build().perform();
        WebElement element2 = driver.findElement(By.xpath("//*[@id=\"modal-search\"]/div/div/div/div[2]/div[1]/div[1]/div/div[2]/a/ul/li[2]"));
        act.moveToElement(element2).click().build().perform();
    }

    @When("Filtro por {string}")
    public void filtroPor(String arg0) {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"modal-search\"]/div/div/div/div[1]/div/ul[1]/div/li[1]/div/div[1]/label/input"));
        Actions act = new Actions(driver);
        act.moveToElement(element).click().build().perform();
    }

    @And("Añado el primer producto")
    public void añadoElPrimerProducto() {
        //Solo funciona con la busqueda de "100% Real Whey Protein 1000 g"
        WebElement element = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div/a[2]/picture/img"));
        Actions act = new Actions(driver);
        act.moveToElement(element).click().build().perform();
        WebElement element2 = driver.findElement(By.xpath("//*[@id=\"carouselPicker\"]/div[1]/img"));
        act.moveToElement(element2).click().build().perform();
        driver.findElement(By.xpath("//*[@id=\"actionButton\"]")).click();
    }

    @And("Elimino el primer producto")
    public void eliminoElPrimerProducto() throws InterruptedException {
        driver.findElement(By.className("card-discard")).click();
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"chkLists\"]/section/section")));
        driver.findElement(By.xpath("//*[@id=\"chk-modal-wrapper\"]/div/div[2]/div[2]/form/div[2]/div/div")).click();
    }

    @When("Abro el menu")
    public void abroElMenu() {
        driver.findElement(By.id("the_h_menu")).click();

    }

    @When("Selecciono la categoria {string}")
    public void seleccionoLaCategoria(String arg0) {
        Actions builder = new Actions(driver);
        WebElement element1 = driver.findElement(By.xpath("//*[@id=\"lateral-menu\"]/div/div/div["+ arg0 + "]"));
        builder.moveToElement(element1).perform();
    }

    @Then("Veo el submenu")
    public void veoElSubmenu() {
        Assertions.assertTrue(driver.findElement(By.id("submenuAll")).isDisplayed());
    }


    @When("Hago clic en el boton con id {string}")
    public void hagoClicEnElBotonConId(String arg0) {
        driver.findElement(By.id(arg0)).click();
    }

    @And("Hago clic en mi perfil")
    public void hagoClicEnMiPerfil() {
        driver.findElement(By.className("account-box")).click();
    }

    @And("Guardo los cambios")
    public void guardoLosCambios() {
        WebElement element = driver.findElement(By.name("yt0"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    @And("Hago clic en Foto de Perfil")
    public void hagoClicEnFotoDePerfil() {
        driver.findElement(By.xpath("//*[@id=\"dashboard_content\"]/div/div[2]/div[1]/div/div/div[2]")).click();
    }

    @And("Añado la foto de perfil")
    public void añadoLaFotoDePerfil() {
        driver.findElement(By.xpath("//*[@id=\"preview_profile_photo_form\"]/a")).click();
    }

    @And("Añado una dirección")
    public void añadoUnaDirección() {

        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Address_name")));
        driver.findElement(By.xpath("//*[@id=\"dashboard_content\"]/div/div[2]/div[1]/div[2]/a/div")).click();
    }
}