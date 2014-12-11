<%-- 
    Document   : logger
    Created on : 10 déc. 2014, 15:25:32
    Author     : Ekue_Weledji
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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

        <div class="container-fluid">
            <div class="row">
                <!-- Left column -->
                <jsp:include page="/include/menu.jsp" />
                <!-- /Left column -->

                <div class="col-sm-9">
                    <h4>Nouveau contact</h4>
                    <form class="form-inline" method="POST">
                        <div class="col-sm-3">
                            <label>Nom <span class="required">*</span></label>
                            <input name="nom" id = "nom" type="text" class="input-block-level" placeholder="nom">
                            <label>Prénom</label>
                            <input name="prenom" id="prenom" type="text" class="input-block-level" placeholder="prénom">
                            <label>Téléphone<span class="required">*</span></label>
                            <input name="telephone" id = "telephone" type="text" class="input-block-level" placeholder="numéro de téléphone">
                        </div>
                        <div class="col-sm-3">
                            <label>Nom <span class="required">*</span></label>
                            <input name="nom" id = "nom" type="text" class="input-block-level" placeholder="nom">
                            <label>Prénom</label>
                            <input name="prenom" id="prenom" type="text" class="input-block-level" placeholder="prénom">
                            <label>Téléphone<span class="required">*</span></label>
                            <input name="telephone" id = "telephone" type="text" class="input-block-level" placeholder="numéro de téléphone">
                        </div>                        
                        <!--<button type="submit" value="submit" class="btn btn-primary">Sign in</button>-->
                    </form>
                </div><!--/col-span-9-->
            </div>
        </div>
    </body>    

    <!--  /Login form -->
</html>
