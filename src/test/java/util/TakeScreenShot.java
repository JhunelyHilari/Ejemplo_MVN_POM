package util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class TakeScreenShot {
public static void screenShot(WebDriver driver,String nombre) throws IOException {
    System.out.println("Evidencia");
    TakesScreenshot src=(TakesScreenshot) driver;
    File source=src.getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(source,new File("D:\\Personal\\Curso_Automatización_Selenium\\EvidenciaAutomatización\\"+nombre));
}
}
