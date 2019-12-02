<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String msg = "logout through the main page";
String link = "/main.jsp";
String linkText = "return to the main page";
    if ((session.getAttribute("userLogged") == null) && (request.getAttribute("msg") == null)) {msg = "please, login before you try to logout";
        request.setAttribute("msg", msg);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
        rd.forward(request, response);
    }
    if (request.getAttribute("msg") != null) {
        msg = (String)request.getAttribute("msg");
        link = "/";
        linkText = "return to login screen";
    }
%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>at3 | logout</title>
        <!-- Bootstrap CSS -->
        <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"  media="screen,projection"/>
        <link type="text/css" rel="stylesheet"href="css/customstyle.css" media="screen,projection"/>
    </head>
    <body>
        <div class="container-fluid" id="fundoLogout">
            <div class="row" id="cabecalhoLogout"> 
                <div class="col-sm-6 text-center text-dark my-auto">
                    <h1 class="display-3" id="titulo"><%=msg%></h1><br/><br/>   
                </div>
                <div class="col-sm-6 text-center my-auto">
                    <img  src="imgs/logout.JPG" alt="a tree and the sky" width="75%" height="75%" id="errorImg">
                </div>
            </div>
                    <% request.setAttribute("msg", null); %>
            <!-- link to index -->
            <div class="row center" id="rodapeLogout">
                <div class="col-12 text-center my-auto">
                    <footer>
                        <a href="<%= request.getContextPath() + link %>" class="text-light" id="rodapeText"><%=linkText%></a>
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