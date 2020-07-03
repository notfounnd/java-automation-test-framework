package br.com.framework.core.exemplo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExemploAreaLogadaMap {
	
	// Elementos da Página
	
	@FindBy(css = "nav div a img[src*='logo']")
	protected WebElement menuLinkLogoSite;
	
	@FindBy(xpath = "//div[@id='navbarSupportedContent']//a[contains(text(),'Funcionários')]")
	protected WebElement menuLinkFuncionarios;
	
	@FindBy(xpath = "//div[@id='navbarSupportedContent']//a[contains(text(),'Novo Funcionário')]")
	protected WebElement menuLinkNovoFuncionario;
	
	@FindBy(xpath = "//div[@id='navbarSupportedContent']//a[contains(text(),'Sair')]")
	protected WebElement menuLinkSair;
	
	@FindBy(xpath = "//div[@id='tabela_filter']//input")
	protected WebElement tableInputSearch;
	
	@FindBy(id = "tabela")
	protected WebElement tableTableEntries;
	
}
