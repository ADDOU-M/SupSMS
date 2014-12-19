<%-- 
    Document   : listUsers
    Created on : 12 déc. 2014, 11:52:54
    Author     : Ekue_Weledji
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <title>SupSMS | List Invoices</title>
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
                <jsp:include page="/include/menuAdmin.jsp" />
                <!-- /Left column -->

                <div class="col-sm-9">
                    <div class="row">                       
                        <div class="col-md-12">   
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>Nom</th>
                                        <th>Prénom</th>
                                        <th>Téléphone</th>
                                        <th>Montant</th>
                                        <th>Date de paiement</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${factures}" var="facture">
                                        <tr>
                                            <td><c:out value="${facture.utilisateur.nom}" /></td>
                                            <td><c:out value="${facture.utilisateur.prenom}" /></td>
                                            <td><c:out value="${facture.utilisateur.numeroTelephone}" /></td>
                                            <td><c:out value="${facture.montant}" /></td>
                                            <td><c:out value="${facture.datePaiement}" /></td>                                            
                                        </tr>
                                    </c:forEach>                                    
                                </tbody>
                            </table>                                       
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
        <script src="js/scripts.js"></script>
    </body>
</html>
