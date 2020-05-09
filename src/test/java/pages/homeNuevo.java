package pages;
import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homeNuevo extends Base {
    By txtbuscar = By.xpath("//input[@id='gh-ac']");
    By btnBuscar = By.xpath("//*[starts-with(@id,'gh-btn')]");
public  homeNuevo(WebDriver driver){
    super(driver);
}
public void EscribirProducto(){
    type("Shoes",txtbuscar);
}
public void nombre(){
    getText(findElement(txtbuscar));
}
public void ClicBuscar(){
    click(btnBuscar);
}
}
