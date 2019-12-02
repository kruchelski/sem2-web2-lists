<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String msg = (String)request.getAttribute("msg");
%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>at05 | index</title>
        <!-- Bootstrap CSS -->
        <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"  media="screen,projection"/>
        <link type="text/css" rel="stylesheet"href="css/customstyle.css" media="screen,projection"/>
    </head>
    <body>
        <div class="container-fluid" id="fundo">
            <div class="row" id="cabecalho">
                <!--this div will only appear if msg is not null-->
                <%if (msg != null){%>
                <div class="col-sm-12  text-left text mt-2  pr-5 rounded text-warning my-auto"><h4 class="display-4"><%=msg%></h4></div>
                <%}%>
                <div class="col-sm-12 text-center text-light my-auto">
                    <h1 class="display-3" id="titulo">atividade 05</h1><br/><br/>
                    <!-- login form -->
                    <form id="formulario" action='login' method="POST">
                        <div class="row">
                            <div class="col-md-3"></div>
                            <div class="form-group col-md-3">
                                <label for="loginInput">login</label><br/>
                                <input type="text" class="form-control" name="userLogin" id="loginInput" placeholder="enter login" autofocus required/>
                            </div>
                            <div class="form-group col-md-3">
                                <label for="passInput">password</label><br/>
                                <input type="password" class="form-control" name="userPass" id="passInput" placeholder="enter password" required/>
                            </div>
                            <div class="col-md-3"></div>
                        </div><br/>
                        <div class="form-row text-center center">
                            <div class="form-group col">
                                <input class="btn btn-outline-light btn-lg" type="submit" value="submit"/>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <!-- link to modal -->
            <div class="row center" id="rodape">
                <div class="col-12 text-center text-light">
                    <footer>
                        <hr/>
                        <a href="#" class="text-light" id="rodapeText"  data-toggle="modal" data-target="#helpModal">need help?</a>
                    </footer>
                </div>
            </div>
        </div>

        <!-- Modal -->
        <div class="modal fade" id="helpModal" tabindex="-1" role="dialog" aria-labelledby="needHelpLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">here's the admin email</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <jsp:useBean id="configura" class="com.ufpr.tads.web2.beans.ConfigBean" scope="application" />
                        <a href="mailto:<jsp:getProperty name="configura" property="email" />">
                            <jsp:getProperty name="configura" property="email" />
                        </a>
                    </div>
                </div>
            </div>
        </div>
        
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/login-script.js"></script>
    </body>
</html>
