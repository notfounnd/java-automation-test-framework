package br.com.framework.core.exemplo.pages;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.framework.core.configuration.ExemploTestRules;
import br.com.framework.core.utils.ExemploUtils;

public class ExemploLoginPage extends ExemploLoginMap {
	
	/**
	 * Contrutor da classe
	 */
	public ExemploLoginPage() {
		PageFactory.initElements(ExemploTestRules.getDriver(), this);
	}
	
	protected WebDriverWait wait;
	
	/**
	 * Metodo para verificar se o elemento foi carregado corretamente na página
	 * 
	 * @param element - Objeto WebElement do elemento da página
	 * @throws IOException
	 */
	private void waitVisibility(WebElement element) throws IOException {
		try {
			wait = new WebDriverWait(ExemploTestRules.getDriver(), 30);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException e) {
			Assert.fail();
		}
	}
	
	// Ações da Página
	
	public void validarElementosExemploPageLogin() throws IOException {
		
		waitVisibility(menuLinkLogoSite);
		waitVisibility(menuLinkCadastreSe);
		waitVisibility(menuLinkLogin);
		waitVisibility(formHeaderLogin);
		waitVisibility(formInputUsername);
		waitVisibility(formInputPassword);
		waitVisibility(formButtonEntre);
		waitVisibility(formLinkCadastreSe);
		ExemploUtils.logPassed("Elementos da página 'Login' exibidos com sucesso.");
		
	}
	
	public void preencherCampoUsername(String username) {
		
		formInputUsername.sendKeys(username);
		ExemploUtils.logPassed("Campo 'usuário' preenchido com sucesso com o valor " + username + ".");
		
	}
	
	public void preencherCampoPassword(String password) throws IOException {
		
		formInputPassword.sendKeys(password);
		ExemploUtils.logPassed("Campo 'senha' preenchido com sucesso com o valor " + password + ".");
		ExemploUtils.logPrintScreen("preencherCampoPassword");
		
	}
	
	public void acionarBotaoEntre() {
		
		formButtonEntre.click();
		ExemploUtils.logPassed("Botão 'entre' acionado com sucesso.");
		
	}
	
	public void verificarLoginSemSucesso() throws IOException {
		
		waitVisibility(alertMessageErro);
		ExemploUtils.logPassed("Login não efetuado.");
		
	}
	
	public void verificarLoginApresentaMensagemDeErro() throws IOException {
		
		String stringMensagemErro;
		
		stringMensagemErro = alertMessageErro.getText();
		
		if (stringMensagemErro.contains("ERRO! Usuário ou Senha inválidos")) {
			ExemploUtils.logPassed("Mensagem de erro exibida com sucesso.");
			ExemploUtils.logPrintScreen("verificarLoginApresentaMensagemDeErro");
		} else {
			ExemploUtils.logFailed("Falha ao validar mensamge de erro.");
			ExemploUtils.logPrintScreen("verificarLoginApresentaMensagemDeErro");
			Assert.fail();
		}
		
	}
	
}
