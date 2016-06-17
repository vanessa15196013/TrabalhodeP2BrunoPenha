<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">

        <title>Lista de Alunos</title>
        <style type="text/css">
            /*Definido cor das linhas pares*/
            .table_list tr:nth-child(even) {background: #FFFFFF}

            /*Definindo cor das Linhas ímpares*/
            .table_list tr:nth-child(odd) {background: #F5F5F5}       

        </style>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <p class="col-md-12 ">
                        <h2 class="col-md-5">Sistema Acadêmico</h2>
                    </p>
                    <p class="col-md-12"><a class="text-right" href="LogoutController" title="Sair">Sair do sistema <i class="fa fa-sign-out" aria-hidden="true"></i></a></p> 
                </div>  
                <div class="col-md-12">
                    <div id="content" class="col-lg-8">
                        <h3 class="col-md-5">Lista de Alunos</h3> 
                        <a class="col-md-7 text-right" href="EstudanteController.do?action=inseri" title="Cadastrar Aluno"> 
                            <i class="fa fa-user fa-2x" aria-hidden="true"></i>
                        </a>
                        <table class="table table_list">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Nome</th>
                                    <th>Sobrenome</th>
                                    <th>Curso</th>
                                    <th colspan="2">Ações</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${estudantes}" var="estudante">
                                    <tr>
                                        <td><c:out value="${estudante.idEstudante}" /></td>
                                        <td><c:out value="${estudante.primeiroNome}" /></td>
                                        <td><c:out value="${estudante.ultimoNome}" /></td>
                                        <td><c:out value="${estudante.curso}" /></td>
                                        <td>
                                            <a href="EstudanteController.do?action=edita&estudanteId=<c:out value="${estudante.idEstudante}"/>" title="Editar"> 
                                               <i class="fa fa-pencil" aria-hidden="true"></i>
                                            </a>
                                        </td>
                                        <td>
                                            <a href="EstudanteController.do?action=deleta&estudanteId=<c:out value="${estudante.idEstudante}"/>" title="Excluir">
                                                <i class="fa fa-times" aria-hidden="true"></i>
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>        
                </div>
            </div>
        </div>
        
    </body>
</html>