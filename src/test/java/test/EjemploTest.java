package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.home;

import java.util.concurrent.TimeUnit;

public class EjemploTest {
    private static WebDriver driver;
    private static JavascriptExecutor js;
    private static home eshop;
    //DataEntry
    static final String palabraxbuscar = "Shoes";
    @BeforeClass
    public void setUp(){
        //Driver de Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //Driver de Mozilla Firefox
        //WebDriverManager.firefoxdriver().setup();
        //driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        eshop = new home(driver);
    }
    @AfterClass
    public void teardown(){
        if (driver != null) {
            //driver.quit();
        }
    }
    @Test
    public void Buscar(){
        eshop.txtbuscar().sendKeys(palabraxbuscar);
        eshop.btnBuscar().click();

    }
}
