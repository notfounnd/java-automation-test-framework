#language:pt

@exemplo
Funcionalidade: Login

	@exemplo1
	Cenário: Realizar login no portal InmRobo.tk
		Dado que eu tenha acessado a tela de login
		Quando preencho o campo 'Usuário'
		E preencho o campo 'Senha'
		E aciono no botão 'Entre'
		Então o login na aplicação é realizado com sucesso
		E é apresentado a tela inicial da aplicação

	@exemplo2
	Esquema do Cenário: Realizar login com dados inválidos no portal InmRobo.tk
		Dado que eu tenha acessado a tela de login
		Quando preencho o campo 'Usuário' com o valor <usuario>
		E preencho o campo 'Senha' com o valor <senha>
		E aciono no botão 'Entre'
		Então o login na aplicação não é realizado
		E é apresentado mensagem de erro
		
		Exemplos: 
			| usuario							| senha							|
			| user_test_invalido	| test123!					|
			| user_test						| test123!_invalida	|
