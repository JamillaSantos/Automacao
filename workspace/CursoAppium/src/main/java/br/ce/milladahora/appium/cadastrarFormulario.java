package br.ce.milladahora.appium;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class cadastrarFormulario{
	
	  private AndroidDriver<WebElement> driver;

	@Before
	  public void setUp() throws MalformedURLException {
	    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability("appPackage", "com.ctappium");
	    desiredCapabilities.setCapability("appActivity", "com.ctappium.MainActivity");

	    driver = new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
	    
	  }
	
	@Test
	public void cadastrar(){
		//Selecionar Formulário
		driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
		
		// Preencher Campos
		WebElement nome = driver.findElement(MobileBy.AccessibilityId("nome"));
		nome.sendKeys("Jamilla");
		
		driver.findElement(MobileBy.AccessibilityId("console")).click();
		WebElement cons = driver.findElement(By.xpath("//android.widget.TextView[@text='PS4']"));
		cons.click();
		
		WebElement check = driver.findElement(MobileBy.AccessibilityId("check"));
		check.click();
		
		WebElement swt = driver.findElement(MobileBy.AccessibilityId("switch"));
		swt.click();
		
		//Salvar
		driver.findElement(By.xpath("//android.widget.TextView[@text='SALVAR']")).click();
		
		//Validar Campos
		WebElement name = driver.findElement(By.xpath("//android.widget.TextView[@index='12']"));
		
		String campoNome = name.getText();
		Assert.assertEquals(nome, campoNome);
		
		driver.quit();
		  
		}

}
