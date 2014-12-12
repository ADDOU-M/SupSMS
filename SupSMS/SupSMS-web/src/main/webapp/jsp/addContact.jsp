<%-- 
    Document   : logger
    Created on : 10 déc. 2014, 15:25:32
    Author     : Ekue_Weledji
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <title>SupSMS | New Contact</title>
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
        <jsp:include page="/include/header.jsp" />
        <!-- /Header -->        

        <!-- Main -->
        <div class="container-fluid">
            <div class="row">
                <!-- Left column -->
                <jsp:include page="/include/menu.jsp" />
                <!-- /Left column -->

                <div class="col-sm-9">
                    <div class="row">                       
                        <div class="col-md-12">                         
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <div class="panel-title">
                                        <i class="glyphicon glyphicon-wrench pull-right"></i>
                                        <h4>Nouveau contact</h4>
                                    </div>
                                </div>
                                <div class="panel-body">
                                    <form id="add-contact-form" class="form form-vertical" method="POST">
                                        <div class="row">
                                            <div class="col-sm-4">
                                                <div class="control-group">
                                                    <label>Nom:</label>
                                                    <div class="controls">
                                                        <input type="text" name="nom" class="form-control" placeholder="votre nom">
                                                    </div>
                                                </div> 
                                            </div>
                                            <div class="col-sm-4">
                                                <div class="control-group">
                                                    <label>Prénom:</label>
                                                    <div class="controls">
                                                        <input type="text" name="prenom" class="form-control" placeholder="votre prénom">
                                                    </div>
                                                </div> 
                                            </div>
                                            <div class="col-sm-4">
                                                <div class="control-group">
                                                    <label>Téléphone:</label>
                                                    <div class="controls">
                                                        <input type="text" name="telephone" class="form-control" placeholder="numéro de téléphone">
                                                    </div>
                                                </div> 
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-sm-4">
                                                <div class="control-group">
                                                    <label>Email:</label>
                                                    <div class="controls">
                                                        <input type="text" name="email" class="form-control" placeholder="adresse mail">
                                                    </div>
                                                </div> 
                                            </div>
                                            <div class="col-sm-4">
                                                <div class="control-group">
                                                    <label>Boîte postale:</label>
                                                    <div class="controls">
                                                        <input type="text" name="boitePostale" class="form-control" placeholder="Numéro carte de crédit">
                                                    </div>
                                                </div> 
                                            </div>                                            
                                        </div><br/>
                                        <div class="control-group">
                                            <label></label>
                                            <div class="controls pull-right">
                                                <button type="reset" class="btn btn-primary">
                                                    Annuler
                                                </button>
                                                <button type="submit" class="btn btn-primary">
                                                    Valider
                                                </button>
                                            </div>
                                        </div>   

                                    </form>
                                </div><!--/panel content-->
                            </div><!--/panel-->             
                        </div><!--/col-span-6-->
                    </div><!--/row-->                   
                </div><!--/col-span-9-->
            </div>
        </div>
        <!-- /Main -->

        <jsp:include page="/include/footer.jsp" />
        <!-- script references -->
        <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.validate.js"></script>
        <script src="js/scripts.js"></script>
    </body>
</html>
