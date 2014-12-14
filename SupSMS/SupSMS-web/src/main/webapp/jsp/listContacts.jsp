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
        <title>SupSMS | List Contacts</title>
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
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>Nom</th>
                                        <th>Prénom</th>
                                        <th>Téléphone</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${contacts}" var="contact">
                                        <tr>
                                            <td><c:out value="${contact.nom}" /></td>
                                            <td><c:out value="${contact.prenom}" /></td>
                                            <td><c:out value="${contact.numeroTelephone}" /></td>
                                            <td>
                                                <c:url value="/new-contact" var="updateContactUrl">
                                                    <c:param name="id" value="${contact.id}" />
                                                </c:url>
                                                <a href="${updateContactUrl}">Modifier</a>
                                            </td>
                                            <td>
                                                <a title="Delete Contact" data-toggle="modal" href="#deleteContactModal${contact.id}">Supprimer</a>
                                            </td>                                    
                                        </tr>
                                    <div class="modal" id="deleteContactModal${contact.id}">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                                    <h4 class="modal-title">Supprimer un contact</h4>
                                                </div>
                                                <div class="modal-body">
                                                    <p>Voulez vous vraiment supprimer ce contact?</p>
                                                </div>
                                                <div class="modal-footer">
                                                    <a href="#" data-dismiss="modal" class="btn">Annuler</a>
                                                    <c:url value="/deleteContact" var="deleteContactUrl">
                                                        <c:param name="id" value="${contact.id}" />
                                                    </c:url>
                                                    <a href="${deleteContactUrl}" class="btn btn-primary">Supprimer</a>
                                                </div>
                                            </div><!-- /.modal-content -->
                                        </div><!-- /.modal-dalog -->
                                    </div><!-- /.modal -->
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
