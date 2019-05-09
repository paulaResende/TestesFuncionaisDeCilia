package br.com.cilia.first;

import static org.junit.Assert.assertEquals;

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
	    public void preencherEmailSenha() throws InterruptedException
	    {	    	
	     WebElement email = driver.findElement(By.name("username"));
	     email.sendKeys("user@phptravels.com");
	     
	     //thread fornece tempo para que a visualização de preenchimento dos campos seja possibilitada
	     Thread.sleep(2000);
	     WebElement senha = driver.findElement(By.name("password"));
	     senha.sendKeys("demouser");
	     Thread.sleep(2000);
	     
	     //encontra o botão de login e clica
	     driver.findElement(By.cssSelector("button.btn.btn-action.btn-lg.btn-block.loginbtn")).click();
	     Thread.sleep(50000);
	     
	     //verifica se o login foi realizado de maneira devida
	     assertEquals(driver.getCurrentUrl(), "https://www.phptravels.net/account/");	     
	    }

	   
	    @After
	    public void fecharPagina()
	    {
	    driver.quit();
	    }

}
