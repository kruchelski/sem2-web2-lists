<%@page import="java.util.List"%>
<%@page import="model.Social"%>
<%List<Social> socialList = (List<Social>) request.getAttribute("lista");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Redes sociais</title>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    </head>
    <body>
        <div class="container flow-text">

            <header>
                <div class="z-depth-2" >
                    <h3 class="white-text center teal lighten-2 hoverable card-panel">redes sociais</h3>
                </div>
            </header>

            <main>            
                <div class="rounded z-depth-2">
                    <table class="flow-text highlight darken-2 responsive-table hoverable"> 
                        <tr class="amber-text teal z-depth-4 ">
                            <th>rede social</th>
                            <th>link</th>
                        </tr>
                        <div class="divider"/>
                        <%for (Social s : socialList) {%>
                        <tr>
                            <td><%=s.getNome()%></td>
                            <td><a href="<%=s.getLink()%>"><img src="<%=s.getImgSrc()%>" alt="<%=s.getNome()%>" width="40px" height="40px"></a></td>
                        </tr>
                        <%}%>
                    </table>
                </div>
                <div class="center-align rounded">
                    <a href="<%=request.getContextPath()%>/curso" class="waves-ripple btn z-depth-2 card-panel hoverable">TADS</a>
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
    </body>
</html>
