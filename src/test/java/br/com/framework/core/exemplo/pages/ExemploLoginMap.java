package br.com.framework.core.exemplo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ExemploLoginMap {
	
	// Elementos da Página
	
	@FindBy(css = "nav div a img[src*='logo']")
	protected WebElement menuLinkLogoSite;
	
	@FindBy(xpath = "//div[@id='navbarSupportedContent']//a[contains(text(),'Cadastre')]")
	protected WebElement menuLinkCadastreSe;
	
	@FindBy(xpath = "//div[@id='navbarSupportedContent']//a[contains(text(),'Login')]")
	protected WebElement menuLinkLogin;
	
	@FindBy(xpath = "//form/span[contains(text(),'Login')]")
	protected WebElement formHeaderLogin;
	
	@FindBy(how = How.NAME, using = "username")
	protected WebElement formInputUsername;
	
	@FindBy(name = "pass")
	protected WebElement formInputPassword;
	
	@FindBy(xpath = "//div/button[contains(text(),'Entre')]")
	protected WebElement formButtonEntre;
	
	@FindBy(xpath = "//form//a[contains(text(),'Cadastre')]")
	protected WebElement formLinkCadastreSe;
	
	@FindBy(xpath = "//div[@role='alert']")
	protected WebElement alertMessageErro;
	
}
