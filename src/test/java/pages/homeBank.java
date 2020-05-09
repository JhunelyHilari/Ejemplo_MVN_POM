package pages;
import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class homeBank extends Base {
    By linkUrl= By.linkText("Sign Up Here");
    By title= By.id("title");
    By firstName= By.id("firstName");
    By lastName= By.id("lastName");
    By gender= By.cssSelector("input[value='F']");
    By dateBirth= By.id("dob");
    By socialNum= By.id("ssn");
    By email= By.id("emailAddress");
    By password=By.id("password");
    By confirmPass=By.id("confirmPassword");

    String nombre="Jhunely";
    String apellidos="Santos";
    String FechNac="12/10/1990";
    String NumSeguro="123-233";
    String correo="correo@gmail.com";
    String titulo="Ms.";
    String pass="Pass123";
    String confirmPassw=pass;

    public homeBank(WebDriver driver){
        super(driver);
    }
    public void signUp(){
    click(linkUrl);
    }
    public void selectTitulo(){
    //new Select(findElement(title)).selectByValue("Ms.");
    selectCombo(title,titulo);
    }
    public void ingresarNombres(){
        type(nombre,firstName);
    }
    public  void ingresarApellidos(){
        type(apellidos,lastName);
    }
    public void selectGenero(){
        findElement(gender).click();
    }
    public void ingresaFechNac(){
        type(FechNac,dateBirth);
    }
    public void ingresarSegSoc(){
        type(NumSeguro,socialNum);
    }
    public void ingresarEmail(){
        type(correo,email);
    }
    public void ingresarPass(){
        type(pass,password);
    }
    public void ingresarConfirmPass(){
        type(confirmPassw,confirmPass);
    }
    public void confirmar(){
        click(confirmPass);
    }
}
