<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <title>Cadastrar ou Edita Aluno</title>
    </head>
    <body>
        <div id="content" class="col-lg-4">
            <h2> Aluno</h2>
            <form action="EstudanteController.do" method="post">
                <div style="visibility:hidden">
                    <label for="estudanteId">ID Estudante</label>
                    <input type="text" name="estudanteId" value="<c:out value="${estudante.idEstudante}" />" readonly="readonly" placeholder="Estudante ID" />
                </div>
                <div>
                    <label for="primeiroNome">Nome:</label>
                    <input class="form-control" type="text" name="primeiroNome" value="<c:out value="${estudante.primeiroNome}" />" placeholder="Nome" />
                </div>
                <div>
                    <label for="segundoNome">Sobrenome:</label>
                    <input class="form-control" type="text" name="segundoNome" value="<c:out value="${estudante.ultimoNome}" />" placeholder="Sobrenome" />
                </div>
                <div>
                    <label for="curso">Curso:</label>
                    <input class="form-control" type="text" name="curso" value="<c:out value="${estudante.curso}" />" placeholder="Curso" />
                </div>
                <div>
                    <input class="btn btn-success" type="submit" value="Salvar" />
                </div>
            </form>
        </div>
    </form>
</body>
</html>