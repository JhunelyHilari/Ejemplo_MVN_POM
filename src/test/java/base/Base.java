package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Base {
    private WebDriver driver;
    public Base(WebDriver driver){
        this.driver= driver;
    }
    public WebDriver chromeDriverConnection(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }

    public void selectCombo(By locator, String valor){
        Select s= new Select(driver.findElement(locator));
        s.selectByValue(valor);
    }
    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    public String getText(WebElement  element){
        return element.getText();
    }
    public void type(String inputText,By locator){
        driver.findElement((locator)).sendKeys(inputText);
    }
    public void click(By locator){
        driver.findElement(locator).click();
    }
    //Para verificar si ya se muestra un elemento
    public Boolean isDisplayed(By locator){
        try{
            return driver.findElement(locator).isDisplayed();
        }catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }
    public void visit(String url){
        driver.get(url);
    }
}
