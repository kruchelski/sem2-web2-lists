<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("userLogged") == null) {
        String msg = "you aren't logged... login first";
        request.setAttribute("msg", msg);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
        rd.forward(request, response);
    }
%>
<%
    User userLogged = (User) session.getAttribute("userLogged");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>at03 | main</title>
        <!-- Bootstrap CSS -->
        <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"  media="screen,projection"/>
        <link type="text/css" rel="stylesheet"href="css/customstyle.css" media="screen,projection"/>
    </head>
    <body>
        <div class="container-fluid" id="fundoMain">
            <!-- user name, status area and logout text-->
            <div class="row " id="cabecalhoMain"> 
                <!--user logged -->
                <div class="col-sm-2 text-light text-center">
                    <h3 class="display-4 my-auto" id="infoControl">hi, <%=userLogged.getLogin()%></h3>
                </div>
                <!--Status message (auto show/hide)-->
                <div class="col-sm-8 text-center text-light my-auto"> 
                    <div class='alert-success w-100 text-center rounded' id="successStatus" style='display:none'>user added!</div>    
                    <div class='alert-warning w-100 text-center rounded' id="errorStatus" style='display:none'></div>            
                </div>
                <!-- logout link -->
                <div class="col-sm-2 text-light text-center">
                    <a href="<%= request.getContextPath() + "/logout?n=" + userLogged.getLogin()%>" ><h3 class="display-4 my-auto text-danger" id="infoControl">logout</h3></a>
                </div>
            </div>
            <!--Title at the center of the header -->
            <div class="row " id="cabecalhoMain"> 
                <div class="col-sm-12 text-center text-light my-auto">
                    <h1 class="display-3" id="titulo">users</h1>
                </div>
            </div>
            <!-- subtitle -->    
            <div class="row " id="cabecalhoMain"> 
                <div class="col-sm-12 text-center text-light my-auto">
                    <h2 class="display-3" id="subTitulo">add user</h2>




                    <!-- add user form -->
                    <form id="formularioMain">
                        <div class="row ">
                            <div class="form-group col-sm-4">
                                <label for="nameInput">name</label><br/>
                                <input type="text" class="form-control" name="nameLogin" id="nameInput" placeholder="enter name" autofocus/>
                            </div>
                            <div class="form-group col-sm-4">
                                <label for="loginInput">login</label><br/>
                                <input type="text" class="form-control" name="userLogin" id="loginInput" placeholder="enter login" />
                            </div>
                            <div class="form-group col-sm-4">
                                <label for="passInput" >password</label><br/>
                                <input type="password" class="form-control" name="userPass" id="passInput" placeholder="enter password"/>
                            </div>
                        </div>
                        <div class="form-row text-center center">
                            <div class="form-group col">
                                <input class="btn btn-outline-light btn-lg" type="submit" value="submit"/>
                            </div>
                        </div>
                    </form>              
                </div>
            </div>
        </div>
        <br/>
        <div class=" container table-responsive" id="usersTable">
            <div class="col-sm-12 text-center text-light my-auto">
                <div class="row">
                    <table class="table table table-striped">
                        <thead class="thead-dark">
                            <tr><th scope="col">id</th>
                                <th scope="col">nome</th>
                                <th scope="col">login</th>
                                <th scope="col">senha</th>
                            </tr>
                        </thead>
                        <tbody></tbody>
                    </table>
                </div>
            </div>            
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/mainScript.js"></script>
    </body>
</html>
