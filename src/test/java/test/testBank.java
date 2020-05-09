package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.homeBank;
import util.TakeScreenShot;

import java.io.IOException;

public class testBank {
    private static WebDriver driver;
    homeBank home;

    @BeforeClass
    public void setUp(){
        home=new homeBank(driver);
        driver=home.chromeDriverConnection();
        home.visit("http://dbankdemo.com/login");
    }
    @AfterClass
    public void tearDown(){
        if (driver != null) {
        }
    }
    @Test
    public void IngresarRegistro(){
        home.signUp();
    }
    @Test (dependsOnMethods = {"IngresarRegistro"})
    public void IngresarTitulo(){
        home.selectTitulo();
    }
    @Test (dependsOnMethods = {"IngresarTitulo"})
    public void IngresarNombres(){
        home.ingresarNombres();
    }
    @Test (dependsOnMethods = {"IngresarNombres"})
    public void IngresarApellidos(){
        home.ingresarApellidos();
    }
    @Test (dependsOnMethods = {"IngresarApellidos"})
    public void SelectGenero(){
        home.selectGenero();

    }
    @Test (dependsOnMethods = {"SelectGenero"})
    public void IngresarFechNac() throws IOException {
        home.ingresaFechNac();
        TakeScreenShot photo;
        photo = new TakeScreenShot();
        photo.screenShot(driver,"iniciar1.jpg");
    }
    @Test (dependsOnMethods = {"IngresarFechNac"})
    public void IngresarNumSocial(){
        home.ingresarSegSoc();
    }
    @Test (dependsOnMethods = {"IngresarNumSocial"})
    public void IngresarCorreo(){
        home.ingresarEmail();
    }
    @Test (dependsOnMethods = {"IngresarCorreo"})
    public void IngresarPass(){
        home.ingresarPass();
    }
    @Test (dependsOnMethods = {"IngresarPass"})
    public void IngresarConfirmPass(){
        home.ingresarConfirmPass();
    }
    @Test (dependsOnMethods = {"IngresarConfirmPass"})
    public void Confirmar(){
        home.confirmar();
    }
    //@Test
    //public void validar(){
        //Assert.assertEquals("1","2");
    //}
    @Test  (dependsOnMethods = {"Confirmar"})
    public void CapturarPantalla() throws IOException {
        TakeScreenShot photo;
        photo = new TakeScreenShot();
        photo.screenShot(driver,"iniciar2.jpg");
    }
}
