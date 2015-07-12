<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Usuário</title>
</head>
<body>

	<form method="post" action="usucontroller">
		
		<label for="inpId">ID:</label>
		<input id="inpId" type="text" name = "id" /></br>
		
		<label for="inpNome">Nome:</label>
		<input id="inpNome" type="text" name = "nome" /></br>
		
		<label for="inpLogin">Login:</label>
		<input id="inpLogin" type="text" name = "login" /></br>
		
		<label for="inpSenha">Senha:</label>
		<input id="inpSenha" type="password" name = "senha" /></br>
		
		<input type="submit" value="Salvar" >
		
		
	</form>
</body>
</html>