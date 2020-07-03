package br.com.framework.core.exemplo.test;

import java.io.IOException;

import br.com.framework.core.exemplo.pages.ExemploAreaLogadaPage;
import br.com.framework.core.exemplo.pages.ExemploLoginPage;
import io.cucumber.java.pt.*;

public class ExemploLoginSteps {
	
	@Dado ("que eu tenha acessado a tela de login")
	public void acessarTelaLogin() throws IOException {
		ExemploLoginPage exemploLoginPage = new ExemploLoginPage();
		exemploLoginPage.validarElementosExemploPageLogin();
	}
	
	@Quando ("preencho o campo 'Usuário'")
	public void preencherCampoUsuario() throws IOException {
		ExemploLoginPage exemploLoginPage = new ExemploLoginPage();
		exemploLoginPage.preencherCampoUsername("user_test");
	}
	
	@Quando ("preencho o campo 'Senha'")
	public void preencherCampoSenha() throws IOException {
		ExemploLoginPage exemploLoginPage = new ExemploLoginPage();
		exemploLoginPage.preencherCampoPassword("test123!");
	}
	
	@Quando ("^preencho o campo 'Usuário' com o valor ([^\"]*)$")
	public void preencherCampoUsuarioIvalido(String usuario) throws IOException {
		ExemploLoginPage exemploLoginPage = new ExemploLoginPage();
		exemploLoginPage.preencherCampoUsername(usuario);
	}
	
	@Quando ("^preencho o campo 'Senha' com o valor ([^\"]*)$")
	public void preencherCampoSenhaIvalida(String senha) throws IOException {
		ExemploLoginPage exemploLoginPage = new ExemploLoginPage();
		exemploLoginPage.preencherCampoPassword(senha);
	}
	
	@Quando ("aciono no botão 'Entre'")
	public void acionarBotaoEntre() throws IOException {
		ExemploLoginPage exemploLoginPage = new ExemploLoginPage();
		exemploLoginPage.acionarBotaoEntre();
	}
	
	@Então ("o login na aplicação é realizado com sucesso")
	public void verificarLoginComSucesso() throws IOException {
		ExemploAreaLogadaPage exemploAreaLogadaPage = new ExemploAreaLogadaPage();
		exemploAreaLogadaPage.verificarLoginComSucesso();
	}
	
	@Então ("o login na aplicação não é realizado")
	public void verificarLoginSemSucesso() throws IOException {
		ExemploLoginPage exemploLoginPage = new ExemploLoginPage();
		exemploLoginPage.verificarLoginSemSucesso();
	}
	
	@Então ("é apresentado a tela inicial da aplicação")
	public void verificarTelaInicialApresentadaComSucesso() throws IOException {
		ExemploAreaLogadaPage exemploAreaLogadaPage = new ExemploAreaLogadaPage();
		exemploAreaLogadaPage.verificarTelaInicialExibidaComSucesso();
	}
	
	@Então ("é apresentado mensagem de erro")
	public void verificarLoginApresentaMensagemDeErro() throws IOException {
		ExemploLoginPage exemploLoginPage = new ExemploLoginPage();
		exemploLoginPage.verificarLoginApresentaMensagemDeErro();
	}
	
}
