package br.com.cilia.first;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class LogInCorreto {
		//declaração webDriver
		private static WebDriver driver;

		@Before //executa antes de identificar os testes
	    public void configurar() 
	    {
	      //configuração da localização do chromedriver no PC em execução
		  System.setProperty("webdriver.chrome.driver", "/Users/rootuser/Downloads/chromedriver");
	      //instância do objeto de webDriver
		  LogInCorreto.driver = new ChromeDriver();
		  //manipulação para abrir endereço desejado
	      driver.get("http://www.phptravels.net/login");
	      driver.manage().window().maximize(); 
	    }
	    
	    @Test //passa elementos como parâmetros para preenchimento dos campos encontrados no navegador
	    public void preencherEmailSenha()
	    {	    	
	     WebElement email = driver.findElement(By.name("username"));
	     email.sendKeys("user@phptravels.com");
	    }

	   
	    @After
	    public void fecharPagina()
	    {
	    driver.quit();
	    }

}
