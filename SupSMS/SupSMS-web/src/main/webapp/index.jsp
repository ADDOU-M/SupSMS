<%-- 
    Document   : menuBar
    Created on : 10 déc. 2014, 14:34:22
    Author     : Ekue_Weledji
--%>
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
                <!-- /Left column -->

                <div class="col-sm-9">
                    <div class="row">
                        <!-- center left-->	
                        <div class="col-md-6"> 
                            <div class="panel panel-default">
                                <div class="panel-heading"><h4>Reports</h4></div>
                                <div class="panel-body">

                                    <small>Success</small>
                                    <div class="progress">
                                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="72" aria-valuemin="0" aria-valuemax="100" style="width: 72%">
                                            <span class="sr-only">72% Complete</span>
                                        </div>
                                    </div>
                                    <small>Info</small>
                                    <div class="progress">
                                        <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
                                            <span class="sr-only">20% Complete</span>
                                        </div>
                                    </div>
                                    <small>Warning</small>
                                    <div class="progress">
                                        <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                            <span class="sr-only">60% Complete (warning)</span>
                                        </div>
                                    </div>
                                    <small>Danger</small>
                                    <div class="progress">
                                        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                                            <span class="sr-only">80% Complete</span>
                                        </div>
                                    </div>

                                </div><!--/panel-body-->
                            </div><!--/panel-->                  
                            <!--/tabs-->
                        </div><!--/col-->
                        <div class="col-md-6">                         
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <div class="panel-title">
                                        <i class="glyphicon glyphicon-wrench pull-right"></i>
                                        <h4>Inscription</h4>
                                    </div>
                                </div>
                                <div class="panel-body">
                                    <form class="form form-vertical">
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
                                                    <label>Carte de crédit:</label>
                                                    <div class="controls">
                                                        <input type="text" name="carteCredit" class="form-control" placeholder="Numéro carte de crédit">
                                                    </div>
                                                </div> 
                                            </div>
                                            <div class="col-sm-4">
                                                <div class="control-group">
                                                    <label>Mot de passe:</label>
                                                    <div class="controls">
                                                        <input type="password" name="password" class="form-control" placeholder="mot de passe">
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

        <footer class="text-center">This Bootstrap 3 dashboard layout is compliments of <a href="http://www.bootply.com/85850"><strong>Bootply.com</strong></a></footer>
        <!-- script references -->
        <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/scripts.js"></script>
    </body>
</html>