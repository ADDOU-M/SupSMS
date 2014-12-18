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
        <title>SupSMS | List Users</title>
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
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${users}" var="user">
                                        <tr>
                                            <td><c:out value="${user.nom}" /></td>
                                            <td><c:out value="${user.prenom}" /></td>
                                            <td><c:out value="${user.numeroTelephone}" /></td>
                                            <td>
                                                <c:url value="/sign-up" var="updateUserUrl">
                                                    <c:param name="login" value="${user.login}" />
                                                </c:url>
                                                <a href="${updateUserUrl}">Modifier</a>
                                            </td>
                                            <td>
                                                <a title="Delete User" data-toggle="modal" href="#deleteUserModal${user.id}">Supprimer</a>
                                            </td>
                                        </tr>
                                    <div class="modal" id="deleteUserModal${user.id}">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                                    <h4 class="modal-title">Supprimer un utilisateur</h4>
                                                </div>
                                                <div class="modal-body">
                                                    <p>Voulez vous vraiment supprimer ce utilisateur?</p>
                                                </div>
                                                <div class="modal-footer">
                                                    <a href="#" data-dismiss="modal" class="btn">Annuler</a>
                                                    <c:url value="/deleteUser" var="deleteUserUrl">
                                                        <c:param name="id" value="${user.id}" />
                                                    </c:url>
                                                    <a href="${deleteUserUrl}" class="btn btn-primary">Supprimer</a>
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
