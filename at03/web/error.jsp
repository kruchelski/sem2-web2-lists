<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String errorMsg = "error error error error";%>
<% if (request.getAttribute("msg") != null) errorMsg = (String)request.getAttribute("msg");
%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>at03 | error</title>
        <!-- Bootstrap CSS -->
        <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"  media="screen,projection"/>
        <link type="text/css" rel="stylesheet"href="css/customstyle.css" media="screen,projection"/>
    </head>
    <body>
        <div class="container-fluid" id="fundoError">
            <div class="row" id="cabecalhoError"> 
                <div class="col-sm-6 text-center my-auto">
                    <img  src="imgs/error.JPG" alt="a lamp in a wall at night" width="75%" height="75%" id="errorImg">
                </div>
                <div class="col-sm-6 text-center text-light my-auto">
                    <h1 class="display-3" id="titulo"><%=errorMsg%></h1><br/><br/>   
                </div>
            </div>
                    <% request.setAttribute("msg", null); %>
            <!-- link to index -->
            <div class="row center" id="rodape">
                <div class="col-12 text-center">
                    <footer>
                        <hr/>
                        <a href="<%= request.getContextPath() + "/" %>" class="text-dark" id="rodapeText">return to login screen</a>
                    </footer>
                </div>
            </div>
        </div>
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/error-script.js"></script>
    </body>
</html>