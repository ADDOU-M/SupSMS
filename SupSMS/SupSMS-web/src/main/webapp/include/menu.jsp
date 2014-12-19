<%-- 
    Document   : menu
    Created on : 10 déc. 2014, 14:47:32
    Author     : Ekue_Weledji
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <c:choose>
        <c:when test="${not empty user}">
            <div class="col-sm-3">
                <!-- Left column -->
                <a href="#"><strong><i class="glyphicon glyphicon-wrench"></i> Menu </strong></a>  

                <hr>

                <ul class="list-unstyled">
                    <li class="nav-header"> <a href="#" data-toggle="collapse" data-target="#userMenu">
                            <h5>Gestion contacts <i class="glyphicon glyphicon-chevron-down"></i></h5>
                        </a>
                        <ul class="list-unstyled collapse in" id="userMenu">
                            <c:url value="/new-contact" var="addContactUrl" />
                            <li> <a href="${addContactUrl}"><i class="glyphicon glyphicon-home"></i> Ajouter</a></li>
                                <c:url value="/contacts" var="listContactUrl" />
                            <li><a href="${listContactUrl}"><i class="glyphicon glyphicon-envelope"></i> Liste <span class="badge badge-info">${nombreContacts}</span></a></li>                            
                        </ul>
                    </li>

                    <c:choose>
                        <c:when test="${not empty msgEnabled}">
                            <li class="nav-header"> <a href="#" data-toggle="collapse" data-target="#menu2">
                                    <h5>Messagerie <i class="glyphicon glyphicon-chevron-right"></i></h5>
                                </a>

                                <ul class="list-unstyled collapse" id="menu2">
                                    <c:url value="/send-sms" var="sendSMSUrl" />
                                    <li><a href="${sendSMSUrl}">Nouveau Message</a>
                                    </li>
                                    <li><a href="#">Conversations</a>
                                    </li>                            
                                </ul>
                            </li>
                        </c:when>
                    </c:choose>
                    <li class="nav-header">
                        <a href="#" data-toggle="collapse" data-target="#menu3">
                            <h5>Facturations <i class="glyphicon glyphicon-chevron-right"></i></h5>
                        </a>

                        <ul class="list-unstyled collapse" id="menu3">                           
                            <c:url value="/list-invoices" var="listInvoicesUrl" />
                            <li><a href="${listInvoicesUrl}"><i class="glyphicon glyphicon-circle"></i> Mes factures</a></li>
                                <c:choose>
                                    <c:when test="${empty msgEnabled}">
                                    <li><a title="Renew Offer" data-toggle="modal" href="#renewOfferModal">Renouveler</a></li>                                        
                                    </c:when>
                                </c:choose>.
                            <div class="modal" id="renewOfferModal">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                            <h4 class="modal-title">Renouveler offre</h4>
                                        </div>
                                        <div class="modal-body">
                                            <p>Voulez vous vraiment renouveler votre forfait de messagerie?</p>
                                        </div>
                                        <div class="modal-footer">
                                            <a href="#" data-dismiss="modal" class="btn">Annuler</a>
                                            <c:url value="/renew-offer" var="renewOfferUrl" />                                            
                                            <a href="${renewOfferUrl}" class="btn btn-primary">Renouveler</a>
                                        </div>
                                    </div><!-- /.modal-content -->
                                </div><!-- /.modal-dalog -->
                            </div><!-- /.modal -->
                        </ul>
                    </li>
                </ul>
            </div><!-- /col-3 -->

        </c:when>
    </c:choose>

</html>
