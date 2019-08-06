package br.ce.milladahora.appium;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CopyOfFormularioTeste {
	
	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
	    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/Milla da Hora/workspace/CursoAppium/src/main/resources/CTAppium-1-1.apk");
	    
	    AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    //Selecionar formulario
//	    
//	    Imprime elementos com o className "android.widget.TextView":

// 		for(MobileElement elemento: elementosEncontrados){
//    	System.out.println(elemento.getText());
//   	    }

//		1° Exemplo - utilizando className e índice	    
	    List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));
   	    
	    elementosEncontrados.get(1).click();
	    	    
	    //Escrever nome
	    MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
	    campoNome.sendKeys("Jamilla");
	    
	    //Checar nome escrito
	    String text = campoNome.getText();
	    Assert.assertEquals("Jamilla", text); 	    	    
	       
	    driver.quit();
	}
	
	@Test
	public void deveInteragirCombo() throws MalformedURLException {
	    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/Milla da Hora/workspace/CursoAppium/src/main/resources/CTAppium-1-1.apk");
	    
	    AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    //Selecionar formulario
//	    
//		2° Exemplo - utilizando variável e xpath //class[@atributo='value']
//	    MobileElement findElement = driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']"));
//	    findElement.click();
	    
//	    3º Exemplo - sem utilizar variável
	    driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Formulário']")).click();
	    
	    //Clicar no combo
	    driver.findElement(MobileBy.AccessibilityId("console")).click();
	    
	    //selecionar opção desejada
	    driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='PS4']")).click();
	    
	    //verificar opção selecionada
	    String string = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
	    Assert.assertEquals("PS4", string);  	    
	       
	    driver.quit();
	}
	
	@Test
	public void deveInteragirSwitchCheckbox() throws MalformedURLException {
	    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/Milla da Hora/workspace/CursoAppium/src/main/resources/CTAppium-1-1.apk");
	    
	    AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    //Selecionar formulario
//	    
//		2° Exemplo - utilizando variável e xpath //class[@atributo='value']
//	    MobileElement findElement = driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']"));
//	    findElement.click();
	    
//	    3º Exemplo - sem utilizar variável
//	    driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Formulário']")).click();
	    
//	    4º Exemplo - generalizar a busca
	    driver.findElement(MobileBy.xpath("//*[@text='Formulário']")).click();
	    
	    //Verificar status dos elementos
	    MobileElement check = driver.findElement(By.className("android.widget.CheckBox"));
	    MobileElement swit = driver.findElement(MobileBy.AccessibilityId("switch"));
	    Assert.assertTrue(check.getAttribute("checked").equals("false"));
	    Assert.assertTrue(swit.getAttribute("checked").equals("true"));
	    
	    //Clicar nos elementos
	    check.click();
	    swit.click();
	    
	    //Verificar estados alterados
	    Assert.assertFalse(check.getAttribute("checked").equals("false"));
	    Assert.assertFalse(swit.getAttribute("checked").equals("true"));
	       
	    driver.quit();
	}
	
	@Test
	public void deveResolverDesafio() throws MalformedURLException {
	    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/Milla da Hora/workspace/CursoAppium/src/main/resources/CTAppium-1-1.apk");
	    
	    AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    //Selecionar Formulário
	    driver.findElement(MobileBy.xpath("//*[@text='Formulário']")).click();
	  		
	    // Preencher Campos
	    MobileElement name = driver.findElement(MobileBy.AccessibilityId("nome"));
	    name.sendKeys("Jamilla");
	  		
	    driver.findElement(MobileBy.AccessibilityId("console")).click();
	    driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='PS4']")).click();
	  		
	    driver.findElement(MobileBy.AccessibilityId("check")).click();
	  		
	    driver.findElement(MobileBy.AccessibilityId("switch")).click();
	  		
	    //Salvar
	    driver.findElement(By.xpath("//android.widget.TextView[@text='SALVAR']")).click();
	  		
	    //Validar Campos
	    MobileElement nome = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text,'Nome:')]"));
	    Assert.assertTrue(nome.getText().endsWith(name.getText()));
//	    Assert.assertEquals("Nome: Jamilla", nome.getText());
	    
	    MobileElement combo = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
	    Assert.assertEquals("Console: ps4", combo.getText());
	    
	    MobileElement swit = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
	    Assert.assertTrue(swit.getText().endsWith("Off"));
	    
	    MobileElement check = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
	    Assert.assertTrue(check.getText().endsWith("Marcado"));

	       
	    driver.quit();
	}
}
