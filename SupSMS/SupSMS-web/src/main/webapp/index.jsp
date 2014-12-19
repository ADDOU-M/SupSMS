<%-- 
    Document   : menuBar
    Created on : 10 déc. 2014, 14:34:22
    Author     : Ekue_Weledji
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <title>SupSMS</title>
        <meta name="generator" content="Bootply" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!--[if lt IE 9]>
                <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        <!--test-->
        <link href="css/styles.css" rel="stylesheet">
    </head>
    <body>
        <!-- Header -->
        <jsp:include page="include/header.jsp" />
        <!-- /Header -->        

        <!-- Main -->
        <div class="container-fluid">
            <div class="row">
                <!-- Left column -->
                <jsp:include page="include/menu.jsp" />
                <jsp:include page="include/menuAdmin.jsp" />
                <!-- /Left column -->

                <div class="col-sm-9">
                    <div class="row">
                        <!-- center left-->                        
                        <c:choose>
                            <c:when test="${empty user and empty admin}">
                                <div class="col-md-6">                         
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <div class="panel-title">
                                                <i class="glyphicon glyphicon-wrench pull-right"></i>
                                                <a><h4>SUPSMS</h4></a>                                        
                                            </div>
                                            <div class="panel-title">
                                                <p>
                                                    Bienvenue sur SUPSMS, le site d'envoi de SMS en illimité<br/>
                                                    Souscrivez à notre offre exclusive de 10 $ par mois pour pouvoir envoyer des SMS à tous vos contacts partout dans le monde et de façon illimitée<br/>
                                                    Inscrivez-vous rapidement en cliquant sur le lien ci-dessous.                                                    
                                                </p>
                                                <c:url value="/sign-up" var="signUpUrl" />
                                                <div class="control-group">
                                                    <label></label>
                                                    <div class="controls pull-right">
                                                        <a href="${signUpUrl}"><button class="btn btn-primary">
                                                                Inscription
                                                            </button></a>                                                        
                                                    </div>
                                                </div><br/>
                                            </div>
                                        </div>                                
                                    </div><!--/panel-->             
                                </div><!--/col-span-6-->

                                <div class="col-md-6"> 
                                    <div class="panel panel-default">
                                        <div class="panel-heading"><h4>Stats</h4></div>
                                        <div class="panel-body">

                                            <small>Nombre d'utilisateurs connectés</small>
                                            <div class="progress">
                                                <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="72" aria-valuemin="0" aria-valuemax="100" style="width: 72%">
                                                    <span class="sr-only">72% Complete</span>
                                                </div>
                                            </div>
                                            <small>Nombre de SMS envoyés</small>
                                            <div class="progress">
                                                <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
                                                    <span class="sr-only">20% Complete</span>
                                                </div>
                                            </div>             

                                        </div><!--/panel-body-->
                                    </div><!--/panel-->                  
                                    <!--/tabs-->
                                </c:when>
                            </c:choose>
                        </div><!--/col-->
                    </div><!--/row-->                   
                </div><!--/col-span-9-->
            </div>
        </div>
        <!-- /Main -->

        <jsp:include page="include/footer.jsp" />
        <!-- script references -->
        <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/scripts.js"></script>
    </body>
</html>