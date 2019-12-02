<%@page import="com.ufpr.tads.web2.beans.LoginBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    LoginBean logged = (LoginBean)session.getAttribute("userLogged");
     if ((logged == null) || (logged.getLogin() == null)){
         // changed the errorMsg to msg according to the specification of the activity
        request.setAttribute("msg", "you aren't logged... login first"); // errorMsg - mensagem de erro 
        // not used anymore :(
        /*
        request.setAttribute("errorLink", request.getContextPath() + "/"); // errorLink - Link para retornar
        request.setAttribute("errorLinkText", "return to login screen"); // errorLinkText - Hyperlink do retorno
        */
        // Now forwards to the index.jsp
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }
%>

<jsp:useBean id="userLogged" class="com.ufpr.tads.web2.beans.LoginBean" scope="session" />

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>at04 | main</title>
        <!-- Bootstrap CSS -->
        <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"  media="screen,projection"/>
        <link type="text/css" rel="stylesheet"href="css/customstyle.css" media="screen,projection"/>
    </head>
    <body>
        <div class="container-fluid" id="fundoMain">
            <div class="row" id="upperMain">
                <div class="col-sm-12">
                    <div class="row " id="cabecalhoMain"> 
                        <!--user logged -->
                        <div class="col-sm-2 text-light text-center">
                            <h3 class="display-4 my-auto" id="infoControl">hi, <jsp:getProperty name="userLogged" property="login"/></h3>
                        </div>
                        <!--empty div only for spacing-->
                        <div class="col-sm-8"></div>
                        <!-- logout link -->
                        <div class="col-sm-2 text-light text-center">
                            <a href="<%= request.getContextPath() + "/logout?n=" + userLogged.getLogin()%>" ><h3 class="display-4 my-auto text-danger" id="infoControl">logout</h3></a>
                        </div>
                    </div>
                </div>
                <div class="col-sm-12 text-center text-light my-auto">
                    <h1 class="display-3" id="titulo">at 04 | main page</h1><br/>
                </div>
                <div class="row " id="cabecalhoMain">
                    <div class="col-md-5 text-center text-light my-auto">
                        <a href='<%=request.getContextPath()%>/usermgmt.jsp'><button class="btn btn-outline-light btn-lg">users management</button></a>          
                    </div>
                    <div class="col-md-2"></div>
                    <div class="col-md-5 text-center text-light my-auto">
                        <a href='<%=request.getContextPath()%>/clientmgmt.jsp'><button class="btn btn-outline-light btn-lg">clients management</button></a>          
                    </div>
                </div>
            </div>
            <br/>
            <!-- link to modal -->
            <div class="row center" id="rodape">
                <div class="col-12 text-center text-light">
                    <footer>
                        <hr/>
                        <a href="#" class="text-light" id="rodapeText"  data-toggle="modal" data-target="#helpModal">need help?</a>
                        <br/>
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
                        <a href="${configura.email}">
                        <!--<a href="mailto:<jsp:getProperty name="configura" property="email" />">-->
                            ${configura.email}
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/mainScript.js"></script>
    </body>
</html>
