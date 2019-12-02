<%@page import="model.Curso"%>
<%@page import="java.util.List"%>
<%List<Curso> cursoList = (List<Curso>) request.getAttribute("curso");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cursos TADS</title>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    </head>
    <body>
        <div class="container">

            <header>
                <div class="no-pad-bot light" >
                    <h3 class="white-text center teal lighten-2 hoverable card-panel">cursos TADS</h3>
                </div>
            </header>

            <main>            
                <div class="parallax-container z-depth-2 hoverable" style="height:250px">
                    <div class="parallax"><img src="imgs/sept.jpg"></div>
                    <h2 class="header center white-text text-lighten-2 light">SEPT</h2>
                    <div class="row center">
                        <h5 class="header col s12 amber-text text-lighten-2 light">setor de educação profissional e tecnológica</h5>
                    </div>
                    <div class="row center">
                        <a href="http://http://www.sept.ufpr.br/portal/" class="btn waves-effect waves-light light teal lighten-1">Acesse o site</a>
                    </div>
                </div>
                <div class="section white grey-text text-darken-3 center-align">
                    <div class="row center">
                        <h2 class="header">Cursos oferecidos no SEPT</h2>
                        <div class="divider"></div>
                    </div>
                    <div class="row">
                        <h5 class="blue-text text-darken-2">Cursos técnicos</h5>
                        <div class="divider"></div>
                    </div>
                    <div class="row">
                        <%
                            int i = 0;
                            for (Curso c : cursoList) {
                                if ((i % 4) == 0) {%></div><div class="row"><%}
                                    if (c.getNome().equals("TADS")) {i = 0;%>           
                    </div>
                    <div class="row ">
                        <h5 class="blue-text text-darken-2">Cursos superiores de tecnologia</h5>
                        <div class="divider"></div>
                    </div>
                    <div class="row">
                        <%}
                                    if (c.getNome().equals("Pós-Graduação em Bioinformática")) { i= 0;%>
                    </div>
                    <div class="row ">
                        <h5 class="blue-text text-darken-2">Pós graduação</h5>
                        <div class="divider"></div>
                    </div>
                    <div class="row">
                        <%}%>
                        <div class="col s3">
                            <div class="card medium grey lighten-5">
                                <div class="card-image">
                                    <img src="<%=c.getImgSrc()%>">
                                </div>
                                <div class="card-content"> <h6><%=c.getNome()%></h6></div>
                                <div class="card-action blue darken-3 z-depth-3 hoverable">
                                    <!--<a href="<%=c.getLink()%>">Site</a>-->
                                    <a href="<%=c.getLink()%>" class="waves-ripple z-depth-2 btn-small amber blue-text text-darken-3 accent-1 hoverable">SITE</a>
                                </div>
                            </div> 
                        </div>
                        <%i++;%>
                        <%}%>
                    </div>
                </div>

                <div class="center-align rounded">
                    <a href="<%=request.getContextPath()%>/social" class="waves-ripple btn z-depth-2 card-panel hoverable">REDES SOCIAIS</a>
                </div> 
                <br/>
            </main>

            <footer class="page-footer teal darken-2 z-depth-3 rounded">
                <div clas="container">
                    <div class="row">
                        <div class="col s12 center">
                            <h6>mds, eu nao creio que to fazendo as coisas em java web</h6>
                        </div>
                    </div>
                </div>
                <div class="footer-copyright">
                    <div class="container center">
                        <h6 class="grey-text text-lighten-1">copyright 2019</h6>
                    </div>
                </div>  
            </footer>
            <br/>
        </div>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script>
            $(document).ready(function () {
                $('.parallax').parallax();
            });
        </script>
    </body>
</html>

