<%-- 
    Document   : header
    Created on : 10 déc. 2014, 14:34:22
    Author     : Ekue_Weledji
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>    
    <!-- Header -->
    <div id="top-nav" class="navbar navbar-inverse navbar-static-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">SupSMS</a>
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    <c:choose>
                        <c:when test="${not empty user}">
                            <li class="dropdown">
                                <a class="dropdown-toggle" role="button" data-toggle="dropdown" href="#">
                                    <i class="glyphicon glyphicon-user"></i>Bienvenue ${fullName}<span class="caret"></span>
                                </a>
                                <ul id="g-account-menu" class="dropdown-menu" role="menu">
                                    <li><a href="#">My Profile</a></li>
                                </ul>
                            </li>
                        </c:when>
                    </c:choose>
                    <li>
                        <c:choose>
                            <c:when test="${not empty user}">
                                <c:url value="/logout" var="logoutUrl" />
                                <a href="${logoutUrl}"><i class="glyphicon glyphicon-off">Logout</i></a>
                            </c:when>
                            <c:otherwise>
                                <c:url value="/logger" var="loginUrl" />
                                <a href="${loginUrl}"><i class="glyphicon glyphicon-user">Login</i></a>                                
                            </c:otherwise>
                        </c:choose>
                    </li>                    
                </ul>
            </div>
        </div><!-- /container -->
    </div>
    <!-- /Header -->
</html>
