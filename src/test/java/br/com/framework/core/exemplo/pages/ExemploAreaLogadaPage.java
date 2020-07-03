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

public class ExemploAreaLogadaPage extends ExemploAreaLogadaMap {
	
	/**
	 * Contrutor da classe
	 */
	public ExemploAreaLogadaPage() {
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
	
	public void verificarLoginComSucesso() throws IOException {
		
		waitVisibility(menuLinkLogoSite);
		waitVisibility(menuLinkFuncionarios);
		waitVisibility(menuLinkNovoFuncionario);
		waitVisibility(menuLinkSair);
		waitVisibility(tableInputSearch);
		waitVisibility(tableTableEntries);
		ExemploUtils.logPassed("Elementos da página 'Área Logada' exibidos com sucesso.");
		
	}
	
	public void verificarTelaInicialExibidaComSucesso() throws IOException {
		
		String stringMenu;
		
		stringMenu = menuLinkSair.getText();
		
		if (stringMenu.equalsIgnoreCase("sair")) {
			ExemploUtils.logPassed("Página 'Área Logada' acessada com sucesso.");
			ExemploUtils.logPrintScreen("verificarTelaInicialExibidaComSucesso");
		} else {
			ExemploUtils.logFailed("Falha ao validar acesso à página 'Área Logada'.");
			ExemploUtils.logPrintScreen("verificarTelaInicialExibidaComSucesso");
			Assert.fail();
		}
		
	}
	
}
