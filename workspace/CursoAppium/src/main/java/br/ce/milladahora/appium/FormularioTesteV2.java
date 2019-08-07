package br.ce.milladahora.appium;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.ce.milladahora.appium.core.DriverFactory;

public class FormularioTesteV2 {
	
	private AndroidDriver<MobileElement> driver;
	
	@Before
	public void inicializarAppium() throws MalformedURLException {
		driver = DriverFactory.getDriver();
	    
	  //Selecionar formulario
	    driver.findElement(MobileBy.xpath("//*[@text='Formulário']")).click();
	}
	
	@After
	public void tearDown(){
		DriverFactory.killDriver();
	}
	
	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
	    	    
	    //Escrever nome
	    MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
	    campoNome.sendKeys("Jamilla");
	    
	    //Checar nome escrito
	    String text = campoNome.getText();
	    Assert.assertEquals("Jamilla", text); 	    	    
	    
	}
	
	@Test
	public void deveInteragirCombo() throws MalformedURLException {
	    	    
	    //Clicar no combo
	    driver.findElement(MobileBy.AccessibilityId("console")).click();
	    
	    //selecionar opção desejada
	    driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='PS4']")).click();
	    
	    //verificar opção selecionada
	    String string = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
	    Assert.assertEquals("PS4", string);  	    
	       
	}
	
	@Test
	public void deveInteragirSwitchCheckbox() throws MalformedURLException {
	        
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
	       
	}
	
	@Test
	public void deveResolverDesafio() throws MalformedURLException {
	    
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
	    
	    MobileElement combo = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Console: ps4')]"));
	    Assert.assertEquals("Console: ps4", combo.getText());
	    
	    MobileElement swit = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
	    Assert.assertTrue(swit.getText().endsWith("Off"));
	    
	    MobileElement check = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
	    Assert.assertTrue(check.getText().endsWith("Marcado"));

	}
}
