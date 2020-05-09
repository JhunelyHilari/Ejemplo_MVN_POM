package test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.homeNuevo;

public class testNuevo {
    private static WebDriver driver;
    homeNuevo home;

    @BeforeClass
    public void setUp(){
        home = new homeNuevo(driver);
        driver=home.chromeDriverConnection();
        home.visit("https://pe.ebay.com/");
        //driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    @AfterClass
    public void teardown(){
        if (driver != null) {
            //driver.quit();
        }
    }
    @Test
    public void BuscarProducto(){
        home.EscribirProducto();
        home.ClicBuscar();
    }
    @Test(dependsOnMethods = {"BuscarProducto"})
        public void test2(){

        }

}