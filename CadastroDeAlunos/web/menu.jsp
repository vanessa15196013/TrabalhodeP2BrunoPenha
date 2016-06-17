<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
      <title>Menu</title>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
    </head>
    <body>
      <h2>Sistema Acadêmico</h2>
      <p>Bem-vindo, ${usuarioLogado.login}</p> 
      <a href="EstudanteController?action=listaEstudante">Clique aqui</a> para acessar a lista de alunos.
      <br/>
      <a class="text-right" href="LogoutController" title="Sair">Sair do sistema <i class="fa fa-sign-out" aria-hidden="true"></i></a>
    </body>
</html>